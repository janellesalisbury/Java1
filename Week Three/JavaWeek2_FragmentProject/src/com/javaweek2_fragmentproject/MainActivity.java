package com.javaweek2_fragmentproject;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

public class MainActivity extends Activity implements MainActivityFragment.ListItemSelectedListener, OnQueryTextListener{
	 TextView mSearchText;

    
	//called when activity is first created
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Log.d("step debug","activity on create");
		setContentView(R.layout.main);
		mSearchText = new TextView(this);
        mSearchText.setPadding(10, 10, 10, 10);
        mSearchText.setText("Search");


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
			//UNUSED
			
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
		
	
	
	}
		 @Override
		  public boolean onCreateOptionsMenu(Menu menu) {
		    MenuInflater inflater = getMenuInflater();
		    inflater.inflate(R.menu.mainmenu, menu);
		    SearchManager searchManager =
		            (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		     SearchView searchView =
		             (SearchView) menu.findItem(R.id.action_search).getActionView();
		     searchView.setSearchableInfo(
		             searchManager.getSearchableInfo(getComponentName()));

	        return true;
			

		  }

		 @Override
		    public boolean onPrepareOptionsMenu(Menu menu) {
		        return super.onPrepareOptionsMenu(menu);
		    }

		  @Override
		  public boolean onOptionsItemSelected(MenuItem item) {
			  Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT).show();
		 
			return true;
		  }
		// The following callbacks are called for the SearchView.OnQueryChangeListener
		    public boolean onQueryTextChange(String newText) {
		        newText = newText.isEmpty() ? "" : "Query so far: " + newText;
		        mSearchText.setText(newText);
		        mSearchText.setTextColor(Color.GREEN);
		        return true;
		    }
		 
		    public boolean      onQueryTextSubmit      (String query) {
		        //Toast.makeText(this, "Searching for: " + query + "...", Toast.LENGTH_SHORT).show();
		        mSearchText.setText("Searching for: " + query + "...");
		        mSearchText.setTextColor(Color.RED);
		        return true;
		    }
		  
}
