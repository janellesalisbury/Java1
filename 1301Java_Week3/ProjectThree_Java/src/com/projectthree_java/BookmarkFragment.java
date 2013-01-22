package com.projectthree_java;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

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
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		LinearLayout view = (LinearLayout) inflater.inflate(R.layout.bookmarks,container, false);
		
		//List Adapter
		ListView myBookmk = (ListView) view.findViewById(R.id.bkmklist);
		_listAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);
		myBookmk.setAdapter(_listAdapter);
		
		//OPEN ITEMS FROM LISTVIEW
		myBookmk.setOnItemClickListener(new AdapterView.OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int pos, long id){
				
			}
		});
		
		return view;
	}
	
}
