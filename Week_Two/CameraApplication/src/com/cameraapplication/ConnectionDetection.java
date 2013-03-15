/*
 * project CameraApplication
 * package com.cameraapplication
 * @author Janelle Salisbury
 * date Mar 14, 2013
 */
package com.cameraapplication;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

// TODO: Auto-generated Javadoc
/**
 * The Class ConnectionDetection.
 */
public class ConnectionDetection {
	
	//GLOBAL VARIABLES
	private Context _context;
	
	/**
	 * Instantiates a new connection detection.
	 *
	 * @param context the context
	 */
	public ConnectionDetection(Context context){
		this._context = context;
		
	}
	
	/**
	 * Checks if is connecting to internet.
	 *
	 * @return true, if is connecting to internet
	 */
	public boolean isConnectingToInternet(){
        ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
          if (connectivity != null)
          {
              NetworkInfo[] info = connectivity.getAllNetworkInfo();
              if (info != null)
                  for (int i = 0; i < info.length; i++)
                      if (info[i].getState() == NetworkInfo.State.CONNECTED)
                      {
                          return true;
                      }
 
          }
          return false;
    }
}