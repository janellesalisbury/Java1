package com.salisbury.libs;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;




public class SearchForm extends LinearLayout{
	
	Spinner _stateList;
	Button _searchButton;
	Context _context;
	LayoutParams lp;
	ArrayList<String> _states = new ArrayList<String>();
	
	public SearchForm(Context context){
		super(context);
		_context = context;
		
		_states.add("Select State");
		_stateList = new Spinner(_context);
		lp = new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f);
		_stateList.setLayoutParams(lp);
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(_context, android.R.layout.simple_spinner_item, _states);
		listAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		_stateList.setAdapter(listAdapter);
		_stateList.setOnItemSelectedListener(new OnItemSelectedListener(){
			
			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int pos, long id){
				Log.i("STATE SELECTED", parent.getItemAtPosition(pos).toString());
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> parent){
				Log.i("STATE SELECTED", "NONE");
			}
		});
		updateStates();

			
		_searchButton = new Button(_context);
		_searchButton.setText("Search");
		
		this.addView(_stateList);
		this.addView(_searchButton);
		
		lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(lp);
		
	}
	private void updateStates(){
		_states.add("Alabama");
		_states.add("Alaska");
		_states.add("Arizona");
		_states.add("Arkansas");
		_states.add("California");
		_states.add("Colorado");
		_states.add("Connecticut");
		_states.add("Delaware");
		_states.add("Florida");
		_states.add("Georgia");
		_states.add("Hawaii");
		_states.add("Idaho");
		_states.add("Illinois");
		_states.add("Indiana");
		_states.add("Iowa");
		_states.add("Kansas");
		_states.add("Kentucky");
		_states.add("Louisiana");
		_states.add("Maine");
		_states.add("Maryland");
		_states.add("Massachucetts");
		_states.add("Michigan");
		_states.add("Minnesota");
		_states.add("Mississippi");
		_states.add("Missouri");
		_states.add("Montana");
		_states.add("Nebraska");
		_states.add("Nevada");
		_states.add("New Hampshire");
		_states.add("New Jersey");
		_states.add("New Mexico");
		_states.add("New York");
		_states.add("North Carolina");
		_states.add("North Dakota");
		_states.add("Ohio");
		_states.add("Oklahoma");
		_states.add("Oregon");
		_states.add("Pennsylvania");
		_states.add("Rhode Island");
		_states.add("South Carolina");
		_states.add("South Dakota");
		_states.add("Tennessee");
		_states.add("Texas");
		_states.add("Utah");
		_states.add("Vermont");
		_states.add("Virginia");
		_states.add("Washington");
		_states.add("West Virginia");
		_states.add("Wisconsin");
		_states.add("Wyoming");
		
		
	}
	public Button getButton(){
		return _searchButton;
	}
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return _states;
	}

}
