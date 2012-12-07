package com.javaweek2_fragmentproject;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter{
	private static final String urls[] ={
		"http://scifipulse.net/wp-content/uploads/2012/09/Jim-Carrey.jpg",
		"http://www.hairdressersus.com/Celebrity%20Posters/Marilyn%20Monroe/28.jpg",
		"http://www.howmuchdotheyweigh.com/wp-content/uploads/2011/05/Johnny-Depp.jpg",
		"http://images.mylot.com/userImages/images/postphotos/1562788.jpg",
		"http://pdxretro.com/wp-content/uploads/2011/10/chevy-chase-then.jpg",
		"http://upload.wikimedia.org/wikipedia/commons/9/90/Penelope_Cruz.jpg",
		"http://www.biography.com/imported/images/Biography/Images/Profiles/G/Judy-Garland-9306838-1-402.jpg",
		"http://www.usmagazine.com/uploads/assets/celebrities/80-matthew-mcconaughey/1251211734_matthew_mcconaughey_290x402.jpg",
		"http://www.thegatewaypundit.com/wp-content/uploads/2012/08/Clint-Eastwood-.jpg"
	};

	private final ImageDownloader imageDownloader = new ImageDownloader();
	
	public int getCount() {
		return urls.length;
	}

	public Object getItem(int position) {
		return urls[position];
	}

	public long getItemId(int position) {
        return urls[position].hashCode();
    }

    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = new ImageView(parent.getContext());
            view.setPadding(6, 6, 6, 6);
        }

        imageDownloader.download(urls[position], (ImageView) view);
        
        return view;
    }

    public ImageDownloader getImageDownloader() {
        return imageDownloader;
    }
}