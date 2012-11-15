package com.projectthree_java;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;

import com.salisbury.libs.Bookmarks;
import com.salisbury.libs.FileStuff;
import com.salisbury.libs.SearchForm;
import com.salisbury.libs.StateDisplays;
import com.salisbury.libs.WebStuff;


import android.view.View.OnClickListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.LinearLayout;




public class MainActivity extends Activity {
	
	Context _context;
	LinearLayout _appLayout;
	SearchForm _search;
	StateDisplays _state;
	Boolean connected = false;
	HashMap<String, String> _history;
	Bookmarks _bookmark;
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        _context = this;
        _appLayout = new LinearLayout(this);
        _history = new HashMap<String, String>();
       
        
        Log.i("HISTORY READ",_history.toString());
        
        //ADD SEARCH FORM
        _search = new SearchForm(_context);
        
        //ADD CLICK EVENT HANDLER
        Button searchButton = _search.getButton();
        
        searchButton.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        		//Get state information 
        		getInfo(_search.getNumber().toString());
        	}
        });
        
        //DETECT NETWORK CONNECTIVITY
        connected = WebStuff.getConnectionStatus(_context);
        if(connected){
        	Log.i("NETWORK CONNECTION", WebStuff.getConnectionType(_context));
        }
        
        //ADD STATE DISPLAY
        _state = new StateDisplays(_context);
        
        //ADD BOOKMARKS
        _bookmark = new Bookmarks(_context);
        
        
         //ADD VIEWS
        _appLayout.addView(_search);
        _appLayout.addView(_state); 
        _appLayout.addView(_bookmark);
        _appLayout.setBackgroundColor(Color.LTGRAY);
        _appLayout.setOrientation(LinearLayout.VERTICAL);
        
        setContentView(_appLayout);
        
    }

   
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    //INFO CALL TO RETRIEVE STATE DATA
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
    @SuppressWarnings({ "unchecked" })
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
    	
    	//create the read/write to storage here
    	@Override
    	protected void onPostExecute(String result){
    		Log.i("URL RESPONSE", result);
    		try{
    			JSONArray json = new JSONArray(result);
    			JSONArray results = json.getJSONArray(1);
    			Log.i("JSON Array", results.toString());
    			StateDisplays.updateData(results);
    			String state = _search.getNumber().toString();
    			_history.put(state, results.toString());
    			FileStuff.storeObjectFile(_context, "history", _history, false);
    			FileStuff.storeObjectFile(_context, "temp", results.toString(), true);
    
    		}catch(JSONException e){
    			Log.e("JSON", "JSON OBJECT EXPECTION");
    		
    		}
    	}
    }
}
  