package com.javaweek2_fragmentproject;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

public class ActorDetailsView extends Activity{
	

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
	
	 @Override
	  public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.mainmenu, menu);
	    

	    // RETURN TRUE TO DISPLAY MENU
	    return true;

	  }


	 }
	

	
    



