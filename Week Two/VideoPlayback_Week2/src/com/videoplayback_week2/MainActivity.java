package com.videoplayback_week2;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {
	//GLOBAL VARIABLES
	String buttonText;
	Button button1;
	VideoView vv;
	Context _this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//SET CONTEXT
		_this = this;
		
		//SET UP BUTTON FOR VIDEO PLAYBACK
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//PLAY VIDEO NOW
				vv = (VideoView) findViewById(R.id.videoView1);
				String uriPath = "android.resource://" + getPackageName() + "/" + R.raw.ironman;
				vv.setVideoURI(Uri.parse(uriPath));
				vv.setMediaController(new MediaController(_this));
				vv.start();
				
				
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
