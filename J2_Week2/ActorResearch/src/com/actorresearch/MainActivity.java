package com.actorresearch;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	String[] actors = {"Jim Carrey", "John Wayne", "Penelope Cruz", "Marilyn Monroe", "Johnny Depp", "Chevy Chase", "Matthew McConaughey",
			"Judy Garland", "Clint Eastwood"};
			
	 @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ListView mainListView = (ListView) findViewById(R.id.mainListView);
	    mainListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, actors));
	    mainListView.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				//LAUNCH NEW ACTIVITY CLASS
				Intent intent = new Intent(getApplicationContext(), WebView.class);
				//SEND TO NEW ACTIVITY
				startActivity(intent);
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				Log.i("ERROR", "Select an item");
				
			}
	    	
	    });
	    
	 }
 }
