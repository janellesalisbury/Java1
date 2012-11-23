package com.tailor_made;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class SingleListItem extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.single_list_item_view);
 
        TextView txtProduct = (TextView) findViewById(R.id.product_label);
 
        Intent i = getIntent();
        // getting attached intent data
        String product = i.getStringExtra("product");
        // displaying selected product name
        txtProduct.setText(product);
        
  Button button;
  	button = (Button) findViewById(R.id.buttonUrl);
  	
  	button.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
			startActivity(i);

			
		}
	});
   
    	}
    }
 