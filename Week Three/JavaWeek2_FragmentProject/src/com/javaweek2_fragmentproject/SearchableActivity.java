package com.javaweek2_fragmentproject;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SearchableActivity extends Activity{
	@Override
    public void onCreate(Bundle savedInstanceState) {
       
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
          Log.d("Search enabled", query);
        }
    }
}
