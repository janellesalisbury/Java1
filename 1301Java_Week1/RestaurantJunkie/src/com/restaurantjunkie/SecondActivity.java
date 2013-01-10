package com.restaurantjunkie;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class SecondActivity extends ListActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second); 
		
		//create the passing of the restaurant name for the title of activity
		String restaurantName = getIntent().getExtras().getString("restaurant_name");
		setTitle("Feed Me:"+restaurantName);
		
		
		//button to return to home page(main activity)
		Button returnHome = (Button) findViewById(R.id.back_button);
		returnHome.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 Intent returnIntent = new Intent();
				 returnIntent.putExtra("result",RESULT_OK);
				 setResult(RESULT_OK,returnIntent);     
				 finish();
				
			}
		});
		
		//set listview of restaurants (dummy data) 
		setListAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,
				getResources().getStringArray(R.array.restaurants)));
		
		ListView lv = getListView();
		
		//OnClick to open third activity (which will be the restaurant info)
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Intent internet = new Intent(Intent.ACTION_VIEW, Uri.parse("http://factual.com"));
				startActivity(internet);
					
				}
				
			});
		
	}

}

	

	


