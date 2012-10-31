package com.javaweektwo_janellesalisbury;

import com.jsalisbury.lib.SetLayout;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jsalisbury.lib.SetLayout;






public class MainActivity extends Activity {
	
	LinearLayout LL;
	LinearLayout.LayoutParams lp;
	TextView stateTV;
	int itemCount;
//	TextView totalPopTV;
//	TextView totalMenTV;
//	TextView totalWomenTV;
//	TextView percentMenTV;
//	TextView percentWomenTV;

	
	 @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
         //set up new linear layout 
        LinearLayout ll = new LinearLayout(this);
        
        //add button and edit text from setLayout class
    	LinearLayout stateEntry = SetLayout.singleEntryWithButton(this, "Enter State Here", "Retrieve Data");
    	
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
    	
    	//new linearlayout for textview
    	LinearLayout LL = new LinearLayout(this);
    	LL.setOrientation(LinearLayout.VERTICAL);
    	lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
    	ll.setLayoutParams(lp);
    	
    	stateTV = new TextView(this);
    	String [] stateInfo = {getString(R.string.al_name), getString(R.string.al_pop), getString(R.string.al_men), getString(R.string.al_women)};
    	itemCount = stateInfo.length;
    	for(int i = 0; i<itemCount; i++){
    		stateTV.append((stateInfo[i] + "\n"));
    	}
    	LL.addView(stateTV);
    	
    	
    	
    	
    	
        
    	
    	
    	
    	
    	
    	//get developer key from resources
        //final String APIDeveloperKey  = new CensusRecord(getString(R.string.APIDeveloperKey));
        
        
        
        
        //retrieve info from resources which will be filled by api later
        
        //text view to display each element in censusRecord class
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
        
        
        
        
        
        
       
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
