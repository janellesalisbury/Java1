package com.weektwojava_jsalisbury;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.salisbury.lib.*;
import com.weektwojava_jsalisbury.*;


public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //set up new linear layout 
        LinearLayout ll = new LinearLayout(this);
    		
        //add button and edit text from setLayout class
    	LinearLayout stateEntry = SetLayouts.singleEntryWithButton(this, "Enter State Here", "Retrieve Data");
    	
    	Button retrieveButton = (Button) stateEntry.findViewById(2);
    	
    	//button onClick
    	retrieveButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText name = (EditText) v.getTag();
				String stateinfo = "API data will be searched by state entered";
				//Log out user input
				Log.i("Button Clicked:", stateinfo);
				
			}
		});
    	
   
    	
  
    	ll.addView(stateEntry);
    	setContentView(ll);
    	
   } 	
   	
 
    	//get developer key from resources
        //final String APIDeveloperKey  = new CensusRecord(getString(R.string.APIDeveloperKey));
        
        
        
        
        
        
       // new text view for api data to be added later
//        totalPopTV = new TextView(this);
//        totalMenTV = new TextView(this);
//        totalWomenTV = new TextView(this);
//        percentMenTV = new TextView(this);
//        percentWomenTV = new TextView(this);
        
        
				
				
				//replace this with API records at later time
				//make empty census record
//				CensusRecord myCensusRecord = new CensusRecord();
//				myCensusRecord.setLocation(zipCode);
//				myCensusRecord.setTotalPopulation(100000);
//				myCensusRecord.setTotalMen(50000);
//				myCensusRecord.setTotalWomen(50000);
				
				//replace with api data
				//CensusRecord myCensusRecord = new CensusRecord(zipCode, APIDeveloperKey);
				
				
				//update text views for data
//				totalPopTV.setText(myCensusRecord.getTotalPopulation().toString());
//				totalMenTV.setText(myCensusRecord.getTotalMen().toString());
//				totalWomenTV.setText(myCensusRecord.getTotalWomen().toString());
//				percentMenTV.setText(Float.toString(myCensusRecord.getPercentMen()));
//				percentWomenTV.setText(Float.toString(myCensusRecord.getPercentMen()));
//				
				
	
		//	}
		//});
        
        
       
        
        
      //show text
//		ll.addView(totalMenTV);
//		ll.addView(totalPopTV);
//		ll.addView(totalWomenTV);
//		ll.addView(percentMenTV);
//		ll.addView(percentWomenTV);
//        
        
        

    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
