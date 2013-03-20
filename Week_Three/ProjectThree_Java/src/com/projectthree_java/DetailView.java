/*
 * project ProjectThree_Java
 * package com.projectthree_java
 * @author Janelle Salisbury
 * date Mar 19, 2013
 */
package com.projectthree_java;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class DetailView.
 */
public class DetailView extends Activity{
	//GLOBAL VARIABLES
	Context _context;
	LinearLayout _appLayout;
	SearchForm _search;
	StateDisplaysTwo _state;
	Boolean connected = false;
	HashMap<String, String> _history;

	
	 /* (non-Javadoc)
 	 * @see android.app.Activity#onCreate(android.os.Bundle)
 	 */
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
	        _state = new StateDisplaysTwo(_context);
	        
	        //ADD VIEWS
	        _appLayout.addView(_search);
	        _appLayout.addView(_state);        
	        _appLayout.setOrientation(LinearLayout.VERTICAL);
	        
	        setContentView(_appLayout);
	       
	 }
	 
	 /**
 	 * Gets the info.
 	 *
 	 * @param state the state
 	 * @return the info
 	 */
 	private void getInfo(String state){
	    	String baseURL = "http://api.census.gov/data/1990/sf1?key=e44eee8f8d8583f1b0854a96fcbe580d59164a54&get=P0010001,P0060001,P0060002,P0060003,P0060005&for=state:"+state;
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
	    
	    /**
	     * Gets the history.
	     *
	     * @return the history
	     */
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
	    
	    /**
	     * The Class StateRequest.
	     */
	    private class StateRequest extends AsyncTask<URL, Void, String>{
	    	
		    /* (non-Javadoc)
		     * @see android.os.AsyncTask#doInBackground(Params[])
		     */
		    @Override
	    	protected String doInBackground(URL...urls){
	    		String response = "";
	    		for(URL url: urls){
	    			response = WebStuff.getURLStringResponse(url);
	    		}
	    		return response;
	    	}
	    	
	    	/* (non-Javadoc)
		     * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
		     */
		    @Override
	    	protected void onPostExecute(String result){
	    		Log.i("URL RESPONSE", result);
	    		try{
	    			JSONArray json = new JSONArray(result);
	    			JSONArray results = json.getJSONArray(1);
	    			Log.i("JSON Array", results.toString());
	    			StateDisplaysTwo.updateData(results);
	    		}catch(JSONException e){
	    			Log.e("JSON", "JSON OBJECT EXPECTION");
	    		
	    		}
	    	}
	    }
	    
	}

		



