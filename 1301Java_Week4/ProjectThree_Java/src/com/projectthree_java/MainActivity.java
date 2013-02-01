package com.projectthree_java;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.Spinner;
import android.widget.TextView;





public class MainActivity extends Activity implements MainFragment.MainListener, BookmarkFragment.BookmarkListener {
	


	Context mContext;
	String _bookmark;
	Context _context;
	Boolean connected = false;
	HashMap<String, String> _history;
	static final int REQUEST_CODE = 0;
	JSONParser parser = new JSONParser();
	
	

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
    
    private void getInfoOffline(String file) {
    	//WRITE CODE TO get the state name out of the spinner, and read the history file for that state using library functions
    	try{
			JSONArray json = new JSONArray(file);
			JSONArray results = json.getJSONArray(1);
			Log.i("Look here", results.toString());
			Log.i("Read me", getFilesDir().toString() + "/" + results.getString(0));
			updateData(results);
			FileInputStream in = null;
			InputStreamReader reader = null;
			try {
			    char[] inputBuffer = new char[256];
			    in = openFileInput("myfile.txt");
			    reader = new InputStreamReader(in);
			    reader.read(inputBuffer);
			    String myText = new String(inputBuffer);
			} catch (Exception e) {;}
			finally {
			    try {
			        if (reader != null)reader.close();
			    } catch (IOException e) {; }
			    try {
			        if (in != null)in.close();
			    } catch (IOException e) {;}
			}
		}catch(JSONException e){
			Log.e("JSON EXCEPTION", "::"+file);
		
		}
	}


//			try {
//				 
//				InputStream instream = openFileInput(getFilesDir().toString() + "/" + results.getString(0));
//				if (instream != null) {
//				      // prepare the file for reading
//				      InputStreamReader inputreader = new InputStreamReader(instream);
//				      BufferedReader buffreader = new BufferedReader(inputreader);
//				                 
//				      String line;
//				 
//				      // read every line of the file into the line-variable, on line at the time
//				      while (( line = buffreader.readLine())) {
//				        
//				      }
//				 
//				    }
//				     
//				    // close the file again       
//				    instream.close();
//				  } catch (java.io.FileNotFoundException e) {
//				    // do something if the myfilename.txt does not exits
//				  }
//		}finally{
//			
//		}
//	}
		

    
    
    
    //INFO CALL TO SEARCH CENSUS API
    private void getInfoOnline(String state){
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
    //HISTORY HASHMAP TO READ THE HISTORY FILE
    @SuppressWarnings({ "unchecked", "unused" })
	private HashMap<String, String> getHistory() throws FileNotFoundException, IOException, ParseException{
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
    
    
    
    
//    //BOOKMARK STUFF
//    protected void onActivityResult(int requestCode, int resultCode, Intent data){
//    	if(resultCode == RESULT_OK && requestCode == REQUEST_CODE){
//    		if(data.hasExtra("state")){
//    			//String selected = state_names.getItemAtPosition(pos).toString();
//    			String state = data.getExtras().getString("state");
//    			Spinner state_names = (Spinner) findViewById(R.id.spinner);
//    			getInfoOnline(state);
//    		}
//    	}
//    }

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
    			Log.i("Here I am", getFilesDir().toString() + "/" + results.getString(0));
    			updateData(results);
    			try {
    				 
    				FileWriter file = new FileWriter(getFilesDir().toString() + "/" + results.getString(0));
    				file.write(results.toString());
    				file.flush();
    				file.close();
    		 
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}catch(JSONException e){
    			Log.e("JSON EXCEPTION", "::"+result);
    		
    		}
    	}
    }

	//SEARCH FUNCTIONALITY
	@Override
	public void onStateSearch(String state) {
		//write conditional to run getInfoOnline if online and getInfoOffline if offline
		if(connected == true){
			getInfoOnline(state);
	
		}else{
			getInfoOffline(state);
		}
		
	}

//	//START BOOKMARK VIEW FUNCTIONALITY
	@Override
	public void onBookmarkList() {
		Intent i = new Intent(_context, Bookmark.class);
		startActivityForResult(i, REQUEST_CODE);

		}

//	//ADD BOOKMARK FUNCTIONALITY
	@Override
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

	@Override
	public void onBookmarkSelected(String state) {
		// TODO Auto-generated method stub
		
	}

	

}