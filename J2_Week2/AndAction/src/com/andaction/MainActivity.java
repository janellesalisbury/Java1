package com.andaction;

import android.os.Bundle;
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
        //setContentView(R.layout.activity_main);
        
        
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
				String product = ((TextView) view).getText().toString();
			
			//LAUNCHING NEW ACTIVITY
				Intent intent = new Intent(getApplicationContext(), SingleListItem.class);
			//SENDING TO NEW ACTIVITY
				intent.putExtra("product", product);
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
