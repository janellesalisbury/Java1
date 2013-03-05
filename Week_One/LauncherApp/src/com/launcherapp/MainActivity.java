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
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, Songs));
		
		ListView songsList = getListView();
		songsList.setTextFilterEnabled(true);
		
		songsList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int pos,
					long id) {
				Intent MusicLauncher = getPackageManager().getLaunchIntentForPackage("com.");
				
			}
		});
	}

	

}
