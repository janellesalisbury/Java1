package com.weektwojava_jsalisbury;

import java.util.ArrayList;


import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;



import com.salisbury.lib.*;
import com.weektwojava_jsalisbury.States;
import com.weektwojava_jsalisbury.StateInfo;
import com.weektwojava_jsalisbury.CensusRecords;
import com.salisbury.lib.StateDisplay;




public class MainActivity extends Activity {
	
	StateDisplay _state;
	Context _context;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
         //set up new linear layout 
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
   		
        //add button and edit text from setLayout class
        LinearLayout stateEntry = SetLayouts.singleEntryWithButton(this, "Enter State Here", "Retrieve Data");
    	
    	Button retrieveButton = (Button) stateEntry.findViewById(2);
    	
    	//button onClick
    	retrieveButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText states = (EditText) v.getTag();
				
		    	
				//Array list of states(from enum) for drop down list (using enum data to compare for now)
		    	//TODO: use this to make combo box
				String AL = States.ALABAMA.toString();
				String AK = States.ALASKA.toString();
		    	
		    	String[] statesArray = {AL, AK};
		    	
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
    	
    	//ADD STATE DISPLAY
    	_state = new StateDisplay(_context);
    	
    	//list of results from records that will be pulled from API and displayed on screen to user (next week)
    	ArrayList<StateInfo>records = new ArrayList<StateInfo>();
    	records.add(new CensusRecords("Alabama", 4802735, 51.5f));
    	records.add(new CensusRecords("Alaska", 710231, 48.1f));
    	records.add(new CensusRecords("Georgia", 9687660, 51.1f));
    	records.add(new CensusRecords("Iowa", 3046350, 50.4f));
    	records.add(new CensusRecords("New_Jersey", 8791894, 51.3f));
    	records.add(new CensusRecords("Wyoming", 563626, 49.0f));
    	
    	//layout all widget groupings in order of appearance 
    	ll.addView(stateEntry);
    	ll.addView(_state);
    	
    	ll.setOrientation(LinearLayout.VERTICAL);
		
    	
    	setContentView(ll);
    	
   } 	
   	
 
    	//get developer key from resources
        //final String APIDeveloperKey  = new CensusRecord(getString(R.string.APIDeveloperKey));
        
        
        
        
        
        
       

    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
