package com.hybridapp_week4;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailView extends Activity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_view);
		
		TextView tv = (TextView) findViewById(R.id.task);
		tv.setText(getIntent().getExtras().getString("TaskName"));
		
		TextView tv2 = (TextView) findViewById(R.id.locale);
		tv2.setText(getIntent().getExtras().getString("TaskLoc"));
		
	}

}
