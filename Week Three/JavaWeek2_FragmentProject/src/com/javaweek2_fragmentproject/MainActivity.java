package com.javaweek2_fragmentproject;

import java.io.File;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import android.os.Bundle;
import android.util.Log;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;

public class MainActivity extends Activity implements MainActivityFragment.ListItemSelectedListener{
	//called when activity is first created
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Log.d("step debug","activity on create");
		setContentView(R.layout.main);
		
		//SET UP ACTION BAR FOR TABS
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowTitleEnabled(true);
		
		Tab tab = actionBar
				.newTab()
				.setText("Actors")
				.setTabListener(new MyTabListener<MainActivityFragment>(this, "actor", MainActivityFragment.class));
			actionBar.addTab(tab);
			
			tab = actionBar
					.newTab()
					.setText("Details")
					.setTabListener(new MyTabListener<ActorDetailsFragment>
					(this, "details", ActorDetailsFragment.class));
			actionBar.addTab(tab);
		
	
	}
	public static class MyTabListener<T extends Fragment> implements TabListener{
		private Fragment mFragment;
		private final Activity mActivity;
		private final String mTag;
		private final Class<T> mClass;
		
		//CONSTRUCTOR
		public MyTabListener(Activity activity, String tag, Class<T> cls){
			mActivity = activity;
			mTag = tag;
			mClass = cls;
		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			if(mFragment == null){
				//INSTANTIATE
				mFragment = Fragment.instantiate(mActivity, mClass.getName());
				ft.add(android.R.id.content, mFragment, mTag);
			}else{
				ft.attach(mFragment);
			}
			
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			if (mFragment != null) {
		        ft.detach(mFragment);
			
		}
	}
}
		@Override
		public void onListItemSelected(int item){
			ActorDetailsFragment imageViewer = (ActorDetailsFragment) getFragmentManager().findFragmentById(R.id.image_viewer_fragment);
			
			if(imageViewer == null || !imageViewer.isInLayout()){
				Intent showImage = new Intent(getApplicationContext(), ActorDetailsView.class);
				showImage.putExtra("item", item);
				startActivity(showImage);
			} else {
				imageViewer.update(item);
			}
		
	
	//CREATE PERSON OBJECT 
	Actor actor1 = new Actor("Jim", "Carrey");
	
	//CREATE A FILE TO SAVE USING PATH PROVIDED THROUGH GETFILESFIRECORY().GETPATH();
	File xmlFile = new File(getFilesDir().getPath() + "/actors_array.xml");
	
	//SERIALIZE ACTOR
	try{
		Serializer serializer = new Persister();
		serializer.write(actor1, xmlFile);
	}
	catch(Exception ex){
		ex.printStackTrace();
	}
	//CREATE A SECOND PERSON
	Actor actor2 = new Actor("Penelope", "Cruz");
	
	//SERIALIZE
	try{
		Serializer serializer = new Persister();
		serializer.write(actor2, xmlFile);
	}
	catch(Exception exc){
		exc.printStackTrace();
	}
	//FINISH CREATING LIST OF ACTORS
	Actor actor3 = new Actor("Chevy", "Chase");
	Actor actor4 = new Actor("Marilyn", "Monroe");
	Actor actor5 = new Actor("Judy", "Garland");
	Actor actor6 = new Actor("John", "Wayne");
	Actor actor7 = new Actor("Johnny", "Depp");
	Actor actor8 = new Actor("Matthew", "McConaughey");
	Actor actor9 = new Actor("Clint", "Eastwood");
	
	//SERIALIZE REMAINING ACTORS
	try{
		Serializer serializer = new Persister();
		serializer.write(actor3, xmlFile);
		serializer.write(actor4, xmlFile);
		serializer.write(actor5, xmlFile);
		serializer.write(actor6, xmlFile);
		serializer.write(actor7, xmlFile);
		serializer.write(actor8, xmlFile);
		serializer.write(actor9, xmlFile);
	}
	catch(Exception e){
		e.printStackTrace();
		
	}
	//DESERIALIZE ACTORS
	if(xmlFile.exists()){
		try{
			Serializer serializer = new Persister();
			serializer.read(Actor.class, xmlFile);
		}
		catch(Exception boo){
			boo.printStackTrace();
			
		}
	}
	
	boolean b = actor1.equals(actor1);
	
	
	
	
	}
		
}


	
 
 

