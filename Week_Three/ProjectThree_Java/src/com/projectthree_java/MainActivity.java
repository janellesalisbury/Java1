/*
 * project ProjectThree_Java
 * package com.projectthree_java
 * @author Janelle Salisbury
 * date Mar 18, 2013
 */
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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;



// TODO: Auto-generated Javadoc
/**
 * The Class MainActivity.
 */
public class MainActivity extends Activity {
	
	Context _context;
	LinearLayout _appLayout;
	SearchForm _search;
	StateDisplays _state;
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
        _state = new StateDisplays(_context);

         //ADD VIEWS
        _appLayout.addView(_search);
        _appLayout.addView(_state);        
        _appLayout.setOrientation(LinearLayout.VERTICAL);
        
        setContentView(_appLayout);
        
    }

    /* (non-Javadoc)
     * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        //REMOVE THE TITLE FROM THE MENU BAR
        getActionBar().setDisplayShowTitleEnabled(false);
        return true;
    }
    
    /* (non-Javadoc)
     * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
     */
    //FUNCTIONALITY FOR ACTION BAR ITEMS
    @Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case R.id.action_refresh:
			//FOR TESTING PURPOSES, WILL CONTAIN ACTUAL FUNCTIONALITY SHORTLY
			Toast.makeText(this, "Refresh Selected", Toast.LENGTH_SHORT).show();
			break;
		case R.id.action_search:
			//FOR TESTING PURPOSES, WILL CONTAIN ACTUAL FUNCTIONALITY SHORTLY
			Toast.makeText(this, "Search Selected", Toast.LENGTH_SHORT).show();
			break;
		case R.id.action_share:
			//FOR TESTING PURPOSES, WILL CONTAIN ACTUAL FUNCTIONALITY SHORTLY
			Toast.makeText(this, "Share Selected", Toast.LENGTH_SHORT).show();
			break;
		case R.id.action_user:
			//FOR TESTING PURPOSES, WILL CONTAIN ACTUAL FUNCTIONALITY SHORTLY
			Toast.makeText(this, "Developer Info Selected", Toast.LENGTH_SHORT).show();
			break;
		}
		return true;
		
	}
    
    /**
     * Gets the info.
     *
     * @param state the state
     * @return the info
     */
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
    			StateDisplays.updateData(results);
    		}catch(JSONException e){
    			Log.e("JSON", "JSON OBJECT EXPECTION");
    		
    		}
    	}
    }
}
  