package com.hybridapp_week4;

import java.io.File;

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
		
		//CREATE TEXTVIEWS AND SET THE PASSED DATA
		TextView tv = (TextView) findViewById(R.id.task);
		tv.setText(getIntent().getExtras().getString("TaskName"));
		
		TextView tv2 = (TextView) findViewById(R.id.locale);
		tv2.setText(getIntent().getExtras().getString("TaskLoc"));
		
		//CREATE THE FILE TO SAVE
		File data = getFilesDir();
		String path = data.getAbsolutePath();
		
		Button save = (Button) findViewById(R.id.button1);
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
			}
		});
		
		
	}

}
