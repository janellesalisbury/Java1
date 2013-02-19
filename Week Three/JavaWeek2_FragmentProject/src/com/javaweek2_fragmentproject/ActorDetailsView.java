package com.javaweek2_fragmentproject;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;

public class ActorDetailsView extends Activity{

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
      //SET UP ACTION BAR FOR TABS
      		ActionBar actionBar = getActionBar();
      		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
      		actionBar.setDisplayShowTitleEnabled(true);
      		actionBar.setDisplayHomeAsUpEnabled(true);

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
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {       
        startActivity(new Intent(ActorDetailsView.this, MainActivity.class)); 
        return true;
    }

//	@Override
//	public void onWebList() {
//		// TODO Auto-generated method stub
//		
//	}

}