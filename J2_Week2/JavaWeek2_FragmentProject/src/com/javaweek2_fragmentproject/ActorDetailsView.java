package com.javaweek2_fragmentproject;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

public class ActorDetailsView extends Activity {
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
			finish();
			return;
		}
		
		setContentView(R.layout.activity_main);
		Intent launchIntent = getIntent();
		int item = launchIntent.getIntExtra("item", 0);
		ActorsFragment viewer = (ActorsFragment) getFragmentManager().findFragmentById(R.id.details);
		viewer.update(item);
	}

}
