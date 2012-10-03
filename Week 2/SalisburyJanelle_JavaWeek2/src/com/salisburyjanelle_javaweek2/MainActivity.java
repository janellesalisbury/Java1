package com.salisburyjanelle_javaweek2;
// Java Week 2 Application Project
//Janelle Salisbury 
//Grocery List Application



import java.util.ArrayList;
import com.salisburyjanelle.lib.*;
import com.salisburyjanelle.lib.Grocery;
import com.salisburyjanelle.lib.Items;
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
        
        
 
        LinearLayout formEntry = TextForms.singleEntryWithButton(this, "Add item you wish to purchase", "Add Item");
        Button foodItem = (Button)formEntry.findViewById(2);
        
        
        foodItem.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText grocery = (EditText)v.getTag();
				
			
			
				
				
				
				
				
			}
		});
        
        ArrayList<Grocery> grocery = new ArrayList<Grocery>();
        grocery.add(new Items("Milk", "Dairy"));
        grocery.add(new Items("Mac Apples", "Fruits"));
        grocery.add(new Items("Pork Loin", "Meats"));
        grocery.add(new Items("Asparagus", "Vegetable"));
        grocery.add(new Items("Wheat Bread", "Grains"));
        
        
        ll.addView(mainHeader);
        ll.addView(formEntry);
        setContentView(ll);
        
        
       
        
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
