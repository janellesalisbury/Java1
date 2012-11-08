package com.projectthree_java;


import com.salisbury.libs.SearchForm;
import com.salisbury.libs.StateDisplays;
import com.salisbury.libs.WebStuff;

import android.view.View.OnClickListener;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;



public class MainActivity extends Activity {
	
	Context _context;
	LinearLayout _appLayout;
	SearchForm _search;
	StateDisplays _state;
	Boolean connected = false;
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        _context = this;
        _appLayout = new LinearLayout(this);
        
        //ADD SEARCH FORM
        _search = new SearchForm(_context);
        
        //ADD CLICK EVENT HANDLER
        Button searchButton = _search.getButton();
        
        searchButton.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        		//Get state information 
        		getInfo(_search.getSelectedItem().toString());
        	}
        });
        
        //DETECT NETWORK CONNECTIVITY
        connected = WebStuff.getConnectionStatus(_context);
        if(connected){
        	Log.i("NETWORK CONNECTION", WebStuff.getConnectionType(_context));
        }
        
        //ADD STATE DISPLAY
        _state = new StateDisplays(_context);
        
        
        
         //ADD VIEWS
        _appLayout.addView(_search);
        _appLayout.addView(_state);        
        _appLayout.setOrientation(LinearLayout.VERTICAL);
        
        setContentView(_appLayout);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    private void getInfo(String state){
    	Log.i("CLICK", state);
    }
}
