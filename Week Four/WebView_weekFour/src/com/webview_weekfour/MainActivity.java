package com.webview_weekfour;

import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;
import android.app.Activity;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		WebView myBrowser = (WebView) findViewById(R.id.wvBrowser);
		myBrowser.loadUrl("http://www.yahoo.com");
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
	}



}
