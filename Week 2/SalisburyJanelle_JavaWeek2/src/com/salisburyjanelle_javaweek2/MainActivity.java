package com.salisburyjanelle_javaweek2;
// Java Week 2 Application Project
//Janelle Salisbury 
//Grocery List Application




import com.salisburyjanelle.lib.*;
import com.salisburyjanelle.lib.FoodType;
import com.salisburyjanelle.lib.Grocery;
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
	TextView coupon;
	
	
 @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        
        //main title header for app
        mainHeader = new TextView(this);
        mainHeader.setText("Grocery Buddy");
        mainHeader.setBackgroundColor(Color.CYAN);
        
        
        
        //LinearLayout from TextForms.java class
        LinearLayout formEntry = TextForms.singleEntryWithButton(this, "Add item you wish to purchase", "Add Item");
        Button foodItem = (Button)formEntry.findViewById(2);
        
        //onclick to add items to food list
        foodItem.setOnClickListener(new View.OnClickListener() {
			//log works properly
			@Override
			public void onClick(View v) {
				EditText food = (EditText)v.getTag();
				Log.i("Button Clicked", food.getText().toString());
				
				//String meat = FoodType.MEAT.toString();
				//String dairy = FoodType.DAIRY.toString();
				//String produce = FoodType.PRODUCE.toString();
				//String grain = FoodType.GRAINS.toString();
				//String fruit = FoodType.FRUITS.toString();
				//String[]listArray = {meat, dairy, produce, fruit, grain};
				
				//if (FoodType.MEAT.toString() == "meat"){
					//for(int i = 0; i<listArray.length; i++){
						//String s = listArray[i];
						//Log.i("Your Food Type is", s);
					//}
				//}
				
				
			
			
				}
		});
        
        
        // coupon pulled from API eventually
        coupon = new TextView(this);
        coupon.setText("This is where the coupon will pop up if there is one!");
        
        
        
        
        ll.addView(mainHeader);
        ll.addView(foodTv);
        ll.addView(coupon);
        ll.addView(formEntry);
        setContentView(ll);
        
        
       
        
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
