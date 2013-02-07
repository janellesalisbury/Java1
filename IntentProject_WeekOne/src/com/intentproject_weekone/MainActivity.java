package com.intentproject_weekone;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class MainActivity extends Activity {
	
	private Button searchButton;
	EditText editText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		final Context context = this;
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editText = (EditText) findViewById(R.id.edit_text);
		
		 searchButton = (Button) findViewById(R.id.search_button);
		 searchButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent launcher = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + editText.getText().toString() + ".com"));
				launcher.putExtra("url", "http://" + editText.getText().toString() + ".com");
				startActivity(launcher);
				
			}
		});
		
		
		
	}

}
