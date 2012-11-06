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
import android.widget.TextView;

import com.salisbury.lib.*;
import com.weektwojava_jsalisbury.StateInfo;
import com.weektwojava_jsalisbury.CensusRecords;



public class MainActivity extends Activity {
	
	Context _context;
    LinearLayout _appLayout;
    SearchForm _search;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        _context = this;
        _appLayout = new LinearLayout(this);
        
        _search = new SearchForm(_context, "Enter State", "Retrieve");
        
        //ADD SEARCH HANDLER
        EditText searchField = _search.getField();
        Button searchButton = _search.getButton();
        
        _appLayout.addView(_search);
        setContentView(_appLayout);
        
        
        
        
        TextView stateNameTV;
        TextView statePopTV;
        TextView stateWomenTV;
       
        
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
    	
    	//pulling resources using text view
    	stateNameTV = new TextView(this);
    	stateNameTV.setText(R.string.al_name);
    	
    	
    	//population text view
    	statePopTV = new TextView(this);
    	statePopTV.setText(R.string.al_pop);
    	
    	//state percentage text view
    	stateWomenTV = new TextView(this);
    	stateWomenTV.setText(R.string.al_women);
    	
    	
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
		ll.addView(stateNameTV);
    	ll.addView(statePopTV);
    	ll.addView(stateWomenTV);
    	
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
