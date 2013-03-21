/*
 * project WidgetWeek3
 * package 
 * @author Janelle Salisbury
 * date Mar 21, 2013
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import com.widgetweek3.R;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;


// TODO: Auto-generated Javadoc
/**
 * The Class ClockWidget.
 */
public class ClockWidget extends AppWidgetProvider{
	
	/* (non-Javadoc)
	 * @see android.appwidget.AppWidgetProvider#onUpdate(android.content.Context, android.appwidget.AppWidgetManager, int[])
	 */
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new MyTime(context, appWidgetManager), 1, 1000);
	}
	
	/**
	 * The Class MyTime.
	 */
	private class MyTime extends TimerTask {
		//GLOBAL VARIABLES
		RemoteViews remoteViews;
		AppWidgetManager appWidgetManager;
		ComponentName thisWidget;
		DateFormat format = SimpleDateFormat.getTimeInstance(SimpleDateFormat.MEDIUM, Locale.getDefault());
		
	/**
	 * Instantiates a new my time.
	 *
	 * @param context the context
	 * @param appWidgetManager the app widget manager
	 */
	public MyTime(Context context, AppWidgetManager appWidgetManager) {
		//CREATE THE WIDGET USING REMOTE VIEWS
		this.appWidgetManager = appWidgetManager;
		remoteViews = new RemoteViews(context.getPackageName(), R.layout.main);
		thisWidget = new ComponentName(context, ClockWidget.class);
	}
	
	/* (non-Javadoc)
	 * @see java.util.TimerTask#run()
	 */
	@Override
	public void run() {
		remoteViews.setTextViewText(R.id.widget_textview, "TIME = " +format.format(new Date()));
		appWidgetManager.updateAppWidget(thisWidget, remoteViews);
	}
		
	} 
}


