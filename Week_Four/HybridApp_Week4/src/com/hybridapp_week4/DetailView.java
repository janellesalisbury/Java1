package com.hybridapp_week4;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
		File data = getExternalFilesDir(null);
		String path = data.getAbsolutePath();
		
		Button save = (Button) findViewById(R.id.button1);
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				

				
				
			}
		});
		
		
	}
	
	//CHECK FOR EXTERNAL STORAGE
	public boolean isStorageAvailable(){
		String available = Environment.getExternalStorageState();
		if(available.equals(Environment.MEDIA_MOUNTED)){
			return true;
		}else if(available.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
			Toast.makeText(this, "Read Only", Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(this, "No Storage Available", Toast.LENGTH_SHORT).show();
			
		}
		return false;
		
	}

}
