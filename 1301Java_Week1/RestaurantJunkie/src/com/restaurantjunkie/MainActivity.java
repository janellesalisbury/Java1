package com.restaurantjunkie;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final EditText et = (EditText) findViewById(R.id.edit_message);
		
		//Button to begin second activity
		Button send = (Button) findViewById(R.id.send_button);
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
				intent.putExtra("restaurant_name", et.getText().toString());
				if(et.getText().toString().equals("") || et.getText().toString() == null){
					Toast.makeText(getApplicationContext(), "Please enter restaurant", Toast.LENGTH_LONG).show();
				}else{
				
				startActivity(intent);
				
				}
				
			}
		});
		
	}

	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
