package com.javaweek2_fragmentproject;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class SearchActivity extends ListActivity{
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		handleIntent(getIntent());
	}
	public void onNewIntent(Intent intent){
		setIntent(intent);
		handleIntent(intent);
	}
	public void onListItemClick(ListView lv, View v, int pos, long id){
		
	}
	private void handleIntent(Intent intent){
		if(Intent.ACTION_SEARCH.equals(intent.getAction())){
			String query = intent.getStringExtra(SearchManager.QUERY);
			doSearch(query);
		}
	}
	private void doSearch(String queryString){
		
	}

}
