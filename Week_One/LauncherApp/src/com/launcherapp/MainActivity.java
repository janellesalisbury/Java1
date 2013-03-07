/*
 * project LauncherApp
 * package com.launcherapp
 * @author Janelle Salisbury
 * date Mar 6, 2013
 */
package com.launcherapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//FIND BUTTON 
		Button openPlayer = (Button) findViewById(R.id.button1);
		//BUTTON CLICK OPENS VIDEO PLAYER APP
		openPlayer.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent VideoIntent = getPackageManager().getLaunchIntentForPackage("com.mediaplayer_mainapp");
				startActivity(VideoIntent);
				
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
