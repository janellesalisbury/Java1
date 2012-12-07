package com.javaweek2_fragmentproject;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

public class ImageListActivity extends ListActivity implements RadioGroup.OnCheckedChangeListener{

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
	        setContentView(R.layout.image_list);

	        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
	        radioGroup.setOnCheckedChangeListener(this);
	        
	        setListAdapter(new ImageAdapter());
	    }

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		ImageDownloader.Mode mode = ImageDownloader.Mode.NO_ASYNC_TASK;
        
        if (checkedId == R.id.correctButton) {
            mode = ImageDownloader.Mode.CORRECT;
        }else if (checkedId == R.id.randomButton) {
                mode = ImageDownloader.Mode.NO_DOWNLOADED_DRAWABLE;
        }
        
        ((ImageAdapter) getListAdapter()).getImageDownloader().setMode(mode);
    }
}
	