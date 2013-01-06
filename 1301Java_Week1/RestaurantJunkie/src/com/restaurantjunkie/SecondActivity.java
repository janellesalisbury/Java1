package com.restaurantjunkie;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class SecondActivity extends ListActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second); 
		
		setListAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,
				getResources().getStringArray(R.array.restaurants)));

		
	}
}
