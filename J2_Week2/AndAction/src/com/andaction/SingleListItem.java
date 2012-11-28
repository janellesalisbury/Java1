package com.andaction;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SingleListItem  extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.single_list_item_view);
		
		TextView txtProduct = (TextView) findViewById(R.id.name_label);
		
		Intent i = getIntent();
		//GETTING ATTACHED INTENT DATA
		String product = i.getStringExtra("product");
		//DISPLAYING SELECTED TEXT
		txtProduct.setText(product);
		
		//CREATE BUTTON/ONCLICK TO SEND TO WEB
		Button url_button;
		url_button = (Button) findViewById(R.id.button_url);
		
		url_button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.imdb.com/search"));
				startActivity(i);
				
				
			}
		
		});
		
		
	}

}
