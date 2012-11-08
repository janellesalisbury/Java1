package com.salisbury.libs;

import android.content.Context;
import android.widget.GridLayout;
import android.widget.TextView;

public class StateDisplays extends GridLayout{
	
	TextView _name;
	TextView _population;
	TextView _popJailed;
	Context _context;
	
	public StateDisplays(Context context){
		super(context);
		
		_context = context;
		
		this.setColumnCount(2);
		
		TextView nameLabel = new TextView(_context);
		nameLabel.setText("State Name:");
		_name = new TextView(_context);
		
		TextView populationLabel = new TextView(_context);
		populationLabel.setText("Population:");
		_population = new TextView(_context);
		
		TextView populationJailedLabel = new TextView(_context);
		populationJailedLabel.setText("Incarcerated Population:");
		_popJailed = new TextView(_context);
		
		this.addView(nameLabel);
		this.addView(_name);
		
		this.addView(populationLabel);
		this.addView(_population);
		
		this.addView(populationJailedLabel);
		this.addView(_popJailed);
		
		
		
		
	}

}
