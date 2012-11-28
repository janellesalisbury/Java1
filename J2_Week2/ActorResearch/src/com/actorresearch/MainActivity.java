package com.actorresearch;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
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
	 @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //CREATE BUTTON/ONCLICK
        Button doSearch = (Button) findViewById(R.id.button1);
        doSearch.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				
				ListView mainListView = (ListView) findViewById(R.layout.activity_main);
			    mainListView.setListAdapter(ArrayAdapter.createFromResource(getApplicationContext(), 
			    		R.array.actor_names, R.layout.activity_main));
			    mainListView.setOnItemSelectedListener(new OnItemSelectedListener(){

					@Override
					public void onItemSelected(AdapterView<?> parent, View v,
							int position, long id) {
						
						//LAUNCH NEW ACTIVITY
						Intent intent = new Intent(getApplicationContext(), WebView.class);
						
						//SEND TO NEW ACTIVITY
						startActivity(intent);
						
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
						
						
					}
			    	
			    });
			      
			    
				
				
			}
        	
        });
        
       
       
       
        
        
        
    }
 }
