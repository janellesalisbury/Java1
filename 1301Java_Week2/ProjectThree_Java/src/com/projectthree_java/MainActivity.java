package com.projectthree_java;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import android.view.View.OnClickListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends Activity {
	
	Context _context;
	Boolean connected = false;
	HashMap<String, String> _history;
	static final int REQUEST_CODE = 0;

	public void updateData(JSONArray data){
		try{
		((TextView) findViewById(R.id.state_name)).setText(data.getString(5));
		((TextView) findViewById(R.id.state_pop)).setText(data.getString(0));
		((TextView) findViewById(R.id.white_pop)).setText(data.getString(1));
		((TextView) findViewById(R.id.black_pop)).setText(data.getString(2));
		((TextView) findViewById(R.id.native_pop)).setText(data.getString(3));
		((TextView) findViewById(R.id.other_pop)).setText(data.getString(4));
		}catch(JSONException e){
			Log.e("JSON ERROR", e.toString());
		}
		
		
	}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        _context = this;
        _history = new HashMap<String, String>();
        
        Log.i("HISTORY READ",_history.toString());
        
        //ADD CLICK EVENT HANDLER FOR SEARCH FEATURE
        Button searchButton = (Button) findViewById(R.id.search_button);
        searchButton.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        		EditText field = (EditText) findViewById(R.id.search_field);
        		String state = field.getText().toString();
        		field.setText(state);
        		//Get state information 
        		getInfo(state);
        		InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        		imm.hideSoftInputFromInputMethod(field.getWindowToken(), 0);
        		getInfo(state);
        	}
        });
        
        //CREATE BOOKMARKS BUTTON
        Button bkmkButton = (Button) findViewById(R.id.bookmark_button);
        bkmkButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			Intent i = new Intent(_context, Bookmark.class);
			startActivityForResult(i, REQUEST_CODE);
			
				
			}
		});
        
        //ADD BOOKMARK BUTTON
        
        
        
        
        
        //DETECT NETWORK CONNECTIVITY
        connected = WebStuff.getConnectionStatus(_context);
        if(connected){
        	Log.i("NETWORK CONNECTION", WebStuff.getConnectionType(_context));
        }
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    private void getInfo(String state){
    	String baseURL = "http://api.census.gov/data/2010/sf1?key=e44eee8f8d8583f1b0854a96fcbe580d59164a54&get=P0030001,P0030002,P0030003,P0030004,P0030006&for=state:"+state;
    	Log.i("GET INFO CALL", baseURL);
    	URL finalURL;
    	try{
    		finalURL = new URL(baseURL);
    		StateRequest sr = new StateRequest();
    		sr.execute(finalURL);
    	}catch(MalformedURLException e){
    		Log.e("BAD URL", "MALFORMED URL");
    		finalURL = null;
    	}
    }
    @SuppressWarnings({ "unchecked", "unused" })
	private HashMap<String, String> getHistory(){
    	Object stored = FileStuff.readObjectFile(_context, "history", false);
    	
    	HashMap<String, String> history;
    	if(stored == null){
    		Log.i("HISTORY", "NO HISTORY FILE FOUND");
    		history = new HashMap<String, String>();
    	}else{
    		history = (HashMap<String, String>) stored;
    	}
    	return history;
    }
    private class StateRequest extends AsyncTask<URL, Void, String>{
    	@Override
    	protected String doInBackground(URL...urls){
    		String response = "";
    		for(URL url: urls){
    			response = WebStuff.getURLStringResponse(url);
    		}
    		return response;
    	}
    	
    	@Override
    	protected void onPostExecute(String result){
    		Log.i("URL RESPONSE", result);
    		try{
    			JSONArray json = new JSONArray(result);
    			JSONArray results = json.getJSONArray(1);
    			Log.i("JSON Array", results.toString());
    			updateData(results);
    		}catch(JSONException e){
    			Log.e("JSON EXCEPTION", "::"+result);
    		
    		}
    	}
    }
}
  