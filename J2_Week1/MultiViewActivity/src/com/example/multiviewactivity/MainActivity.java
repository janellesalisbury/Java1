package com.example.multiviewactivity;

import java.net.URI;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final EditText et = (EditText) findViewById(R.id.editText1);
        
        Button b = (Button) findViewById(R.id.button1);
       
        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, SecondActivity.class);
				intent.putExtra("thetext", et.getText().toString());
				startActivity(intent);
							
			}
		});
        
       
        ImageView iv = (ImageView) findViewById(R.id.imageView1);
        if(getIntent().getExtras() != null){
        Log.i("IMAGE LOADED",getIntent().getExtras().get(Intent.EXTRA_STREAM).toString());
        iv.setImageURI((Uri) getIntent().getExtras().get(Intent.EXTRA_STREAM));
        }
        
    }
   
}

