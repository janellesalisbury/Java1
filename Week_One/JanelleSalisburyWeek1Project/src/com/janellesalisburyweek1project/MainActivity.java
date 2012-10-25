package com.janellesalisburyweek1project;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
	EditText et;
	int itemCount;
	int addeditemcount;
	AlertDialog alert;
	
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
        
        //Loop of parts
        String [] parts = {"Brake Pads", "Calipers", "Head Gasket", "Lug Nuts", "Radiator", "Intake Manifold", "Gear Shaft"};
        itemCount = parts.length;
        for(int i=0; i < itemCount; i++){
        	titleTV.append((parts[i] + "\n"));
        }
        ll.addView(titleTV);
        
        //declare alert
        alert = new AlertDialog.Builder(this).create();
        
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
				if (entry.length() <= 0){
					//error alert
					alert.setTitle("Error");
					alert.setMessage("Please enter a part here");
					alert.setButton("OK", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(final DialogInterface dialog, final int which) {
							// TODO Auto-generated method stub
							
						}
					});
					alert.show();
				}else{
					titleTV.append(entry+"\r\n");
					//success alert
					alert.setTitle("Success");
					alert.setMessage("Item successfully added");
					alert.setButton("OK", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							
						}
					});
					alert.show();
						
							
				
				}
			}
		});
        
        LinearLayout form = new LinearLayout(this);
        form.setOrientation(LinearLayout.VERTICAL);
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
