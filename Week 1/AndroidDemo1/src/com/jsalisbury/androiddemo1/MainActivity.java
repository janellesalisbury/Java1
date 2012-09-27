package com.jsalisbury.androiddemo1;

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
        tv.setText("This is my updated project one");
        
        ll.addView(tv);
        
        EditText et = new EditText(this);
        ll.addView(et);
        
        Button b = new Button(this);
        ll.addView(b);
        
        setContentView(ll);
        
        
    }

    private Exception setText(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
