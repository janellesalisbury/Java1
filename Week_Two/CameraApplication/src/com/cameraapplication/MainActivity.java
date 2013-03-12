/*
 * project CameraApplication
 * package com.cameraapplication
 * @author Janelle Salisbury
 * date Mar 11, 2013
 */
package com.cameraapplication;

import android.os.Bundle;
import android.app.Activity;
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

// TODO: Auto-generated Javadoc
/**
 * The Class MainActivity.
 */
public class MainActivity extends Activity implements SensorEventListener{
	
	//GLOBAL VARIABLES
	ImageView userPhoto;
	private SensorManager sm;
	private Sensor light;
	

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
		
		//CREATE SENSOR MANAGER
		sm = (SensorManager)getSystemService(SENSOR_SERVICE);
		light = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
		
		//FIND IMAGE VIEW TO DISPLAY USERS CAPTURED PHOTO
		userPhoto = (ImageView) findViewById(R.id.capturedIV);
		
		//FIND BUTTON TO TAKE PHOTO AND ADD ONCLICK FOR FUNCTIONALITY
		Button photo = (Button) findViewById(R.id.photoBtn);
		photo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// LAUNCH THE CAMERA APP TO TAKE A PHOTO
				Intent camera = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

				//START THE CAMERA AND RETURN THE PHOTO THE USER TAKES
				startActivityForResult(camera, 0);
			
			}
			
		});
	}
	//TO CAPTURE THE RESULTING PHOTO
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		//ACCESS SENT DATA AND USE BITMAP TO READ
		Bitmap bitmap = (Bitmap) data.getExtras().get("data");
		userPhoto.setImageBitmap(bitmap);
		
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
		if( event.sensor.getType() == Sensor.TYPE_LIGHT){
			Log.i("Sensor Changed", "onSensor Change :" + event.values[0]);
	}
	}
}


