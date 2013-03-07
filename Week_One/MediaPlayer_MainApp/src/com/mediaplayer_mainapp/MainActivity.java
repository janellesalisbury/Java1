/*
 * project MediaPlayer_MainApp
 * package com.mediaplayer_mainapp
 * @author Janelle Salisbury
 * date Mar 6, 2013
 */
package com.mediaplayer_mainapp;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.annotation.SuppressLint;
import android.app.ListActivity;

//CREATE CLASS TO HANDLE THE MP3 FILTER
	class Mp3Filter implements FilenameFilter{

		@Override
		public boolean accept(File dir, String name) {
			//RETURNS ONLY MP3 FILES
			return (name.endsWith(".mp3"));
		}
	}

// TODO: Auto-generated Javadoc
/**
 * The Class MainActivity will hold the android media player and play the users sd card media files.
 */
public class MainActivity extends ListActivity {
	//GLOBAL VARIABLES
	@SuppressLint("SdCardPath")
	private static final String MEDIA_PATH = new String("/sdcard/");
	private List<String> songs = new ArrayList<String>();
	private MediaPlayer mp = new MediaPlayer();
	private int currentPosition = 0;
	
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
	 	//notifies user when song is clicked from list 
		@Override
	    protected void onListItemClick(ListView l, View v, int position, long id) {
			currentPosition = position;
			playSong(MEDIA_PATH + songs.get(position));
			
		}
		//PLAY FUNCTIONALITY(reset player, get the song, prepare for play, start song)
		private void playSong(String songPath) {
			try{
				mp.reset();
				mp.setDataSource(songPath);
				mp.prepare();
				mp.start();
				//setup listener so next song auto-starts
				mp.setOnCompletionListener(new OnCompletionListener() {
					
					@Override
					public void onCompletion(MediaPlayer mp) {
						nextSong();	
					}
				});
			}catch(IOException e){
				Log.v(getString(R.string.app_name), e.getMessage());
			}	
		}
		//play next song or reset player
		private void nextSong(){
			if(++currentPosition >= songs.size()){
				//if last song then reset
				currentPosition = 0;
			}else{
				//play next song in list
				playSong(MEDIA_PATH + songs.get(currentPosition));
			}
		}
	
}