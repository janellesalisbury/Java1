package com.projectthree_java;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

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
		
		//ADD CLICK EVENT HANDLER FOR SEARCH FEATURE
        Button searchButton = (Button) view.findViewById(R.id.search_button);
        searchButton.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        		EditText field = (EditText) getActivity().findViewById(R.id.search);
        		String state = field.getText().toString();
        		field.setText(state);
        		
           		//Get state information 
        		InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
       		imm.hideSoftInputFromInputMethod(field.getWindowToken(), 0);
        		listener.onStateSearch(state);
      	}
       });
        


		
//        //CREATE GO TO BOOKMARKS BUTTON
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
	
	//ADD ITEM SELECTION FUCTIONALITY TO SPINNER
//    Spinner state_names = (Spinner) getActivity().findViewById(R.id.spinner);
//	public void onItemSelected(AdapterView<?> parent, View view, 
//            int pos, long id) {
//		
//		String selected = parent.getItemAtPosition(pos).toString();
//		
//		
//		//Get state information 
//		InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
//		imm.hideSoftInputFromInputMethod(state_names.getWindowToken(), 0);
//		listener.onStateSearch(state_names);
//    }
//
//    public void onNothingSelected(AdapterView<?> parent) {
//        // Another interface callback
//    }
}


	
	


