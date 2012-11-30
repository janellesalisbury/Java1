package com.andaction;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WebViewFragment extends Fragment{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View viewer = (View)inflater.inflate(R.layout.web, container, false);
		return viewer;
		
		
		
	}

	public void updateStuffHere(String newURL){
		
		}
	}

