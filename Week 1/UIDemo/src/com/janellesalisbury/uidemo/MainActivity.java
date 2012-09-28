package com.janellesalisbury.uidemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	LinearLayout ll;
	LinearLayout.LayoutParams lp;
	EditText et;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(lp);
        
        TextView tv = new TextView(this);
        //tv.setText(getString(R.string.quarter)+","+getString(R.string.dime)+","+getString(R.string.nickel)+","+getString(R.string.penny));
        tv.setText("Enter the number of dollars to convert to coins!");
        
        ll.addView(tv);
        
        et = new EditText(this);
        et.setHint("Please enter dollars here");
        //ll.addView(et);
        
        Button b = new Button(this);
        b.setText("Convert");
        //ll.addView(b);
        b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int quarter = getResources().getInteger(R.integer.quarter);
				int dime = getResources().getInteger(R.integer.dime);
				int nickel = getResources().getInteger(R.integer.nickel);
				int penny = getResources().getInteger(R.integer.penny);
				
				
				int entry = Integer.parseInt (et.getText().toString());
				
				int numQ = (100/quarter)*entry;
				int numD = (100/dime)*entry;
				int numN = (100/nickel)*entry;
				int numP = (100/penny)*entry;
				
		
				
				
				
						
				
			}
		});
        
        LinearLayout form = new LinearLayout(this);
        form.setOrientation (LinearLayout.HORIZONTAL);
        form.setLayoutParams(lp);
        
        form.addView(et);
        form.addView(b);
        
        ll.addView(form);        
        
  
        
        setContentView(ll);
        
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
