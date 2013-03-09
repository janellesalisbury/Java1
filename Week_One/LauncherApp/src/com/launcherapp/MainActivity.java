/*
 * project LauncherApp
 * package com.launcherapp
 * @author Janelle Salisbury
 * date Mar 6, 2013
 */
package com.launcherapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

// TODO: Auto-generated Javadoc
/**
 * The Class MainActivity.
 */
public class MainActivity extends Activity {

	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
	}
	
	//INTENT TO OPEN SPECIFIED WEBSITES
	public void openWebsite(View v){
	Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.weather.com"));
	startActivity(intent);
	}
}
