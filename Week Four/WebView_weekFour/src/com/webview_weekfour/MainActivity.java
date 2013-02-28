package com.webview_weekfour;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;

public class MainActivity extends Activity implements OnClickListener{
	//GLOBAL VARIABLES
	EditText url;
	WebView myBrowser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//SET UP WEBVIEW AND OPEN URL
		myBrowser = (WebView) findViewById(R.id.wvBrowser);
		myBrowser.loadUrl("http://www.yahoo.com");
		//HIDE KEYBOARD AUTOMATICALLY
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		//FIND THE BUTTONS
		Button go = (Button) findViewById(R.id.go_button);
		Button forward = (Button) findViewById(R.id.forward_button);
		Button back = (Button) findViewById(R.id.back_button);
		Button refresh = (Button) findViewById(R.id.refresh_button);
		Button clear = (Button) findViewById(R.id.clear_button);
		//FIND EDIT TEXT
		url = (EditText) findViewById(R.id.etURL);
		//CREATE SERIES OF ONCLICK LISTENERS FOR BUTTONS
		go.setOnClickListener(this);
		forward.setOnClickListener(this);
		back.setOnClickListener(this);
		refresh.setOnClickListener(this);
		clear.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.go_button:
			String theUrl = url.getText().toString();
			myBrowser.loadUrl(theUrl);
			break;
		case R.id.back_button:
			if(myBrowser.canGoBack())
			myBrowser.goBack();
			break;
		case R.id.forward_button:
			if(myBrowser.canGoForward())
			myBrowser.goForward();
			break;
		case R.id.refresh_button:
			myBrowser.reload();
			break;
		case R.id.clear_button:
			myBrowser.clearHistory();
			break;
		}

		
	}

	
		
}
	




