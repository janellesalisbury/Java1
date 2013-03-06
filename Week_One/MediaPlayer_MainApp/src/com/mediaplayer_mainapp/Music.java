package com.mediaplayer_mainapp;

import java.io.FileDescriptor;
import java.io.IOException;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

public class Music implements OnCompletionListener{
	MediaPlayer mediaPlayer;
	boolean isPrepared = false;
	
	//CREATE MUSIC PLAYER AND LOCATE FILES
	public Music(AssetFileDescriptor assetDescriptor){
		mediaPlayer = new MediaPlayer();
		try{
			mediaPlayer.setDataSource(assetDescriptor.getFileDescriptor(), 
					assetDescriptor.getStartOffset(), assetDescriptor.getLength());
			mediaPlayer.prepare();
			isPrepared = true;
			mediaPlayer.setOnCompletionListener(this);
		}catch(Exception exception){
			throw new RuntimeException("Can't find your totally cool music man!");
		}
	}
	public Music(FileDescriptor fileDescriptor){
		mediaPlayer = new MediaPlayer();
		try{
			mediaPlayer.setDataSource(fileDescriptor);
			mediaPlayer.prepare();
			isPrepared = true;
			mediaPlayer.setOnCompletionListener(this);
		}catch(Exception exception){
			throw new RuntimeException("No music present, sorry");
		}
	}

	@Override
	public void onCompletion(MediaPlayer mediaPlayer) {
		synchronized (this) {
			isPrepared = false;
		}
		
	}
	//PLAY FUNCTIONALITY
	public void play(){
		if(mediaPlayer.isPlaying()){
			return;
		}
		try{
			synchronized (this) {
				if(!isPrepared){
					mediaPlayer.prepare();
				}
				mediaPlayer.start();
			}
		}catch(IllegalStateException e){
			e.printStackTrace();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	//STOP FUNCTIONALITY
	public void stop(){
		mediaPlayer.stop();
		synchronized (this) {
			isPrepared = false;
		}
	}
}
