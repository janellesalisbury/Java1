package com.janellesalisburyweek1project;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	LinearLayout ll;
	LinearLayout.LayoutParams lp;
	TextView header;
	TextView titleTV;
	TextView inventoriedTV;
	TextView partsneededTV;
	TextView addedpartTV;
	EditText et;
	int itemCount;
	int itemCount2;
	
	 @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //set up new linear layout
        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(lp);
        
        //set up title header and textView
        header = new TextView(this);
        header.setText("Restoration Rolodex");
        header.setBackgroundColor(Color.RED);
        header.setTextColor(Color.BLACK);
        ll.addView(header);
        titleTV = new TextView(this);
        
        //set up section header
        header = new TextView(this);
        header.setText("Parts Inventory");
        header.setBackgroundColor(Color.CYAN);
        header.setTextColor(Color.BLACK);
        ll.addView(header);
        inventoriedTV = new TextView(this);
        
        //Loop of parts from resources
        String [] parts = {getString(R.string.item1), getString(R.string.item2), getString(R.string.item3), getString(R.string.item4), getString(R.string.item5)};
        itemCount = parts.length;
        for(int i=0; i < itemCount; i++){
        	titleTV.append((parts[i] + "\n"));
        }
        ll.addView(titleTV);
        
      //set up section two header
        partsneededTV = new TextView(this);
        partsneededTV.setText("Parts to be Ordered");
        partsneededTV.setBackgroundColor(Color.CYAN);
        partsneededTV.setTextColor(Color.BLACK);
        ll.addView(partsneededTV);
        
        //set up textview for parts added
        addedpartTV = new TextView(this);
        ll.addView(addedpartTV);
        
        
        
        //add editText and button with onclick listener
        et = new EditText(this);
        et.setHint("Enter part here");
        
        Button b = new Button(this);
        b.setText("Add Part");
        
        b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String entry = et.getText().toString();
				addedpartTV.append(entry + "\r\n");
				
			}
		});
        
        LinearLayout form = new LinearLayout(this);
        form.setOrientation(LinearLayout.HORIZONTAL);
        form.setLayoutParams(lp);
        form.addView(et);
        form.addView(b);
        
        
        ll.addView(form);		
        setContentView (ll);
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
