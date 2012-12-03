package com.javaweek2_fragmentproject;


import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class ActorsFragment extends ListFragment{
	//create variables to access items and onClick handler
	private int item = 0;
	private ListItemSelectedListener itemSelected;

	//create handler for selecting an item from the list
	  @Override
	  public void onListItemClick(ListView l, View v, int position, long id) {
	    item = position;
	    itemSelected.onListItemSelected(position);
	  }

	  //create activity/listview
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		setListAdapter(ArrayAdapter.createFromResource(getActivity(), R.array.actornames_array, android.R.layout.simple_list_item_1));
		
		if(savedInstanceState !=null){
			item = savedInstanceState.getInt("item", 0);
			itemSelected.onListItemSelected(item);
			
		}
	}
	
	public void onSavedInstanceState(Bundle outState){
		super.onSaveInstanceState(outState);
		outState.putInt("item", item);
	}
	
	//attach to activity
	@Override
	public void onAttach(Activity main_activity){
		super.onAttach(main_activity);
		try{
			itemSelected = (ListItemSelectedListener) main_activity;
		}catch (ClassCastException e){
			throw new ClassCastException(main_activity.toString() + "must implement ListItemSelectedListener to Activity");
		}
	}
	public interface ListItemSelectedListener{
		public void onListItemSelected(int item);
	}
	
	public void update(int item) {
		// TODO Auto-generated method stub
		
	}
	
}


		
	


