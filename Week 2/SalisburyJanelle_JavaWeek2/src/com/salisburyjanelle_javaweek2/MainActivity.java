package com.salisburyjanelle_javaweek2;
// Java Week 2 Application Project
//Janelle Salisbury 
//Grocery List Application



import com.salisburyjanelle.lib.TextForms;



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
	int itemCount;
	TextView foodTv;
	EditText et;
	
 @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //LinearLayout from TextForms.java
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        
        //main title header for app
        mainHeader = new TextView(this);
        mainHeader.setText("Grocery Buddy");
        mainHeader.setBackgroundColor(Color.CYAN);
        
        
        foodItems = new TextView(this);
        String food[] = {getString(R.string.item1), getString(R.string.item2), getString(R.string.item3), getString(R.string.item4)};
        itemCount = food.length;
        for(int i=0; i<itemCount; i++){
        	foodItems.append((food[i] + "\n"));
           
        
        
        	
        }    
      
       
        LinearLayout formEntry = TextForms.singleEntryWithButton(this, "Add item you wish to purchase", "Add Item");
        Button foodItem = (Button)formEntry.findViewById(2);
        foodTv = new TextView(this);
        
        foodItem.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText food = (EditText)v.getTag();
				
			
			
				
				
				
				
				
			}
		});
        ll.addView(mainHeader);
        ll.addView(foodItems);
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
