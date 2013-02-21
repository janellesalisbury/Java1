package com.javaweek2_fragmentproject;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
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
		
	
	
	}
		 @Override
		  public boolean onCreateOptionsMenu(Menu menu) {
		    MenuInflater inflater = getMenuInflater();
		    inflater.inflate(R.layout.mainmenu, menu);
	        return true;
			

		  }

		

		  @Override
		  public boolean onOptionsItemSelected(MenuItem item) {
//			    boolean ret;
//			    if (item.getItemId() == R.id.menu_settings)
//			    {
//			        // Handle Settings
//			        ret = true;
//			    } 
//			    else
//			    {
//			        ret = super.onOptionsItemSelected( item );
//			    }
//			    return ret;
		  
			  //REFRESH/SETTINGS
		    switch (item.getItemId()) {
		    case R.id.action_refresh:
		      Toast.makeText(this, "Action refresh selected", Toast.LENGTH_SHORT)
		          .show();
		      break;
		    case R.id.action_settings:
		      Toast.makeText(this, "Action Settings selected", Toast.LENGTH_SHORT)
		          .show();
		      break;

		    default:
		      break;
		    }
			return true;
		  }
}
