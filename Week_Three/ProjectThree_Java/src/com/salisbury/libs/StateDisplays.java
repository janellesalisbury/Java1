package com.salisbury.libs;

import android.content.Context;
import android.widget.GridLayout;
import android.widget.TextView;

public class StateDisplays extends GridLayout{
	
	TextView _name;
	TextView _population;
	TextView _percentWomen;
	Context _context;
	
	public StateDisplays(Context context){
		super(context);
		
		_context = _context;
		
		this.setColumnCount(3);
		
		TextView nameLabel = new TextView(_context);
		nameLabel.setText("State Name:");
		_name = new TextView(_context);
		
		TextView populationLabel = new TextView(_context);
		populationLabel.setText("Population:");
		_population = new TextView(_context);
		
		TextView percentWomenLabel = new TextView(_context);
		percentWomenLabel.setText("Percentage of Women:");
		_percentWomen = new TextView(_context);
		
		this.addView(nameLabel);
		this.addView(_name);
		this.addView(populationLabel);
		this.addView(_population);
		this.addView(percentWomenLabel);
		this.addView(_percentWomen);
		
		
		
		
	}

}
