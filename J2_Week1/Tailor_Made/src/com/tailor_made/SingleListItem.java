package com.tailor_made;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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
        
        //STORING STRING RESOURCES INTO ARRAY
        String [] shirt_types = getResources().getStringArray(R.array.shirt_types);
        
        //BINDING TO LISTADAPTER
        //this.setListAdapter(new ArrayAdapter<String>(this, R.layout.shirt_item, R.id.label, shirt_types));
 
    }
}
