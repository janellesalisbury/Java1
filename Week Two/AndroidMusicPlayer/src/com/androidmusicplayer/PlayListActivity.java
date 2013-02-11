package com.androidmusicplayer;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class PlayListActivity extends ListActivity{
	//PLAY LIST
	public ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playlist);
		
		ArrayList<HashMap<String, String>> songsListData = new ArrayList<HashMap<String, String>>();
		
		SongsManager plm = new SongsManager();
		//GET SD CARD SONGS
		this.songsList = plm.getPlayList();
		for (int i = 0; i < songsList.size(); i++){
			HashMap<String, String> song = songsList.get(i);
			songsListData.add(song);
		}
		//ADD MENU ITEMS
		ListAdapter adapter = new SimpleAdapter(this, songsListData, R.layout.playlist_item, new String[] 
				{ "songTitle" }, new int[] { R.id.songTitle });
		setListAdapter(adapter);
		
		//SELECT SINGLE SONG ITEM
		ListView lv = getListView();
		
		//ONCLICK FOR SINGLE SONG ITEM
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				//INTENT TO START SONG
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
				//SEND SONG INDEX TO PLAYER ACTIVITY
				intent.putExtra("songIndex", songIndex);
				setResult(100, intent);
                // Closing PlayListView
                finish();
				
			}
		});
		
	}
	

}
