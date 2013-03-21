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

public class AppWidget extends AppWidgetProvider{
	
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		
		Timer time = new Timer();
		time.scheduleAtFixedRate(new MyTime(context, appWidgetManager), 1, 1000);
	}
	
	private class MyTime extends TimerTask {
		RemoteViews rv;
		AppWidgetManager awm;
		ComponentName myWidget;
		DateFormat df = SimpleDateFormat.getTimeInstance(SimpleDateFormat.MEDIUM, Locale.getDefault());
		
	public MyTime(Context context, AppWidgetManager appWidgetManager) {
		this.awm = appWidgetManager;
		rv = new RemoteViews(context.getPackageName(), R.layout.main);
		myWidget = new ComponentName(context, AppWidget.class);
	}
	
	@Override
	public void run() {
		rv.setTextViewText(R.id.widget_textview, "TIME = " +df.format(new Date()));
		awm.updateAppWidget(myWidget, rv);
	}
		
	} 
}


