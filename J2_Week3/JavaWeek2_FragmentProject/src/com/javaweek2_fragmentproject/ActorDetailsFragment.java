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
			//TextView actorAge = (TextView) getView().findViewById(R.id.actorAge);
			
			String [] actornames_array = getResources().getStringArray(R.array.actornames_array);
			String [] actorage_array = getResources().getStringArray(R.array.actorage_array);
			String [] websites_array = getResources().getStringArray(R.array.websites_array);
			
			
			ImageView image = (ImageView) getView().findViewById(R.id.image);
			String [] image_locations = getResources().getStringArray(R.array.image_locations);
			String currentImage = (image_locations[item]);
			
			if(currentImage.compareTo("chevy")==0) {
				image.setImageResource(R.drawable.chevy);
				}else if(currentImage.compareTo("clint")==0){
				image.setImageResource(R.drawable.clint);
				}else if(currentImage.compareTo("jim")==0){
				image.setImageResource(R.drawable.jim);
				}else if(currentImage.compareTo("john")==0){
				image.setImageResource(R.drawable.john);
				}else if(currentImage.compareTo("johnny")==0){
				image.setImageResource(R.drawable.johnny);
				}else if(currentImage.compareTo("judy")==0){
				image.setImageResource(R.drawable.judy);
				}else if(currentImage.compareTo("marilyn")==0){
				image.setImageResource(R.drawable.marilyn);
				}else if(currentImage.compareTo("matthew")==0){
				image.setImageResource(R.drawable.matthew);
				}else if(currentImage.compareTo("penelope")==0){
				image.setImageResource(R.drawable.penelope);
				}else {
				image.setImageResource(R.drawable.missing);
				}
			
			
			actorName.setText(actornames_array[item]);
			Spanned sp = Html.fromHtml("http://www.imdb.com/name/" + websites_array[item]);
			actorName.setMovementMethod(LinkMovementMethod.getInstance());
			actorName.setText(sp);
			actorName.setText(actornames_array[item] + "\n" + actorage_array[item] + "\n" + sp);
			return;
			}
	
			
}

	