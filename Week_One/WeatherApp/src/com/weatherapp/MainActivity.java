/*
 * project WeatherApp
 * package com.weatherapp
 * @author Janelle Salisbury
 * date Mar 9, 2013
 */
package com.weatherapp;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

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
		
		//find button and set onclick
		Button siteBtn = (Button) findViewById(R.id.siteBtn);
		siteBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//perform launch intent and show user programs to choose from to open webview
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.weather.com"));
				startActivity(intent);
				
			}
		});
	}
	
	
	
	

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
