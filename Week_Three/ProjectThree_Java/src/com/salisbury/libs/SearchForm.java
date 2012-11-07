package com.salisbury.libs;

import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;



public class SearchForm extends LinearLayout{
	
	Spinner _stateList;
	Button _search;
	Context _context;
	LayoutParams lp;
	
	public SearchForm(Context context){
		super(context);
		_context = context;
		
		
		_stateList = new Spinner(_context);
		lp = new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f);
		_stateList.setLayoutParams(lp);
		
		_search = new Button(_context);
		_search.setText("Search");
		
		this.addView(_stateList);
		this.addView(_search);
		
		lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(lp);
		
	}

}
