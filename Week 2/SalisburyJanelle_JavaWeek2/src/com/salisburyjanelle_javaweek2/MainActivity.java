package com.salisburyjanelle_javaweek2;
// Java Week 2 Application Project
//Janelle Salisbury 
//Grocery List Application

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
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
        String foods[] = {getString(R.string.item1), getString(R.string.item2), getString(R.string.item3)};
        itemCount = foods.length;
        
        et = new EditText(this);
        et.setHint("Enter food you wish to purchase here");
        
        Button b = new Button(this);
        b.setText("Add to List");
        
        
        
       
       
        
        
      
        ll.addView(mainHeader);
        
        setContentView(ll);
        
        
        
      
       
        
        
        
        
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
