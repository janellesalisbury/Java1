package com.javaweek2_fragmentproject;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

public class ActorDetailsView extends Activity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
        	finish();
        	return;
        }
        setContentView(R.layout.image_viewer_activity);
    	Intent launchingIntent = getIntent();
    	int item = launchingIntent.getIntExtra("item", 0);
    	ActorDetailsFragment viewer = (ActorDetailsFragment) getFragmentManager().findFragmentById(R.id.image_viewer_fragment);
    	viewer.update(item);
    	}
	}

