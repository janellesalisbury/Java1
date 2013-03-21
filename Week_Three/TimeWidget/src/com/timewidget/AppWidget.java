/*
 * project TimeWidget
 * package com.timewidget
 * @author Janelle Salisbury
 * date Mar 21, 2013
 */
package com.timewidget;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;

// TODO: Auto-generated Javadoc
/**
 * The Class AppWidget.
 */
public class AppWidget extends AppWidgetProvider{
	
	/* (non-Javadoc)
	 * @see android.appwidget.AppWidgetProvider#onUpdate(android.content.Context, android.appwidget.AppWidgetManager, int[])
	 */
	//UPDATE WITH THE CUTTENT TIME EVERY SECOND
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		
		Timer time = new Timer();
		time.scheduleAtFixedRate(new MyTime(context, appWidgetManager), 1, 1000);
	}
	
	/**
	 * The Class MyTime.
	 */
	
	//CREATE THE WIDGET USING REMOTE VIEWS
	private class MyTime extends TimerTask {
		RemoteViews rv;
		AppWidgetManager awm;
		ComponentName myWidget;
		DateFormat df = SimpleDateFormat.getTimeInstance(SimpleDateFormat.MEDIUM, Locale.getDefault());
		
	/**
	 * Instantiates a new my time.
	 *
	 * @param context the context
	 * @param appWidgetManager the app widget manager
	 */
	public MyTime(Context context, AppWidgetManager appWidgetManager) {
		this.awm = appWidgetManager;
		rv = new RemoteViews(context.getPackageName(), R.layout.main);
		myWidget = new ComponentName(context, AppWidget.class);
	}
	
	/* (non-Javadoc)
	 * @see java.util.TimerTask#run()
	 */
	//RUN THE WIDGET AND UPDATE IT
	@Override
	public void run() {
		rv.setTextViewText(R.id.widget_textview, "TIME = " +df.format(new Date()));
		awm.updateAppWidget(myWidget, rv);
	}
		
	} 
}


