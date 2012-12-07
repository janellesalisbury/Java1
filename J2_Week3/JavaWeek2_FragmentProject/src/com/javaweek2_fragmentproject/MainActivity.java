package com.javaweek2_fragmentproject;

import android.os.Bundle;
import android.util.Log;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity implements MainActivityFragment.ListItemSelectedListener{
	//called when activity is first created
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Log.d("step debug","activity on create");
		setContentView(R.layout.main);
		
//		DBAdapter db = new DBAdapter(this);
//		db.open();
//		long id;
//		id = db.insertTitle("Liar Liar", "1997", "Jim Carrey");
//		id = db.insertTitle("Dirty Harry", "1971", "Clint Eastwood");
//		id = db.insertTitle("Blow", "2001", "Penelope Cruz");
//		id = db.insertTitle("Gentlemen Prefer Blondes", "1953", "Marilyn Monroe");
//		id = db.insertTitle("The Wizard of Oz", "1939", "Judy Garland");
//		id = db.insertTitle("Fools Gold", "2008", "Matthew McConaughey");
//		id = db.insertTitle("Orange County", "2002", "Chevy Chase");
//		id = db.insertTitle("Blow", "2001", "Johnny Depp");
//		id = db.insertTitle("Hondo", "1953", "John Wayne");
//		
//		db.close();
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


	
 
 

