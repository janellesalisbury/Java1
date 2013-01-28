package com.projectthree_java;

import java.util.ArrayList;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ProgressBar;
import android.widget.TextView;



public class Bookmark extends Activity implements BookmarkFragment.BookmarkListener{
	
	 //Create Broadcast Receiver Object along with class definition
    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver() {
        @Override
          //STARTS RECEIVER
        public void onReceive(Context c, Intent i) {
              //GET BATTERY PERCENTAGE
            int level = i.getIntExtra("level", 0);
              //FIND THE PROGRESS BAR
            ProgressBar pb = (ProgressBar) findViewById(R.id.progressbar);
              //SET LEVEL OF BATTERY 
            pb.setProgress(level);
              //FIND TEXTVIEW
            TextView tv = (TextView) findViewById(R.id.textfield);
              //SET TEXTVIEW
            tv.setText("Battery Level: " + Integer.toString(level) + "%");
        }
 
    };
	
	Context _context;
	ArrayList<String> _state = new ArrayList<String>();
	String _choice;


	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bookmark_frag);
	
	      //REGISTER THE RECEIVER WHICH TRIGGERS THE EVENT
        //WHEN BATTERY CHARGE IS CHANGED
     registerReceiver(mBatInfoReceiver, new IntentFilter(
             Intent.ACTION_BATTERY_CHANGED));
		_context = this;
	}

	//INFLATE MENU
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	//FINISH THE ACTIVITY/PLACE DATA FROM INTENT
	@Override
	public void finish(){
		Intent data = new Intent();
		data.putExtra("state", _choice);
		setResult(RESULT_OK, data);
		super.finish();
	}
	
	public void onBookmarkSelected(String state){
		_choice = state;
		finish();
	}

}


