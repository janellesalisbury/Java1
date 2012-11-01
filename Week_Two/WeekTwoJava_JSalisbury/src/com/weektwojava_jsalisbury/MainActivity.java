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
import com.weektwojava_jsalisbury.StateInfo;


public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
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
				
				//Array list of states for drop down list
		    	//TODO: use this to make combo box
		    	String AL = States.ALABAMA.toString();
		    	String AK = States.ALASKA.toString();
		    	String AZ = States.ARIZONA.toString();
		    	String CA = States.ARKANSAS.toString();
		    	String CO = States.CALIFORNIA.toString();
		    	String CT = States.COLORADO.toString();
		    	String DE = States.DELAWARE.toString();
		    	String FL = States.FLORIDA.toString();
		    	String GA = States.GEORGIA.toString();
		    	String HI = States.HAWAII.toString();
		    	String ID = States.IDAHO.toString();
		    	String IL = States.ILLINOIS.toString();
		    	String IN = States.INDIANA.toString();
		    	String IA = States.IOWA.toString();
		    	String KS = States.KANSAS.toString();
		    	String KY = States.KENTUCKY.toString();
		    	String LA = States.LOUISIANA.toString();
		    	String ME = States.MAINE.toString();
		    	String MD = States.MARYLAND.toString();
		    	String MA = States.MASSACHUCETTS.toString();
		    	String MI = States.MICHIGAN.toString();
		    	String MN = States.MINNESOTA.toString();
		    	String MS = States.MISSISSIPPI.toString();
		    	String MO = States.MISSOURI.toString();
		    	String MT = States.MONTANA.toString();
		    	String NE = States.NEBRASKA.toString();
		    	String NV = States.NEVADA.toString();
		    	String NH = States.NEW_HAMPSHIRE.toString();
		    	String NJ = States.NEW_JERSEY.toString();
		    	String NM = States.NEW_MEXICO.toString();
		    	String NY = States.NEW_YORK.toString();
		    	String NC = States.NORTH_CAROLINA.toString();
		    	String ND = States.NORTH_DAKOTA.toString();
		    	String OH = States.OHIO.toString();
		    	String OK = States.OKLAHOMA.toString();
		    	String OR = States.OREGON.toString();
		    	String PA = States.PENNSYLVANIA.toString();
		    	String RI = States.RHODE_ISLAND.toString();
		    	String SC = States.SOUTH_CAROLINA.toString();
		    	String SD = States.SOUTH_DAKOTA.toString();
		    	String TN = States.TENNESSEE.toString();
		    	String TX = States.TEXAS.toString();
		    	String UT = States.UTAH.toString();
		    	String VT = States.VERMONT.toString();
		    	String VA = States.VIRGINIA.toString();
		    	String WA = States.WASHINGTON.toString();
		    	String WV = States.WEST_VIRGINIA.toString();
		    	String WI = States.WISCONSIN.toString();
		    	String WY = States.WYOMING.toString();
		    	
		    	String[] statesArray = {AL, AK, AZ, CA, CO, CT, CO, DE, FL, GA, HI, 
		    							ID, IL, IN, IA, KS, KY, LA, ME, MD, MA, MI, 
		    							MN, MS, MO, MT, NE, NV, NH, NJ, NH, NM, NY,
		    							NC, ND, OH, OK, OR, PA, RI, SC, SD, TN, TX,
		    							UT, VT, VA, WA, WV, WI, WY};
		    	
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
