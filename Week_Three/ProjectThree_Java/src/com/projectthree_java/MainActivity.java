package com.projectthree_java;

import com.salisbury.libs.SearchForm;

import android.view.View.OnClickListener;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	
	Context _context;
	LinearLayout _appLayout;
	SearchForm _search;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        _context = this;
        _appLayout = new LinearLayout(this);
        
        _search = new SearchForm(_context, "Enter State", "Search Now");
        
        //ADD SEARCH HANDLER
        EditText searchField = _search.getField();
        Button searchButton = _search.getButton();
        
        searchButton.setOnClickListener(new OnClickListener(){
        	
        	public void onClick(View v){
        		//GET STATE INFORMATION
        		Log.i("Click Handler", _search.getField().getText().toString());
        	}
        });
        
        _appLayout.addView(_search);
        setContentView(_appLayout);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
