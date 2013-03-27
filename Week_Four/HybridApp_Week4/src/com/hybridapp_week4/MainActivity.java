package com.hybridapp_week4;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;

@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//FORCE PORTRAIT ORIENTATION
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		//CREATE AND GET REFERENCE TO WEBVIEW AND ADD JAVASCRIPT COMPATIBILITY
		WebView myWebView = (WebView) findViewById(R.id.webView1);
		WebSettings myWebSettings = myWebView.getSettings();
		myWebSettings.setJavaScriptEnabled(true);
		myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
		myWebView.loadUrl("file:///android_asset/taskteller.html");
		
		
	}
	
	//CREATE WEB INTERFACE TO HANDLE JAVASCRIPT FUNCTIONALITY
	public class WebAppInterface{
		Context _context;
		WebAppInterface(Context c){
			_context = c;
		}
		
		@JavascriptInterface
		public void displayTaskInfo(Intent intent){
			//START DETAIL ACTIVITY AND PASS DATA FOR THE TASK NAME AND LOCATION TO DETAILS VIEW
			intent = new Intent(MainActivity.this, DetailView.class);
			startActivity(intent);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
