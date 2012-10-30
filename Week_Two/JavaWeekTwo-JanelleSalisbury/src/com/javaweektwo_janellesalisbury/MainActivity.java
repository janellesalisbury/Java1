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
	EditText et;
	
	 @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //set up new linear layout
        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(lp);
        
        //set up title header
        header = new TextView(this);
        header.setText("United States Census Information");
        header.setBackgroundColor(Color.GRAY);
        header.setTextColor(Color.WHITE);
        ll.addView(header);
        
        //edit text field/button
        et = new EditText(this);
        et.setHint("hint here");
        
        Button b = new Button(this);
        b.setText("Retrieve");
        
        b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
        
        LinearLayout form = new LinearLayout(this);
        form.setOrientation(LinearLayout.HORIZONTAL);
        
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
