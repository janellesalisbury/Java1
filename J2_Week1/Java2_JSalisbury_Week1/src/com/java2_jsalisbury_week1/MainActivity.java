package com.java2_jsalisbury_week1;

//Janelle Salisbury
//Java 2/Week 1
//Project1





import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;



public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
