/*
 * project WeatherCenter
 * package com.weathercenter
 * @author Janelle Salisbury
 * date Mar 9, 2013
 */
package com.weathercenter;

import java.net.URL;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.webkit.WebView;

// TODO: Auto-generated Javadoc
/**
 * The Class MainActivity.
 */
public class MainActivity extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//RECEIVE INTENT DATA
		Intent intent = getIntent();
		Uri site = intent.getData();
		URL address = null;
		
		try{
			address = new URL(site.getScheme(), site.getHost(), site.getPath());
		}catch(Exception exception){
			exception.printStackTrace();
			
		}
		//LOAD INTO A WEBVIEW AND ENJOY
		WebView myView = (WebView) findViewById(R.id.webView1);
		myView.loadUrl(site.toString());
	}

	

}
