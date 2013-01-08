package com.restaurantjunkie;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SecondActivity extends ListActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second); 
		
		String restaurantName = getIntent().getExtras().getString("restaurant_name");
		setTitle("Feed Me:"+restaurantName);
		
		setListAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,
				getResources().getStringArray(R.array.restaurants)));
		
		ListView lv = getListView();
		
		//OnClick
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Intent internet = new Intent(Intent.ACTION_VIEW, Uri.parse("http://api.v3.factual.com/t/restaurants?key=gPkail5I7qZheLWqk085rXmWu68IXLw1lqGHEqIw"));
				startActivity(internet);
					
				}
				
			});
		
	}

}

	

	


