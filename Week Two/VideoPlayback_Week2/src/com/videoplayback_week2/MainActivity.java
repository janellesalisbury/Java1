package com.videoplayback_week2;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
	Button button2;
	VideoView vv;
	Context _this;
	
	//INTERNET CONNECTED BOOLEAN
    Boolean isInternetPresent = false;
 
    // CONNECTION DETECTOR
    NetworkDetection cd;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	        
		//SET CONTEXT
		_this = this;
		
		Button btnStatus = (Button) findViewById(R.id.button2);
		 
        // creating connection detector class instance
        cd = new NetworkDetection(getApplicationContext());
        btnStatus.setOnClickListener(new View.OnClickListener() {
 
            @Override
            public void onClick(View v) {
 
                // get Internet status
                isInternetPresent = cd.isConnectingToInternet();
 
                // check for Internet status
                if (isInternetPresent) {
                    // Internet Connection is Present
                    // make HTTP requests
                    showAlertDialog(MainActivity.this, "Internet Connection",
                            "You're connected", true);
                } else {
                    // Internet connection is not present
                    // Ask user to connect to Internet
                    showAlertDialog(MainActivity.this, "No Internet Connection",
                            "Oops, please select a network", false);
                }
            }
 
        });
 
    }
 
    @SuppressWarnings("deprecation")
	public void showAlertDialog(Context context, String title, String message, Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
 
        //SETTING DIALOG TITLE
        alertDialog.setTitle(title);
 
        //SETTING DIALOG MESSAGE
        alertDialog.setMessage(message);
 
        //OK BUTTON
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
 
        //ALERT MESSAGE
        alertDialog.show();
    
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
