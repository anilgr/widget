package com.dreamweave.anil_gr.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Created by anil_gr on 10-08-2017.
 */

public class WidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
       final int N = appWidgetIds.length;
        for (int i = 0;i<N ; i++){

           // int appWidgetId = appWidgetIds[i];
           // Intent intent =  new Intent(context,MainActivity.class);
           // intent.putExtra(MainActivity.WIDGET_ID,appWidgetId);
           // PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
           // RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.widget_layout);
           // views.setOnClickPendingIntent(R.id.textView,pendingIntent);
           // appWidgetManager.updateAppWidget(appWidgetId, views);

        }
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
    }

}
