/*
 * project MediaPlayer_MainApp
 * package com.mediaplayer_mainapp
 * @author Janelle Salisbury
 * date Mar 6, 2013
 */
package com.mediaplayer_mainapp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.app.ListActivity;

// TODO: Auto-generated Javadoc
/**
 * The Class MainActivity will hold the android media player and play the users sd card media files.
 */
public class MainActivity extends ListActivity {
	//GLOBAL VARIABLES
	private static final String MEDIA_PATH = new String("/sdcard/");
	private List<String> songs = new ArrayList<String>();
	private MediaPlayer mp = new MediaPlayer();
	private int currentPostion = 0;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.songlist);
		updateSongList();
		
	}
	//UPDATE SONGS FUNCTIONALITY
	private void updateSongList() {
		//create file object (home) which points to the sd card path
		File home = new File(MEDIA_PATH);
		if(home.listFiles(new Mp3Filter()).length > 0){
			for(File file:home.listFiles(new Mp3Filter())){
				songs.add(file.getName());
			}
			//create array adapter for song list
			ArrayAdapter<String> songList = new ArrayAdapter<String> (this, R.layout.song_item, songs);
			setListAdapter(songList);
		}
		
	}
}