package com.javaweek2_fragmentproject;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
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

			String [] actornames_array = getResources().getStringArray(R.array.actornames_array);
			String [] actorage_array = getResources().getStringArray(R.array.actorage_array);
			String [] websites_array = getResources().getStringArray(R.array.websites_array);
			//String [] image_locations = getResources().getStringArray(R.array.actorImage_array);

			Spanned sp = Html.fromHtml("http://www.imdb.com/name/" + websites_array[item]);
			actorName.setMovementMethod(LinkMovementMethod.getInstance());
			actorName.setText(sp);
			actorName.setText(actornames_array[item] + "\n" + actorage_array[item] + "\n" + sp);
			image.findViewById(R.array.actorImage_array);
			
			
			return;
				
		
		
	}	
}

	