package com.tailor_made;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;



public class MainActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        //STORING STRING RESOURCES INTO ARRAY
        String [] clothing_categories = getResources().getStringArray(R.array.clothing_categories);
        
        //BINDING TO LISTADAPTER
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.label, clothing_categories));
        
        ListView lv = getListView();
        
        //ONCLICK
        lv.setOnItemClickListener(new OnItemClickListener(){
        	public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        	
				String product = ((TextView) view).getText().toString();
				
				//LAUNCHING THE NEW ACTIVITY
				Intent intent = new Intent(getApplicationContext(), SingleListItem.class);
				
				//SEND TO NEW ACTIVITY
				intent.putExtra("product", product);
				startActivity(intent);
        		
        	}
        });
        
      
    }

	
}
