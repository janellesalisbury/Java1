package com.launcherapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//FIND BUTTON AND EDIT TEXT
		EditText et = (EditText) findViewById(R.id.editText1);
		Button openPlayer = (Button) findViewById(R.id.button1);
		//BUTTON CLICK OPENS VIDEO PLAYER APP
		openPlayer.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent VideoIntent = getPackageManager().getLaunchIntentForPackage("com.videoplayer_mainapp");
				startActivity(VideoIntent);
				
			}
		});
	}
	

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}
