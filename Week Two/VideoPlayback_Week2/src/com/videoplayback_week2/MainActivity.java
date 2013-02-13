package com.videoplayback_week2;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
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
    
    //GPS TRACKER
    GPSTracker gps;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		chkStatus();
		

        button2 = (Button) findViewById(R.id.button2);
 
        // show location button click event
        button2.setOnClickListener(new View.OnClickListener() {
 
            @Override
            public void onClick(View arg0) {
                // create class object
                gps = new GPSTracker(MainActivity.this);
 
                // check if GPS enabled
                if(gps.canGetLocation()){
 
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();
 
                    // \n is for new line
                    Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
                }else{
                    // can't get location
                    // GPS or Network is not enabled
                    // Ask user to enable GPS/network in settings
                    gps.showSettingsAlert();
                }
 
            }
        });
    }

	
	//MOBILE CONNECTION, WI-FI CONNECTION OR NO CONNECTION DETECTION
	void chkStatus()
	{
	final ConnectivityManager connMgr = (ConnectivityManager)
	this.getSystemService(Context.CONNECTIVITY_SERVICE);

	final android.net.NetworkInfo wifi =
	connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

	final android.net.NetworkInfo mobile =
	connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

	if( wifi.isAvailable() ){
	Toast.makeText(this, "Wifi" , Toast.LENGTH_LONG).show();
	Log.i("WIFI", "You're using a wi-fi connection");
	}
	else if( mobile.isAvailable() ){
	Toast.makeText(this, "Mobile 3G " , Toast.LENGTH_LONG).show();
	Log.i("MOBILE", "You're using a 3G connection");
	}
	else
	{Toast.makeText(this, "No Network " , Toast.LENGTH_LONG).show();}
	
	        
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
