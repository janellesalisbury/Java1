package com.projectthree_java;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

public class Bookmark extends Activity implements BookmarkFragment.BookmarkListener{
	
	Context _context;
	ArrayList<String> _state = new ArrayList<String>();
	String _choice;


	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bookmark_frag);
		
		_context = this;
	}

	//INFLATE MENU
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	//FINISH THE ACTIVITY/PLACE DATA FROM INTENT
	@Override
	public void finish(){
		Intent data = new Intent();
		data.putExtra("state", _choice);
		setResult(RESULT_OK, data);
		super.finish();
	}
	
	public void onBookmarkSelected(String state){
		_choice = state;
		finish();
	}

}


