package com.javaweektwo_janellesalisbury;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;


public class MainActivity extends Activity {
	
	LinearLayout ll;
	LinearLayout.LayoutParams lp;
	TextView mainTitle;
	TextView header;
	TextView totalPopTV;
	TextView totalMenTV;
	TextView totalWomenTV;
	TextView percentMenTV;
	TextView percentWomenTV;
	EditText et;
	
	 @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //set up new linear layout
        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(lp);
        
        //get developer key from resources
        //final String APIDeveloperKey  = new CensusRecord(getString(R.string.APIDeveloperKey));
        
        //set up title header
        header = new TextView(this);
        header.setText("United States Census Information");
        header.setBackgroundColor(Color.GRAY);
        header.setTextColor(Color.WHITE);
        ll.addView(header);
        
        //edit text field/button
        et = new EditText(this);
        et.setHint("enter state here");
        
        Button b = new Button(this);
        b.setText("Retrieve");
        
        //retrieve info from resources which will be filled by api later
        
        //text view to display each element in censusRecord class
        totalPopTV = new TextView(this);
        totalMenTV = new TextView(this);
        totalWomenTV = new TextView(this);
        percentMenTV = new TextView(this);
        percentWomenTV = new TextView(this);
        
        b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//get zip code from text entry
				String zipCode = et.getText().toString();
				
				
				
				//replace this with API records at later time
				//make empty census record
				CensusRecord myCensusRecord = new CensusRecord();
				myCensusRecord.setLocation(zipCode);
				myCensusRecord.setTotalPopulation(100000);
				myCensusRecord.setTotalMen(50000);
				myCensusRecord.setTotalWomen(50000);
				
				//replace with api data
				//CensusRecord myCensusRecord = new CensusRecord(zipCode, APIDeveloperKey);
				
				
				//update text views for data
				totalPopTV.setText(myCensusRecord.getTotalPopulation().toString());
				totalMenTV.setText(myCensusRecord.getTotalMen().toString());
				totalWomenTV.setText(myCensusRecord.getTotalWomen().toString());
				percentMenTV.setText(Float.toString(myCensusRecord.getPercentMen()));
				percentWomenTV.setText(Float.toString(myCensusRecord.getPercentMen()));
				
				
	
			}
		});
        
        
       
        
        LinearLayout form = new LinearLayout(this);
        form.setOrientation(LinearLayout.HORIZONTAL);
        
        form.setLayoutParams(lp);
        form.addView(et);
        form.addView(b);
      //show text
		ll.addView(totalMenTV);
		ll.addView(totalPopTV);
		ll.addView(totalWomenTV);
		ll.addView(percentMenTV);
		ll.addView(percentWomenTV);
        
        
        
        
        
        
        
       ll.addView(form);
       setContentView(ll); 
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
