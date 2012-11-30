package com.andaction;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainFragment extends Fragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	   // setListAdapter(ArrayAdapter.createFromResource(getActivity()
	        //    .getApplicationContext(), R.array.actor_names,
	           // R.layout.list_item));
	
	}
	

	public interface onNameSelectedListener{
		public void onNameSelected(Uri uri);
	}

	public void onListItemClick(ListView l, View v, int position, long id) {
	    String[] actors = getResources().getStringArray(R.array.actor_names);
	    String names = actors[position];
	    //onNameSelectedListener.onNameSelected(Uri.parse(names));
	}
	
	
}