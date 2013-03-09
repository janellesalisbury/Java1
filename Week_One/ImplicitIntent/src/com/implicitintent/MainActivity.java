package com.implicitintent;

import java.net.URL;

import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;

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
        	url = new URL(data.getScheme(), data.getHost(),
                               data.getPath());
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
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
