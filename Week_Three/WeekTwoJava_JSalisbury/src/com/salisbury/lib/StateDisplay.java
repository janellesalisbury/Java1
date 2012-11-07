package com.salisbury.lib;

import android.content.Context;
import android.widget.GridLayout;
import android.widget.TextView;

public class StateDisplay extends GridLayout {
	
	TextView _name;
	TextView _population;
	TextView _percentWomen;
	Context _context;
	
	public StateDisplay(Context context){
		super (context);
		
		_context = context;
		
		this.setColumnCount(2);
		TextView nameLabel = new TextView(_context);
		nameLabel.setText("State Name:");
		_name = new TextView(_context);
		
		TextView populationLabel = new TextView(_context);
		populationLabel.setText("Population:");
		_population = new TextView(_context);
		
		TextView percentWomenLabel = new TextView(_context);
		percentWomenLabel.setText("Percentage of Women");
		_percentWomen = new TextView(_context);
		
		this.addView(nameLabel);
		this.addView(_name);
		this.addView(populationLabel);
		this.addView(_population);
		this.addView(percentWomenLabel);
		this.addView(_percentWomen);
		
	}
	
	
	

}
