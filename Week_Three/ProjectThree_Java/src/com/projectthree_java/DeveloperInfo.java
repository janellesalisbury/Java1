/*
 * project ProjectThree_Java
 * package com.projectthree_java
 * @author Janelle Salisbury
 * date Mar 19, 2013
 */
package com.projectthree_java;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

// TODO: Auto-generated Javadoc
/**
 * The Class DeveloperInfo.
 */
public class DeveloperInfo extends Activity{
	
	//GLOBAL VARIABLES
	private WebView wv;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@SuppressLint("SetJavaScriptEnabled")
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dev_info);
 
		wv = (WebView) findViewById(R.id.webView1);
		wv.getSettings().setJavaScriptEnabled(true);
		wv.loadUrl("http://www.linkedin.com/profile/view?id=216001416");
 
	}
 
}


