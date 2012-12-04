package com.javaweek2_fragmentproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity implements MainActivityFragment.ListItemSelectedListener{
	//called when activity is first created
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	@Override
	public void onListItemSelected(int item){
		ActorDetailsFragment imageViewer = (ActorDetailsFragment) getFragmentManager().findFragmentById(R.id.image_viewer_fragment);
		
		if(imageViewer == null || !imageViewer.isInLayout()){
			Intent showImage = new Intent(getApplicationContext(), ActorDetailsView.class);
			showImage.putExtra("item", item);
			startActivity(showImage);
		} else {
			imageViewer.update(item);
		}
	}
	
	
		
}


	
 
 

