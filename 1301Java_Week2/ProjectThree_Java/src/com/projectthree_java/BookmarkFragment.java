package com.projectthree_java;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class BookmarkFragment extends Fragment {
	
	private BookmarkListener listener;
	private ArrayList<String> _state;
	private ArrayAdapter<String> _listAdapter;
	
	public interface BookmarkListener{
		public void onBookmarkSelected(String state);
		
	};
	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		try{
			listener = (BookmarkListener) activity;
		}catch(ClassCastException e){
			throw new ClassCastException(activity.toString() + "where's yo BookmarkListener yo!");
		}
	};
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		String bkmkString = FileStuff.readStringFile(getActivity(), "bookmark", true);
		String[] bkmkArray = bkmkString.split(",");
		_state = new ArrayList<String>(Arrays.asList(bkmkArray));
	};
	

}
