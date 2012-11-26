package com.andaction;

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
			//SELECTED ITEM
				String result = ((TextView) view).getText().toString();
				
			//LAUNCHING NEW ACTIVITY
				Intent i = new Intent(getApplicationContext(), SingleListItem.class);
				
			//SENDING TO NEW ACTIVITY
				i.putExtra("result", result);
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
