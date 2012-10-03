package com.salisburyjanelle_week2;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	LinearLayout ll;
	LinearLayout.LayoutParams lp;
	TextView header;
	TextView firstTv;
	TextView secondTv;
	TextView shoeTv;
	EditText et;
	int itemCount;
	
	
	
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ll = new LinearLayout(this);
        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(lp);
        
        header = new TextView(this);
        header.setText("Janelle's Shoe Inventory");
        header.setTextColor(Color.BLACK);
        
        
        ll.addView(header);
        
        firstTv = new TextView(this);
        String shoes[] = {getString(R.string.item1), getString(R.string.item2), getString(R.string.item3), getString(R.string.item4)};
        itemCount = shoes.length;
        for (int i=0; i <itemCount; i++){
        	firstTv.append((shoes[i] + "\n"));
        	
        }
        ll.addView(firstTv);
        
        secondTv = new TextView(this);
        secondTv.setText("New Shoes");
        secondTv.setTextColor(Color.BLACK);
        shoeTv = new TextView(this);
        
        ll.addView(secondTv);
        ll.addView(shoeTv);
        
        
        et = new EditText(this);
        et.setHint("Enter shoe here");
        
        Button b = new Button(this);
        b.setText("Enter");
        
        b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String entry = et.getText().toString();
				shoeTv.append(entry+"\r\n");
				
			}
		});
        LinearLayout form = new LinearLayout(this);
        form.setOrientation(LinearLayout.HORIZONTAL);
        
        form.setLayoutParams(lp);
        form.addView(et);
        form.addView(b);
        
        setContentView(ll);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
