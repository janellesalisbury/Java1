package com.salisbury.libs;

import org.json.JSONArray;
import org.json.JSONException;


import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.TextView;

public class StateDisplays extends GridLayout{
	
	static TextView _population;
	static TextView _popWhite;
	static TextView _popBlack;
	static TextView _popNativeAmerican;
	static TextView _popHawaiian;
	Context _context;
	static JSONArray _statedata;
	
	public StateDisplays(Context context){
		super(context);
		
		_context = context;
		
		this.setColumnCount(2);
		
		TextView populationLabel = new TextView(_context);
		populationLabel.setText("Total Population:");
		populationLabel.setTextColor(Color.BLUE);
		_population = new TextView(_context);
		
		TextView populationWhite = new TextView(_context);
		populationWhite.setText("White:");
		populationWhite.setTextColor(Color.BLUE);
		_popWhite = new TextView(_context);
		
		TextView populationBlack = new TextView(_context);
		populationBlack.setText("Black:");
		populationBlack.setTextColor(Color.BLUE);
		_popBlack = new TextView(_context);
		
		TextView populationNative = new TextView(_context);
		populationNative.setText("Native American:");
		populationNative.setTextColor(Color.BLUE);
		_popNativeAmerican = new TextView(_context);
		
		TextView populationHawaiian = new TextView(_context);
		populationHawaiian.setText("Hawaiian/Other:");
		populationHawaiian.setTextColor(Color.BLUE);
		_popHawaiian = new TextView(_context);
		
		this.addView(populationLabel);
		this.addView(_population);
		
		this.addView(populationWhite);
		this.addView(_popWhite);
		
		this.addView(populationBlack);
		this.addView(_popBlack);
		
		this.addView(populationNative);
		this.addView(_popNativeAmerican);
		
		this.addView(populationHawaiian);
		this.addView(_popHawaiian);
	}
	
	public static void updateData(JSONArray data){
		_statedata = data;
		try{
		_population.setText(data.getString(0));
		
		
		_popWhite.setText(data.getString(1));
		
		
		_popBlack.setText(data.getString(2));
		
		
		_popNativeAmerican.setText(data.getString(3));
		
		_popHawaiian.setText(data.getString(4));
		
		} catch (JSONException e){
			Log.i("JSON EXCEPTION", data.toString());
		}
	}

}
