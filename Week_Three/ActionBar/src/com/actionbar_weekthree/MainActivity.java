/*
 * project ActionBar_WeekThree
 * package com.actionbar_weekthree
 * @author Janelle Salisbury
 * date Mar 18, 2013
 */
package com.actionbar_weekthree;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

// TODO: Auto-generated Javadoc
/**
 * The Class MainActivity.
 */
public class MainActivity extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mainmenu, menu);
		return true;
	}
	//CREATE METHOD TO SWITCH BETWEEN SELECTED ICON FUNCTIONALITY WHEN ICON IS CLICKED
	/* (non-Javadoc)
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case R.id.action_refresh:
			//FOR TESTING PURPOSES, WILL CONTAIN ACTUAL FUNCTIONALITY SHORTLY
			Toast.makeText(this, "Refresh Selected", Toast.LENGTH_SHORT).show();
			break;
		case R.id.action_search:
			//FOR TESTING PURPOSES, WILL CONTAIN ACTUAL FUNCTIONALITY SHORTLY
			Toast.makeText(this, "Search Selected", Toast.LENGTH_SHORT).show();
			break;
		case R.id.action_share:
			//FOR TESTING PURPOSES, WILL CONTAIN ACTUAL FUNCTIONALITY SHORTLY
			Toast.makeText(this, "Share Selected", Toast.LENGTH_SHORT).show();
			break;
		case R.id.action_user:
			//FOR TESTING PURPOSES, WILL CONTAIN ACTUAL FUNCTIONALITY SHORTLY
			Toast.makeText(this, "User Info Selected", Toast.LENGTH_SHORT).show();
			break;
		}
		return false;
		
	}

}
