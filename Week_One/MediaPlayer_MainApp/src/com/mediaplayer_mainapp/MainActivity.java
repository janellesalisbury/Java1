package com.mediaplayer_mainapp;

import java.io.File;
import java.util.List;
import java.util.Random;

import android.os.Bundle;
import android.os.PowerManager.WakeLock;
import android.app.Activity;
import android.content.res.AssetManager;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	//GLOBAL VARIABLES
	WakeLock wakelock;
	private static final String[] EXTENSIONS = {".mp3", ".mid", ".wav", ".ogg", ".mp4"}; //types of files that can be played
	List<String> songNames; //song titles
	List<String> songArt; //song artwork
	AssetManager assets; //(compiled with APK)
	File path; //SD Card directory (music)
	File path2; //SD Card directory (artwork)
	Music track; //Current song
	ImageView bg; //current song artwork
	Button btnPlay; //Play/Pause button
	Random random; //shuffle songs
	boolean isTuning; //auto play next track
	boolean shuffle; //is shuffle on?
	int currentTrack; //current selected track index
	int type; //0 for assets, 1 for SD Card

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
