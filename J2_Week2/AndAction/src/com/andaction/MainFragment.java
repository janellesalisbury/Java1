package com.andaction;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainFragment extends Fragment {
	public void onListItemClick(ListView l, View v, int position, long id) {
	    String[] actors = getResources().getStringArray(R.array.actor_names);
	    String names = actors[position];
	    Intent showNames = new Intent(getActivity().getApplicationContext(),
	            MainActivity.class);
	    showNames.setData(Uri.parse(names));
	    startActivity(showNames);
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setListAdapter(ArrayAdapter.createFromResource(getActivity()
	            .getApplicationContext(), R.array.actor_names,
	            R.layout.list_item));
	
	}
}