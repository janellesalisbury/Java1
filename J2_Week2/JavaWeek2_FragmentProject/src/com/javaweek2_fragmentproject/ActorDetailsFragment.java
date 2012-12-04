package com.javaweek2_fragmentproject;

import java.io.IOException;
import java.io.InputStream;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ActorDetailsFragment extends Fragment{
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		return inflater.inflate(R.layout.image_viewer_fragment, container, false);
	}
	
	public void update(int item){
		TextView actorName = (TextView) getView().findViewById(R.id.actorName);
		ImageView image = (ImageView) getView().findViewById(R.id.image);
		
		String [] actorage_array = getResources().getStringArray(R.array.actorage_array);
		String [] image_locations = getResources().getStringArray(R.array.image_locations);
		
		actorName.setText(actorage_array[item]);
		InputStream is;
		try {
            is = getActivity().getAssets().open(image_locations[item]);
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            image.setImageBitmap(bitmap);
        } catch (IOException e) {
            Log.e("SampleViewerFragment", "Failed to decode image");
        }
    }
}

	