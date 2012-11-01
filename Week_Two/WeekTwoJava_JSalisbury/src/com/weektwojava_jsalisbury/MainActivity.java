package com.weektwojava_jsalisbury;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.salisbury.lib.*;
import com.weektwojava_jsalisbury.StateInfo;
import com.weektwojava_jsalisbury.CensusRecords;
import com.weektwojava_jsalisbury.StateInfo;


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
				
				//pulling enum data and logging it to LogCat (temporary until I can figure out something)
		    	String al = States.ALABAMA.toString();
		    	String ak = States.ALASKA.toString();
		    	String ga = States.GEORGIA.toString();
		    	String ia = States.IOWA.toString();
		    	String nj = States.NEWJERSEY.toString();
		    	String wy = States.WYOMING.toString();
		    	String[] statesArray = {al, ak, ga, ia, nj, wy};
		    	
		    	// compare data from enum and list out
		    	if(States.ALASKA.toString() == "Alaska"){
		    		for(int i=0; i<statesArray.length; i++){
		    		String a = statesArray[i];
		    		Log.i("State Names", a);
		    	}
		    	}else{
		    		String err = "Can't find states information";
		    		Log.i("Sorry", err);
		    	}
		}
	});
    	
    	//Array list of state
    	ArrayList<StateInfo>records = new ArrayList<StateInfo>();
    	records.add(new CensusRecords("Alabama", 4802735, 51.5f));
    	records.add(new CensusRecords("Alaska", 710231, 48.1f));
    	records.add(new CensusRecords("Georgia", 9687660, 51.1f));
    	
  
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
