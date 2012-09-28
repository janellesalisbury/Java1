package com.janellesalisbury.uidemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	LinearLayout ll;
	LinearLayout.LayoutParams lp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(lp);
        
        TextView tv = new TextView(this);
        tv.setText("This is my project.");
        
        ll.addView(tv);
        
        EditText et = new EditText(this);
        et.setHint("Please enter info here");
        //ll.addView(et);
        
        Button b = new Button(this);
        b.setText("Enter");
        //ll.addView(b);
        
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
