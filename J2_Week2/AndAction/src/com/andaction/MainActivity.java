package com.andaction;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        //STORING STRING RESOURCES INTO AN ARRAY
        String [] actor_names= getResources().getStringArray(R.array.actor_names);
        
        //BINDING TO LIST ADAPTER
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.label, actor_names));
        
        ListView lv = getListView();
        //ONCLICK LISTENER
        lv.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			
			//LAUNCHING NEW ACTIVITY
				Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
				
			//SENDING TO NEW ACTIVITY
				startActivity(i);
				
			}
        	
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
