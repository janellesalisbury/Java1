package com.lights_camera_action;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setListAdapter (new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.actors)));
        
        ListView lv = getListView();
        
        //ONCLICK LISTENER
        lv.setOnItemClickListener(new OnItemClickListener(){
        	@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,long id) {
        		//LAUNCHING NEW ACTIVITY
        		Intent intent = new Intent(getApplicationContext(), SingleListItem.class);
        		//SEND TO NEW ACTIVITY
        		startActivity(intent);
        		
				
        	}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
