package com.androidmusicplayer;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;

public class SongsManager {
	//SD CARD PATH
	final String MEDIA_PATH = new String("/sdcard/");
	private ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
	
	//CONSTRUCTOR
	public SongsManager(){
		
	}
	
	//READ FILES AND STORE TO LIST
	public ArrayList<HashMap<String, String>> getPlayList(){
		File home = new File(MEDIA_PATH);
		
		if (home.listFiles(new FileExtensionFilter()).length > 0){
			for (File file : home.listFiles(new FileExtensionFilter())){
				HashMap<String, String> song = new HashMap<String, String>();
				song.put("songTitle", file.getName().substring(0, (file.getName().length() - 4)));
				song.put("songPath", file.getPath());
				
				//ADD THE SONG TO THE LIST
				songsList.add(song);
			}
		}
		//RETURN SONGS ARRAY
		return songsList;
				
	}
	//FILTER MP3 FILES
	class FileExtensionFilter implements FilenameFilter{
		public boolean accept(File dir, String name) {
            return (name.endsWith(".mp3") || name.endsWith(".MP3"));

	}
}

}
