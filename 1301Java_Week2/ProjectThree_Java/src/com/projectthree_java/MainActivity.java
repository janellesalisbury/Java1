package com.projectthree_java;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends Activity {
	
	String _bookmark;
	Context _context;
	Boolean connected = false;
	HashMap<String, String> _history;
	static final int REQUEST_CODE = 0;
	
	
	//CREATE DETAIL VIEW OF API DATA 
	public void updateData(JSONArray data){
		try{
		((TextView) findViewById(R.id.state_name)).setText(data.getString(0));
		((TextView) findViewById(R.id.state_pop)).setText(data.getString(1));
		((TextView) findViewById(R.id.white_pop)).setText(data.getString(2));
		((TextView) findViewById(R.id.black_pop)).setText(data.getString(3));
		((TextView) findViewById(R.id.native_pop)).setText(data.getString(4));
		((TextView) findViewById(R.id.other_pop)).setText(data.getString(5));
		}catch(JSONException e){
			Log.e("JSON ERROR", e.toString());
		}
		
		
	}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_fragment);
        
        _context = this;
        _history = new HashMap<String, String>();
        _bookmark = FileStuff.readStringFile(_context, "bookmark", true);
        
        Log.i("HISTORY READ",_history.toString());

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
    	String baseURL = "http://api.census.gov/data/2010/sf1?key=e44eee8f8d8583f1b0854a96fcbe580d59164a54&get=NAME,P0030001,P0030002,P0030003,P0030004,P0030006&for=state:"+state;
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
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
    	if(resultCode == RESULT_OK && requestCode == REQUEST_CODE){
    		if(data.hasExtra("state")){
    			String state = data.getExtras().getString("state");
    			((EditText) findViewById(R.id.search_field)).setText(state);
    			getInfo(state);
    		}
    	}
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
  