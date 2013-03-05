package com.launcherapp;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	static final String[] Songs = new String[] {"Song 1", "Song 2", "Song 3", "Song 4",
		"Song 5", "Song 6", "Song 7"};
	String song;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//CREATE LIST ADAPTER 
		setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, Songs));
		//GET LISTVIEW
		ListView songsList = getListView();
		songsList.setTextFilterEnabled(true);
		
		songsList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int pos,
					long id) {
				//CLICK BUTTON AND OPEN MUSIC PLAYER IN SECOND APP
				Intent MusicLauncher = getPackageManager().getLaunchIntentForPackage("com.musicplayer_mainapp");
				//Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
				//MusicLauncher.setData(Uri.parse(song));
				startActivity(MusicLauncher);
				
			}
		});
	}

	

}
