package com.hybridapp_week4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DetailView extends Activity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_view);
		
		//SET THE DATA TO THE CORRESPONDING TEXT VIEW AND DISPLAY IT
		TextView tv = (TextView) findViewById(R.id.task);
		tv.setText(getIntent().getExtras().getString("TaskName"));
		
		TextView tv2 = (TextView) findViewById(R.id.locale);
		tv2.setText(getIntent().getExtras().getString("TaskLoc"));
		
		TextView tv3 = (TextView) findViewById(R.id.date);
		tv3.setText(getIntent().getExtras().getString("TaskDate"));
		
		//CREATE BUTTON ONCLICK AND ADD SAVE FUNCTIONALITY
		Button save = (Button) findViewById(R.id.save);
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

}
