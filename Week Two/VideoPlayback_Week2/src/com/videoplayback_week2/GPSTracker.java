package com.videoplayback_week2;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public class GPSTracker extends Service implements LocationListener{
	//GLOBAL VARIABLE
	private final Context mContext;
	boolean isGPSEnabled = false;
	boolean isNetworkEnabled = false;
	boolean canGetLocation = false;
	Location location;
	double lat;
	double longitude;
	
	//MIN DISTANCE FOR CHANGE
	private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;
	
	//MIN TIME
	private static final long MIN_TIME_BETWEEN_UPDATES = 1000*60*1;
	
	protected LocationManager locationManager;
	
	public GPSTracker(Context context){
		this.mContext = context;
		getLocation();
	}
	
	public Location getLocation(){
		try{
			locationManager = (LocationManager) mContext.getSystemService(LOCATION_SERVICE);
			//GPS STATUS
			isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
			//NETWORK STATUS
			isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
			if(!isGPSEnabled && !isNetworkEnabled){
			}else{
				this.canGetLocation = true;
				//NETWORK PROVIDER
				if(isNetworkEnabled){
					locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
							MIN_TIME_BETWEEN_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
					Log.d("Network", "Network");
					if(locationManager !=null){
						location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
						if(location !=null){
							lat = location.getLatitude();
							longitude = location.getLongitude();
						}
						
					}
				}
				//USE GPS TO OBTAIN LOCATION
				if(isGPSEnabled){
					if(location == null){
						locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
								MIN_TIME_BETWEEN_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
						Log.d("GPS Enabled", "GPS Enabled");
						if(locationManager !=null){
							location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
							if(location !=null){
								lat = location.getLatitude();
								longitude = location.getLongitude();
							}
						}
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return location;
	}
		
	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
