package com.lightscameraaction;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //STORING STRING RESOURCES INTO ARRAY
        String [] actor_names = getResources().getStringArray(R.array.actor_names);
        //BINDING TO LISTADAPTER
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.label, actor_names));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
