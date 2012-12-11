package com.javaweek2_fragmentproject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.view.View;
import android.widget.Toast;

public class ActorDetailsView extends Activity {
	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {
	    public void handleMessage(Message message) {
	      Object path = message.obj;
	      if (message.arg1 == RESULT_OK && path != null) {
	        Toast.makeText(ActorDetailsView.this,
	            "Downloaded" + path.toString(), Toast.LENGTH_LONG)
	            .show();
	      } else {
	        Toast.makeText(ActorDetailsView.this, "Download failed.",
	            Toast.LENGTH_LONG).show();
	      }

	    };
	  };
//
//	  @Override
//  public void onCreate(Bundle savedInstanceState) {
//	    super.onCreate(savedInstanceState);
//	    setContentView(R.layout.main);
//
//	  }

	  public void onClick(View view) {
		  Intent intent = new Intent(this, DownloadService.class);
	    // Create a new Messenger for the communication back
	    Messenger messenger = new Messenger(handler);
	    intent.putExtra("MESSENGER", messenger);
	    intent.setData(Uri.parse("http://www.imdb.com"));
	    intent.putExtra("urlpath", "http://www.imdb.com");
	    startService(intent);
  }


	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
        	finish();
        	return;
        }
        setContentView(R.layout.image_viewer_activity);
    	Intent launchingIntent = getIntent();
    	int item = launchingIntent.getIntExtra("item", 0);
    	ActorDetailsFragment viewer = (ActorDetailsFragment) getFragmentManager().findFragmentById(R.id.image_viewer_fragment);
    	viewer.update(item);
    	}
	}

