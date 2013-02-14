package com.videoplayback_week2;

import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity<batteryReceiver> extends Activity implements SensorEventListener{
	//GLOBAL VARIABLES
	String buttonText;
	Button button1;
	VideoView vv;
	Context _this;
	TextView acceleration;
	SensorManager sm;
	Sensor accelerometer ;
	private TextView battery;
	
	
	//INTERNET CONNECTED BOOLEAN
    Boolean isInternetPresent = false;
 
    // CONNECTION DETECTOR
    NetworkDetection cd;
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//CHECK NETWORK STATUS
		chkStatus();
		
		//CREATE ACCELEROMETER MANAGER
		sm = (SensorManager) getSystemService(SENSOR_SERVICE);
		accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		sm.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
		acceleration = (TextView) findViewById(R.id.acceleration);
		
		//GET BATTERY TEXTVIEW and REGISTER RECEIVER
		battery=(TextView)findViewById(R.id.battery);
		this.registerReceiver(this.batteryInfoReceiver,	new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
	
	}

	private BroadcastReceiver batteryInfoReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			
			int  health= intent.getIntExtra(BatteryManager.EXTRA_HEALTH,0);
			int  level= intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
			int  status= intent.getIntExtra(BatteryManager.EXTRA_STATUS,0);
		}
	};
	
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
			
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				//PLAY VIDEO NOW AND SEND NOTIFICATION TO PHONE
				vv = (VideoView) findViewById(R.id.videoView1);
				String uriPath = "android.resource://" + getPackageName() + "/" + R.raw.ironman;
				vv.setVideoURI(Uri.parse(uriPath));
				vv.setMediaController(new MediaController(_this));
				vv.start();
				NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				Notification notify = new Notification(android.R.drawable.stat_notify_more, 
						"launching video", System.currentTimeMillis());
				Context context = MainActivity.this;
				CharSequence title = "You have been notified";
				CharSequence details = "Continue watching video";
				Intent in = new Intent(context, MainActivity.class);
				PendingIntent pending = PendingIntent.getActivity(context, 0, in, 0);
				notify.setLatestEventInfo(context, title, details, pending);
				nm.notify(0, notify);
				
				
			}
		});

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}


	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		//UNUSED
		
	}


	@Override
	public void onSensorChanged(SensorEvent event) {
		acceleration.setText("X:" + event.values[0] + "\bY:" + event.values[1] + "\bZ:" + event.values[2]);
	}	

}