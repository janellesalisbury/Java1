package com.projectthree_java;


import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.salisbury.libs.FileStuff;
import com.salisbury.libs.SearchForm;
import com.salisbury.libs.StateDisplays;
import com.salisbury.libs.WebStuff;

import android.view.View.OnClickListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;



public class MainActivity extends Activity {
	
	Context _context;
	LinearLayout _appLayout;
	SearchForm _search;
	StateDisplays _state;
	Boolean connected = false;
	HashMap<String, String> _history;
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        _context = this;
        _appLayout = new LinearLayout(this);
        _history = new HashMap<String, String>();
        
        //ADD SEARCH FORM
        _search = new SearchForm(_context);
        
        //ADD CLICK EVENT HANDLER
        Button searchButton = _search.getButton();
        
        searchButton.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        		//Get state information 
        		getInfo(_search.getSelectedItem().toString());
        	}
        });
        
        //DETECT NETWORK CONNECTIVITY
        connected = WebStuff.getConnectionStatus(_context);
        if(connected){
        	Log.i("NETWORK CONNECTION", WebStuff.getConnectionType(_context));
        }
        
        //ADD STATE DISPLAY
        _state = new StateDisplays(_context);
        
        
        
         //ADD VIEWS
        _appLayout.addView(_search);
        _appLayout.addView(_state);        
        _appLayout.setOrientation(LinearLayout.VERTICAL);
        
        setContentView(_appLayout);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    private void getInfo(String state){
    	String baseURL = "http://api.census.gov/data/2010/sf1?key=e44eee8f8d8583f1b0854a96fcbe580d59164a54&get=P0010001,NAME&for=state:*";
    	String yql = " http://api.census.gov/data/2010/acs5?key=e44eee8f8d8583f1b0854a96fcbe580d59164a54&get=B02001_001E,NAME&for=state:06";
    	String qs;
    	try{
    		qs = URLEncoder.encode(yql, "UTF-8");
    	}catch(Exception e){
    		Log.e("BAD URL", "ENCODING PROBLEM");
    		qs = "";
    	}
    	URL finalURL;
    	try{
    		finalURL = new URL(baseURL + "?q=" + qs + "format=json");
    		StateRequest sr = new StateRequest();
    		sr.execute(finalURL);
    	}catch(MalformedURLException e){
    		Log.e("BAD URL", "MALFORMED URL");
    		finalURL = null;
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
    			JSONObject json = new JSONObject(result);
    			JSONObject results = json.getJSONObject("query").getJSONObject("results").getJSONObject("row");
    			if(results.getString("").compareTo("N/A") ==0){
    				Toast toast = Toast.makeText(_context, "INVALID STATE", Toast.LENGTH_SHORT);
    				toast.show();
    			}else{
    				Toast toast = Toast.makeText(_context, "VALID STATE" + results.getString("state"), Toast.LENGTH_SHORT);
    				toast.show();
    				_history.put(results.getString("state"), results.toString());
    				FileStuff.storeObjectFile(_context, "temp", results.toString(), true);
    			}
    		}catch(JSONException e){
    			Log.e("JSON", "JSON OBJECT EXPECTION");
    		
    		}
    	}
    }
}
