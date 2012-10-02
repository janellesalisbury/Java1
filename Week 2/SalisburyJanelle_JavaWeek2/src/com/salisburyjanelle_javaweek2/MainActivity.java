package com.salisburyjanelle_javaweek2;
// Java Week 2 Application Project
//Janelle Salisbury 
//Grocery List Application

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
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
	TextView foodItems;
	EditText et;
	int itemCount;
	TextView secondHeader;
	
	
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
       ll = new LinearLayout (this);
       ll.setOrientation (LinearLayout.VERTICAL);
       lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
       ll.setLayoutParams(lp);
       
        
        
        //set up header
        mainHeader = new TextView(this);
        mainHeader.setText("Grocery Buddy");
        mainHeader.setBackgroundColor(Color.LTGRAY);
        mainHeader.setTextColor(Color.BLACK);
        
        foodItems = new TextView(this);
        String foods[] = {getString(R.string.item1), getString(R.string.item2), getString(R.string.item3), getString(R.string.item4)};
        itemCount = foods.length;
        for (int i=0; i<itemCount; i++){
        foodItems.append((foods[i] + "\n'"));
        
        }
        et = new EditText(this);
        et.setHint("Enter food you wish to purchase here");
        
        Button b = new Button(this);
        b.setText("Add to List");
        
        secondHeader = new TextView(this);
        secondHeader.setText("Coupon Deals");
        secondHeader.setTextColor(Color.BLACK);
        secondHeader.setBackgroundColor(Color.MAGENTA);
        
        b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String entry = et.getText().toString();
				foodItems.append(entry + "\r\n");
				
				
			}
		});
        
        ll.addView(mainHeader);
        ll.addView(foodItems);
        //ll.addView(et);
        //ll.addView(b);
       
        LinearLayout form = new LinearLayout(this);
        form.setOrientation(LinearLayout.VERTICAL);
        
        form.setLayoutParams(lp);
        form.addView(et);
        form.addView(b);
        form.addView(secondHeader);
        
        
         ll.addView(form);
        
        setContentView(ll);
        
        
        
      
       
        
        
        
        
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
