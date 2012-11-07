package com.salisbury.libs;

import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;


public class Favorites extends LinearLayout{
	
	Button _add;
	Button _delete;
	Spinner _stateList;
	Context _context;
	LayoutParams lp;
	
	public Favorites(Context context){
		super(context);
		_context = context;
		
		
		_stateList = new Spinner(_context);
		lp = new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f);
		_stateList.setLayoutParams(lp);
		
		_add = new Button(_context);
		_add.setText("Add");
		
		_delete = new Button(_context);
		_delete.setText("Delete");
		
		this.addView(_stateList);
		this.addView(_add);
		this.addView(_delete);
		
		lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(lp);
		
	}

}
