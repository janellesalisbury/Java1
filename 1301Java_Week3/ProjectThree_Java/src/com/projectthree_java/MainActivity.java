package com.projectthree_java;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;





public class MainActivity extends Activity implements MainFragment.MainListener, BookmarkFragment.BookmarkListener {
	
	Context mContext;
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
       
//        //ADDING STATES TO DATABASE
//        ContentValues values = new ContentValues();
//        values.put(StatesProvider.STATES, "California");
//        values.put(StatesProvider.ABBREVIATION, "CA");
//        values.put(StatesProvider.POPULATION, "37253956");
//        Uri uri = getContentResolver().insert(StatesProvider.CONTENT_URI, values);
//        
//        values.clear();
//        values.put(StatesProvider.STATES, "Vermont");
//        values.put(StatesProvider.ABBREVIATION, "VT");
//        values.put(StatesProvider.POPULATION, "625741");
//        
//        Uri allStates = Uri.parse("content://com.projectthree_java.provider.States/state");
//		Cursor c = getContentResolver().query(allStates, null, null, null, "statedesc");
//		if(c.moveToFirst()){
//			do{
//				Toast.makeText(this, c.getString(c.getColumnIndex(StatesProvider._ID)) + "," +c.getString(c.getColumnIndex(StatesProvider.ABBREVIATION))
//						+ "," + c.getString(c.getColumnIndex(StatesProvider.POPULATION)), Toast.LENGTH_LONG).show();
//			}while(c.moveToNext());
//		}
//        
       
        
         
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
////    //DISPLAY STATE
//    private void DisplayState(Cursor c) {
//		Toast.makeText(this, "id:" + c.getString(0) + "\n" + "STATE:" + c.getString(1) + "\n" + "ABREVIATION:" + c.getString(2)
//				+ "\n" + "POPULATION:" + c.getString(3) + "\n",
//				 Toast.LENGTH_LONG).show();
//}

  	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    //INFO CALL TO SEARCH CENSUS API
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
    //HISTORY HASHMAP
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
    
    //BOOKMARK STUFF
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
    	if(resultCode == RESULT_OK && requestCode == REQUEST_CODE){
    		if(data.hasExtra("state")){
    			String state = data.getExtras().getString("state");
    			((EditText) findViewById(R.id.search)).setText(state);
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

	//SEARCH FUNCTIONALITY
	@Override
	public void onStateSearch(String state) {
		getInfo(state);
		
	}

//	//START BOOKMARK VIEW FUNCTIONALITY
	@Override
	public void onBookmarkList() {
		Intent i = new Intent(_context, Bookmark.class);
		startActivityForResult(i, REQUEST_CODE);
		
		}
//
//	//ADD BOOKMARK FUNCTIONALITY
//	@Override
	public void onAddBookmark() {
		String stateInfo = String.valueOf("");
		if(stateInfo !=null){
			if(_bookmark.length() > 0){
				_bookmark = _bookmark.concat(","+stateInfo);
			}else{
				_bookmark = stateInfo;
				
			}
			FileStuff.storeStringFile(_context, "bookmark", _bookmark, true);
		}
		
	}
//
//	@Override
	public void onBookmarkSelected(String state) {
		getInfo(state);
		
	};



} 