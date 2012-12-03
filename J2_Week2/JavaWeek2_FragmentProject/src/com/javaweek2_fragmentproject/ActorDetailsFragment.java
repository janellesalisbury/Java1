package com.javaweek2_fragmentproject;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ActorDetailsFragment extends Fragment{
	public View onCreate(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		return inflater.inflate(R.layout.activity_main, container, false);
		
	}
	public void update(int item){
		TextView name = (TextView) getView().findViewById(R.id.actors);
		TextView age = (TextView) getView().findViewById(R.id.details);
		
		String[] actor_names = getResources().getStringArray(R.array.actornames_array);
		String[] actor_age = getResources().getStringArray(R.array.actorage_array);
		
		name.setText(actor_names[item]);
		age.setText(actor_age[item]);
	}

}
