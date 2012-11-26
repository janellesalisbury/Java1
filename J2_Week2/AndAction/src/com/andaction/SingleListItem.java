package com.andaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SingleListItem extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.single_list_item_view);
		
		TextView txtProduct = (TextView)findViewById(R.id.name_label);
		
		Intent i = getIntent();
		
		//GETTING ATTACHED INTENT DATA
		String product = i.getStringExtra("product");
		
		//DISPLAYING SELECTED NAME
		txtProduct.setText(product);
		
	}
	

}
