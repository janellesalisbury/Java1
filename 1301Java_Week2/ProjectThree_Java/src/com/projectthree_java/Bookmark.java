package com.projectthree_java;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public class Bookmark extends Activity{
	
	Context _context;
	ArrayList<String> _state = new ArrayList<String>();
	String _choice;


	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bookmark_frag);
	}


	}


