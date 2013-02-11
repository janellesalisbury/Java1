package com.androidmusicplayer;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.os.Bundle;

public class PlayListActivity extends ListActivity{
	//PLAY LIST
	public ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playlist);
		
		
	}
	

}
