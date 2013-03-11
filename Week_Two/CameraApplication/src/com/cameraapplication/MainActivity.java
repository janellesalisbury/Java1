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
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

// TODO: Auto-generated Javadoc
/**
 * The Class MainActivity.
 */
public class MainActivity extends Activity {
	
	//GLOBAL VARIABLES
	ImageView userPhoto;

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//FIND IMAGE VIEW TO DISPLAY USERS CAPTURED PHOTO
		userPhoto = (ImageView) findViewById(R.id.capturedIV);
		
		//FIND BUTTON TO TAKE PHOTO AND ADD ONCLICK FOR FUNCTIONALITY
		Button photo = (Button) findViewById(R.id.photoBtn);
		photo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// LAUNCH THE CAMERA APP TO TAKE A PHOTO
				Intent camera = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				//START CAMERA AND RETURN THE PHOTO THE USER TAKES
				startActivityForResult(camera, 0);
				
			}
		});
	}
	//TO CAPTURE THE RESULTING PHOTO
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent photo) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, photo);
		
		//ACCESS SENT DATA AND USE BITMAP TO READ
		Bitmap bitmap = (Bitmap) photo.getExtras().get("photo");
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

}