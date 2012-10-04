package com.salisburyjanelle_javaweek2;

import com.salisburyjanelle.lib.TextForms;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.salisburyjanelle.lib.FoodType;
import android.widget.ArrayAdapter; 
import java.util.ArrayList;
import java.util.Arrays;




public class MainActivity extends Activity {
	LinearLayout ll;
	LinearLayout.LayoutParams lp;
	TextView mainHeader;
	EditText et;
	TextView foodTv;
	int itemCount;
	TextView coupon;
	private ListView mainListView ;  
	private ArrayAdapter<String> listAdapter ;  
	    
	
	
 @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        
        //main title header for app
        mainHeader = new TextView(this);
        mainHeader.setText("Grocery Buddy");
        mainHeader.setBackgroundColor(Color.CYAN);
        
     // Find the ListView resource.   
        //mainListView = (ListView) findViewById( R.id.mainListView );  
      
        // Create and populate a List of planet names.  
        //String[] foodTypes = new String[] { "Produce", "Meat", "Grains", "Fruits",  
                                          //"Diary"};    
        //ArrayList<String> //foodTypesList = new ArrayList<String>();  
        //foodTypesList.addAll( Arrays.asList(foodTypes) );  
          
        // Create ArrayAdapter using the planet list.  
        //listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, foodTypesList);  
          
        // Set the ArrayAdapter as the ListView's adapter.  
        //mainListView.setAdapter( listAdapter );        
 	

  
        
        
        //LinearLayout from TextForms.java class
        LinearLayout formEntry = TextForms.singleEntryWithButton(this, "Add item you wish to purchase", "Add Item");
        Button foodItem = (Button)formEntry.findViewById(2);
        
        //onclick to add items to food list
        foodItem.setOnClickListener(new View.OnClickListener() {
			//log works properly
			@Override
			public void onClick(View v) {
				
				// button to enter food to the list of items
				
			
			
				}
		});
        
        
                
        //logging out enum values for food type names
        String dairyEnum = FoodType.DAIRY.toString();
        String meatEnum = FoodType.MEAT.toString();
        String produceEnum = FoodType.PRODUCE.toString();
        String fruitsEnum = FoodType.FRUITS.toString();
        String grainsEnum = FoodType.GRAINS.toString();
  
        
        
        String[] enumArray = {
        		dairyEnum,
        		meatEnum,
        		produceEnum,
        		fruitsEnum,
        		grainsEnum
		
        };
       
        for (int i=0; i<enumArray.length; i++){
        	String logEnumStr = enumArray[i];
        	Log.i("SHOW LOGGED ENUM: ", logEnumStr);
        	
        }
        
        // coupon pulled from API eventually
        coupon = new TextView(this);
        coupon.setText("This is where the coupon will pop up if there is one!");

        ll.addView(mainHeader);
        //ll.addView(mainListView);
        ll.addView(formEntry);
        ll.addView(coupon);
        setContentView(ll);
        
        
       
        
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
