package com.javaweek2_fragmentproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {

	//called when activity is first opened
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

    public void onListItemSelected(int item){
    	ActorsFragment actorNames = (ActorsFragment) getFragmentManager().findFragmentById(R.id.actors);
    	
    	if(actorNames == null){
    		Intent actorList = new Intent(getApplicationContext(), ActorDetailsView.class);
    		startActivity(actorList);
    	}else{
    		actorNames.update(item);
    	}
    }
 }

