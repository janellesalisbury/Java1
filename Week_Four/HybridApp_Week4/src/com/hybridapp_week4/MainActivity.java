package com.hybridapp_week4;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;

@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//GET REFERENCE TO THE WEBVIEW
		WebView myWebView = (WebView) findViewById(R.id.webView1);
		//ENABLE JAVASCRIPT
		WebSettings myWebSettings = myWebView.getSettings();
		myWebSettings.setJavaScriptEnabled(true);
		//LOAD HTML DOCUMENT
		myWebView.loadUrl("file:///android_assets/index.html");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
