package com.salisburyjanelle_javaweek2;
// Java Week 2 Application Project
//Janelle Salisbury 
//Grocery List Application



import java.util.ArrayList;
import com.salisburyjanelle.lib.*;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends Activity {
	LinearLayout ll;
	LinearLayout.LayoutParams lp;
	TextView mainHeader;
	EditText et;
	TextView foodTv;
	int itemCount;
	
	
 @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        
        //main title header for app
        mainHeader = new TextView(this);
        mainHeader.setText("Grocery Buddy");
        mainHeader.setBackgroundColor(Color.CYAN);
        
        //just a mock up of the list that would be pulled using the array (this is in resources for now)
        
        //LinearLayout from TextForms.java class
        LinearLayout formEntry = TextForms.singleEntryWithButton(this, "Add item you wish to purchase", "Add Item");
        Button foodItem = (Button)formEntry.findViewById(2);
        
        //onclick to add items to food list
        foodItem.setOnClickListener(new View.OnClickListener() {
			//log works properly
			@Override
			public void onClick(View v) {
				EditText food = (EditText)v.getTag();
				
				
			
			
				}
		});
        
        
        // coupon pulled from API eventually
        
        ll.addView(mainHeader);
        ll.addView(foodTv);
        ll.addView(formEntry);
        setContentView(ll);
        
        
       
        
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
