package com.javaweek2_fragmentproject;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivityFragment extends ListFragment {
	private int  item = 0;
	private ListItemSelectedListener selectedItemListener;
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id){
		item = position;
		selectedItemListener.onListItemSelected(position);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(ArrayAdapter.createFromResource(getActivity(), R.array.actornames_array, android.R.layout.simple_list_item_1));
        if(savedInstanceState !=null){
        	item = savedInstanceState.getInt("item", 0);
        	selectedItemListener.onListItemSelected(item);
        }
	}
        
     @Override
     public void onSaveInstanceState(Bundle outState){
    	 super.onSaveInstanceState(outState);
    	 outState.putInt("item", item);
     }
      
     @Override
     public void onAttach(Activity activity){
    	 super.onAttach(activity);
    	 try{
    		 selectedItemListener = (ListItemSelectedListener) activity;
    	 }catch (ClassCastException e){
    		 throw new ClassCastException(activity.toString() + "must implement ListItemSelectedListener in Activity");
    	 }
    }
  
     public interface ListItemSelectedListener {
         public void onListItemSelected(int item);
     }
 }


