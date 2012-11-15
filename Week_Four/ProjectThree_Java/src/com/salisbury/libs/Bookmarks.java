package com.salisbury.libs;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class Bookmarks extends LinearLayout {
	
	Button _add;
	Button _remove;
	public Spinner _list;
	Context _context;
	ArrayList<String> _stateData = new ArrayList<String>();
	
	public Bookmarks(Context context) {
		super(context);
		createBookmarks(context);
	}
	
	
		private void createBookmarks(Context context){
		_context = context;
		LayoutParams lp;
		lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(lp);
		_stateData.add("SELECT BOOKMARK");
		
		//CREATE SPINNER FOR BOOKMARKS
		_list = new Spinner(_context);
		lp = new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f);
		_list.setLayoutParams(lp);
		ArrayAdapter<String>listAdapter = new ArrayAdapter<String>(_context, android.R.layout.simple_spinner_item, _stateData);
		listAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		_list.setAdapter(listAdapter);
		
		//FUNCTIONALITY OF BUTTONS
		
		_list.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View v,
					int pos, long id) {
				Log.i("BOOKMARK SELECTED", parent.getItemAtPosition(pos).toString());
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				Log.i("BOOKMARK SELECTED", "NADA");
				
			}
		});

		updateBookmarks();
		
		//ADD BUTTONS/TEXT
		_add = new  Button(_context);
		_remove = new Button(_context);
		_add.setText("Add");
		_add.setTextColor(Color.RED);
		_remove.setText("Remove");
		_remove.setTextColor(Color.RED);
		
		this.addView(_list);
		this.addView(_add);
		this.addView(_remove);
		
	
		
	}
	private void updateBookmarks(){
		_stateData.add("New York");
		_stateData.add("Nevada");
	}

	
}
	

