package com.javaweek2_fragmentproject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.os.Messenger;

public class DownloadService extends IntentService {
	private int result = Activity.RESULT_CANCELED;
	
	public DownloadService() {
		super("DownloadService");
		
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		try{
			Thread.sleep(3000);
		}catch(InterruptedException e2){
			e2.printStackTrace();
		}
		Uri data = intent.getData();
		String urlPath = intent.getStringExtra("urlpath");
		String fileName = data.getLastPathSegment();
		
		//create file and download URL
		File output = new File(Environment.getExternalStorageDirectory(), fileName);
		if(output.exists()){
			output.delete();
		}
		
		InputStream is = null;
		FileOutputStream fos = null;
		try{
			URL url = new URL(urlPath);
			is = url.openConnection().getInputStream();
			InputStreamReader reader = new InputStreamReader(is);
			fos = new FileOutputStream(output.getPath());
			int next = -1;
			while((next = reader.read()) != -1){
				fos.write(next);
			}
			//successful transaction
			result = Activity.RESULT_OK;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(is !=null){
				try{
					is.close();	
		}catch(IOException e){
			e.printStackTrace();
		}
	}
			if(fos !=null){
				try{
					fos.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		
		Bundle extra = intent.getExtras();
		if(extra !=null){
			//retrieve messenger from intent extras
			Messenger messenger = (Messenger) extra.get("MESSENGER");
			Message message = Message.obtain();
			message.arg1 = result;
		}
	}
}
