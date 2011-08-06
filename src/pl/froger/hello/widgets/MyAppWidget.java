package pl.froger.hello.widgets;

import java.util.Random;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class MyAppWidget extends AppWidgetProvider {
	public static final String UPDATE_ON_DEMAND = "pl.froger.hello.widget.UPDATE_ON_DEMAND";
	
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		for (int i = 0; i < appWidgetIds.length; i++) {
			int appWidgetId = appWidgetIds[i];
			RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);
			String luckyNumber = "Your lucky number is: " + getLuckyNumber();
			views.setTextViewText(R.id.tvWidgetText, luckyNumber);
			appWidgetManager.updateAppWidget(appWidgetId, views);
		}
	}

	private int getLuckyNumber() {
		Random r = new Random();
		return r.nextInt(100);
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		super.onReceive(context, intent);
		if(intent.getAction().equals(UPDATE_ON_DEMAND)) {
			updateWidget(context);
		}
	}

	private void updateWidget(Context context) {
		AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
		ComponentName componentName = new ComponentName(context, MyAppWidget.class);
		int[] appWidgetIds = appWidgetManager.getAppWidgetIds(componentName);
		for (int i = 0; i < appWidgetIds.length; i++) {
			int appWidgetId = appWidgetIds[i];
			RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);
			String luckyNumber = "Lucky number on demand: " + getLuckyNumber();
			views.setTextViewText(R.id.tvWidgetText, luckyNumber);
			appWidgetManager.updateAppWidget(appWidgetId, views);
		}
	}
}