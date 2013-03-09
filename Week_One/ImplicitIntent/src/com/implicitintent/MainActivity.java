package com.implicitintent;

import java.net.URL;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.webkit.WebView;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//get intent data and show site
		Intent intent = getIntent();
        Uri data = intent.getData();
        URL url = null;
        
        try {
        	//request http scheme and the path for the program to open
        	url = new URL(data.getScheme(), data.getHost(),
                               data.getPath());
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
        //load and display webview after user has selected which program to use to open it
        WebView webView = (WebView) findViewById(R.id.webView1);   
        webView.loadUrl(url.toString());
		
		
	}

	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
