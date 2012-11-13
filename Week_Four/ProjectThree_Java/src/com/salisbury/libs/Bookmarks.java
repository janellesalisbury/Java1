package com.salisbury.libs;

import java.util.ArrayList;

import android.content.Context;
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
	Spinner _list;
	Context _context;
	ArrayList<String> _stateData = new ArrayList<String>();
	
	public Bookmarks(Context context) {
		super(context);
		_context = context;
		
		LayoutParams lp;
		
		_stateData.add("Select Bookmark");
		_list = new Spinner(_context);
		lp = new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f);
		_list.setLayoutParams(lp);
		ArrayAdapter<String>listAdapter = new ArrayAdapter<String>(_context, android.R.layout.simple_spinner_item, _stateData);
		listAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		_list.setAdapter(listAdapter);
		_list.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View v,
					int pos, long id) {
				Log.i("SELECTED BOOKMARK", parent.getItemAtPosition(pos).toString());
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> parent){
				Log.i("SELECTED BOOKMARK", "NONE");
			}
		
	});
		
		updateBookmarks();
		
		_add = new  Button(_context);
		_remove = new Button(_context);
		_add.setText("Add");
		_remove.setText("Remove");
		
		this.addView(_list);
		this.addView(_add);
		this.addView(_remove);
		
		lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(lp);
		
	}
	private void updateBookmarks(){
		_stateData.add("New York");
		_stateData.add("California");
	}
	
	
	
	}


