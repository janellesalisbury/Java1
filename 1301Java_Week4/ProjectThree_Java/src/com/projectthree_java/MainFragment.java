package com.projectthree_java;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainFragment extends Fragment{
	
	private MainListener listener;
	
	public interface MainListener{
		public void onStateSearch(String state);
		public void onBookmarkList();
		void onAddBookmark();
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflateMain, ViewGroup container, Bundle savedInstanceState){
		super.onCreateView(inflateMain, container, savedInstanceState);
		
		LinearLayout view = (LinearLayout) inflateMain.inflate(R.layout.activity_main, container, false);
	
        //CREATING SPINNER AND CONVERTING STATE CODE TO STATE NAME
		Spinner state_names = (Spinner) view.findViewById(R.id.spinner);
		state_names.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int pos, long arg3) {
				
				String selected = parent.getItemAtPosition(pos).toString();
				
				Log.i("ITEM SELECTED",selected);
				Log.i("ITEM SELECTED", pos+"");
				
				String code = (pos+1)+"";
				
				listener.onStateSearch(code);
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				
			}
			
			
		});
		
		
        //CREATE GO TO BOOKMARKS BUTTON
        Button bkmkButton = (Button) view.findViewById(R.id.bookmarks_button);
        bkmkButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				listener.onBookmarkList();	
			}
		});

        //ADD BOOKMARK BUTTON
        Button addBkmk = (Button) view.findViewById(R.id.addbkmk_button);
        addBkmk.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				listener.onAddBookmark();
			}
		});
        
        
		
		return view;
	};
	
	//MAKE SURE ACTIVITY IMPLEMENTS THE LISTENER	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		try{
			listener = (MainListener) activity;
		}catch(ClassCastException e){
			throw new ClassCastException(activity.toString() +"must implement MainListener fool!");
		}
	}
}


	
	


