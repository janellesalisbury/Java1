package com.projectthree_java;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainFragment extends Fragment {
	
	public interface FormListener{
		public void onStateSearch(int code);
		public void onBookmarkList();
		public void onAddBookmark();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflateMain, ViewGroup container, Bundle savedInstanceState){
		super.onCreateView(inflateMain, container, savedInstanceState);
		
		LinearLayout view = (LinearLayout) inflateMain.inflate(R.layout.activity_main, container, false);
		
		//ADD CLICK EVENT HANDLER FOR SEARCH FEATURE
        Button searchButton = (Button) getActivity().findViewById(R.id.search_button);
        searchButton.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        		EditText field = (EditText) getActivity().findViewById(R.id.search_field);
        		String state = field.getText().toString();
        		field.setText(state);
        		//Get state information 
        		getInfo(state);
        		InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        		imm.hideSoftInputFromInputMethod(field.getWindowToken(), 0);
        		getInfo(state);
        	}
        });
        
        
        //CREATE GO TO BOOKMARKS BUTTON
        Button bkmkButton = (Button) getActivity().findViewById(R.id.bookmark_button);
        bkmkButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			Intent i = new Intent(_context, Bookmark.class);
			startActivityForResult(i, REQUEST_CODE);
			
				
			}
		});
        

        //ADD BOOKMARK BUTTON
        Button addBkmk = (Button) getActivity().findViewById(R.id.addbkmk_button);
        addBkmk.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String stateInfo = ((TextView) getActivity().findViewById(R.id.search_field)).getText().toString();
				if(stateInfo !=null){
					if(_bookmark.length() > 0){
						_bookmark = _bookmark.concat(","+stateInfo);
					}else{
						_bookmark = stateInfo;
						
					}
					FileStuff.storeStringFile(_context, "bookmark", _bookmark, true);
				}
				
			}
		});
        
        
		
		return view;
	};

}
