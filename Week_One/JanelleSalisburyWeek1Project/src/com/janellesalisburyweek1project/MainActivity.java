package com.janellesalisburyweek1project;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	LinearLayout ll;
	LinearLayout.LayoutParams lp;
	TextView header;
	TextView firstTV;
	TextView secondTV;
	TextView thirdTV;
	EditText et;
	int itemCount;
	int itemCount2;
	
	 @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(lp);
        
        //set up title header and textView
        header = new TextView(this);
        header.setText("Restoration Rolodex");
        header.setBackgroundColor(Color.RED);
        header.setTextColor(Color.WHITE);
        ll.addView(header);
        
        firstTV = new TextView(this);
        
        //Loop of parts from resources
        String [] parts = {getString(R.string.item1), getString(R.string.item2), getString(R.string.item3), getString(R.string.item4), getString(R.string.item5)};
        itemCount = parts.length;
        for(int i=0; i < itemCount; i++){
        	firstTV.append((parts[i] + "\n"));
        }
        ll.addView(firstTV);
        
        
        setContentView (ll);
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
