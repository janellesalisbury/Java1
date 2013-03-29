/*
 * project HybridApp_Week4
 * package com.hybridapp_week4
 * @author Janelle Salisbury
 * date Mar 28, 2013
 */
package com.hybridapp_week4;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.Menu;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;

// TODO: Auto-generated Javadoc
/**
 * The Class MainActivity.
 */
@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity {
	
	EditText input;
	String inputSent;
	WebView myWebView;
	//updating
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
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
	/**
	 * The Class WebAppInterface.
	 */
	public class WebAppInterface{
		Context _context;
		
		/**
		 * Instantiates a new web app interface.
		 *
		 * @param c the c
		 */
		WebAppInterface(Context c){
			_context = c;
		}
		
		/**
		 * Display task info.
		 *
		 * @param theTask the the task
		 * @param theLoc the the loc
		 * @return true, if successful
		 */
		@JavascriptInterface
		public boolean displayTaskInfo(String theTask, String theLoc){
			//START DETAIL ACTIVITY AND PASS DATA FOR THE TASK NAME AND LOCATION TO DETAILS VIEW
			Log.i("TaskName", theTask);
			Log.i("TaskLoc", theLoc);
			Intent intent = new Intent(MainActivity.this, DetailView.class);
			intent.putExtra("TaskName",  theTask); 
			intent.putExtra("TaskLoc", theLoc);
	        startActivity(intent);
			
			return true;
		}
		
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
