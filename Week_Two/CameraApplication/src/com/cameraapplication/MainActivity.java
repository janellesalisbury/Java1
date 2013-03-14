/*
 * project CameraApplication
 * package com.cameraapplication
 * @author Janelle Salisbury
 * date Mar 11, 2013
 */
package com.cameraapplication;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

// TODO: Auto-generated Javadoc
/**
 * The Class MainActivity.
 */
public class MainActivity extends Activity implements SensorEventListener{
	
	//GLOBAL VARIABLES
	ImageView userPhoto;
	private SensorManager sm;
	private Sensor light;
	private Sensor dark;
	boolean isInternetConnected = false;
	ConnectionDetection connDetct;
	static int TAKE_PICTURE = 1;
    Uri outputFileUri;

	

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//SCREEN ORIENTATION
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.activity_main);
		
		//DETERMINE NETWORK CONNECTION TO ALLOW SHARING IF PRESENT
		connDetct = new ConnectionDetection(getApplicationContext());
		
		//CREATE SENSOR MANAGER
		sm = (SensorManager)getSystemService(SENSOR_SERVICE);
		light = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
		dark = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		
		//FIND IMAGE VIEW TO DISPLAY USERS CAPTURED PHOTO
		userPhoto = (ImageView) findViewById(R.id.capturedIV);
		
		//FIND BUTTON TO TAKE PHOTO AND ADD ONCLICK FOR FUNCTIONALITY
		Button photo = (Button) findViewById(R.id.photoBtn);
		photo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// LAUNCH THE CAMERA APP TO TAKE A PHOTO
				Intent camera = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				//CREATE THE FILE TO SAVE
				File file = new File(Environment.getExternalStorageDirectory(), "MyPhoto.jpg");
				outputFileUri = Uri.fromFile(file);
				//START THE CAMERA AND RETURN THE PHOTO THE USER TAKES
				startActivityForResult(camera, TAKE_PICTURE);
				
				//IF INTERNET IS PRESENT THEN ALLOW USER TO SHARE
				 isInternetConnected = connDetct.isConnectingToInternet();
				 //IF PRESENT START THE SHARE INTENT TO ALLOW SENDING OF PHOTO
				 if(isInternetConnected){
					 Intent share = new Intent(Intent.ACTION_SEND);
					 share.setType("image/*");
					 share.putExtra(android.content.Intent.EXTRA_TEXT, "Image sent from Janelle");
					 startActivity(share);
				 }else{
					 //IF NOT PRESENT ALERT THE USER THEY WILL BE UNABLE TO SEND PHOTOS
					 showAlertDialog(MainActivity.this, "No Internet Present", "You're unable to share images with no connection present", false);
				 }
			
			}
		});
	}
	
	//CREATE ALERT FOR INTERNET CONNECTION (OR LACK OF)
	@SuppressWarnings("deprecation")
	public void showAlertDialog(Context context, String title, String message, Boolean status){
		AlertDialog ad = new AlertDialog.Builder(context).create();
		ad.setTitle(title);
		ad.setMessage(message);
		ad.setIcon((status) ? R.drawable.checkmark : R.drawable.fail);
		ad.setButton("Dang It!", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				
			}
		});
		ad.show();
	}
	//TO CAPTURE THE RESULTING PHOTO AND SAVE IT
	@SuppressWarnings("deprecation")
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
	
		
		//ACCESS SENT DATA AND USE BITMAP TO READ
		Bitmap bitmap = (Bitmap) data.getExtras().get("data");
		userPhoto.setImageBitmap(bitmap);
		//IF THE PHOTO SAVED THEN SHOW THE USER THE URI
		if(requestCode == TAKE_PICTURE && resultCode == RESULT_OK){
			Toast.makeText(this, outputFileUri.toString(), Toast.LENGTH_LONG).show();
		}
		
		//SEND NOTIFICATION TO THE USERS PHONE THE IMAGE HAS BEEN CAPTURED
		NotificationManager noteMan = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		//create notification manager instance
		Notification notifyCapture = new Notification(android.R.drawable.stat_notify_more, "Image Captured Successfully", System.currentTimeMillis());
		Context context = MainActivity.this;
		//notification text
		CharSequence title = "Image Captured";
		CharSequence detail = "Go back to camera";
		Intent i = new Intent(context, MainActivity.class);
		PendingIntent pi = PendingIntent.getActivity(context, 0, i, 0);
		notifyCapture.setLatestEventInfo(context, title, detail, pi);
		//send notification to phone upon image capture
		noteMan.notify(0, notifyCapture);
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
	@Override
	
	 protected void onResume() {
	  sm.registerListener(this, light, SensorManager.SENSOR_DELAY_NORMAL);
	  sm.registerListener(this, dark, SensorManager.SENSOR_DELAY_NORMAL);
	  super.onResume();
	
	 }
	
	 @Override
	
	 protected void onPause() {
	  sm.unregisterListener(this);
	  super.onPause();
	
	 }

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		if(sensor.getType() == Sensor.TYPE_LIGHT){
			 Log.i("Sensor Changed", "Accuracy :" + accuracy);
		}
	}
	@Override
	public void onSensorChanged(SensorEvent event) {
		//DETECT LIGHTING CHANGES AND LOG OUT THE VALUE
		if( event.sensor.getType() == Sensor.TYPE_LIGHT){
			Log.i("Sensor Changed", "onSensor Change :" + event.values[0]);
	}
		//DETECT PROXIMITY TO USERS FACE OR IF IN POCKET 
		if(event.sensor.getType()==Sensor.TYPE_PROXIMITY){
		if(event.values[0] == 0){
			//USE WINDOW MANAGER TO TURN OFF THE SCREEN IF TO CLOSE
			WindowManager.LayoutParams params = getWindow().getAttributes();
		      getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		          getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
		      getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
		      //TURN OFF HERE
		      params.screenBrightness = 0f;
		      getWindow().setAttributes(params);
		            } else {
		          WindowManager.LayoutParams params = getWindow().getAttributes();
		      params.screenBrightness = 1f;
		      getWindow().setAttributes(params);
		}
	}
		
		
		}
}

		

		
		
	

