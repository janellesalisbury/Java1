package com.mediaplayer_mainapp;

import java.io.FileDescriptor;
import java.io.IOException;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

public class Music implements OnCompletionListener{
	MediaPlayer mediaPlayer;
	boolean isPrepared = false;
	
	//INSTANTIATE MEDIA PLAYER AND CONTROL IT
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
	//SWITCH TRACK FUNCTIONALITY
	public void switchTracks(){
		mediaPlayer.seekTo(0);
		mediaPlayer.pause();
	}
	//PAUSE FUNCTIONALITY
	public void pause(){
		mediaPlayer.pause();
	}
	//PLAYING TRUE OR FALSE?
	public boolean isPlaying(){
		return mediaPlayer.isPlaying();
	}
	//LOOPING SONGS?
	public boolean isLooping(){
		return mediaPlayer.isLooping();
	}
	//SET TRACK LOOPING HERE
	public void setLooping(boolean isLooping){
		mediaPlayer.setLooping(isLooping);
	}
	//VOLUME CONTROL
	public void setVolume(float volumeLeft, float volumeRight){
		mediaPlayer.setVolume(volumeRight, volumeLeft);
	}
	//STOP AND CLOSE
	public void dispose(){
		if(mediaPlayer.isPlaying()){
			stop();
		}
		mediaPlayer.release();
	}
}
