package com.dreamweave.anil_gr.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView i;
    private EditText mEditText;
    private Button okButton;
    public static String WIDGET_ID = "com.dreamweaver.anil_gr.widget";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText  = (EditText) findViewById(R.id.editText);
        okButton = (Button) findViewById(R.id.button);
        //ComponentName name  = new ComponentName(getApplicationContext(),WidgetProvider.class);
        final AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(getApplicationContext());
        //final int[] appWidgetIds = appWidgetManager.getAppWidgetIds(name);
        final Intent intent = getIntent();



        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updateWidget(intent,appWidgetManager);
                finish();
            }
        });
}

private void updateWidget(Intent intent, AppWidgetManager appWidgetManager){
    Bundle extras = intent.getExtras();
    int mAppWidgetId;
    int id2;
    int id ;
    PendingIntent pendingIntent;
    RemoteViews views = new RemoteViews(getPackageName(),R.layout.widget_layout);
    views.setTextViewText(R.id.textView,mEditText.getText());
    Intent intent1 =  new Intent(getApplicationContext(),MainActivity.class);

    if (extras != null && (id=extras.getInt(
            AppWidgetManager.EXTRA_APPWIDGET_ID,
            AppWidgetManager.INVALID_APPWIDGET_ID)) != AppWidgetManager.INVALID_APPWIDGET_ID) {

        mAppWidgetId = id;
        intent1.putExtra(MainActivity.WIDGET_ID,id);

        pendingIntent = PendingIntent.getActivity(getApplicationContext(), mAppWidgetId, intent1, 0);
        views.setOnClickPendingIntent(R.id.textView,pendingIntent);
        appWidgetManager.updateAppWidget(mAppWidgetId,views);
        Intent resultValue = new Intent();
        resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
        setResult(RESULT_OK, resultValue);
        Log.d("ERROR", "updateWidget:id id " + id);
    }
    else if(( id2 = extras.getInt(WIDGET_ID,0))!=0){

        mAppWidgetId = id2;
        //intent1.putExtra(MainActivity.WIDGET_ID,id2);
        //pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent1, 0);
        //views.setOnClickPendingIntent(R.id.textView,pendingIntent);
        appWidgetManager.updateAppWidget(mAppWidgetId,views);
        Log.d("ERROR", "updateWidget:id id2 " + id2 );
    }
    else{
        mAppWidgetId = 20;
        Log.d("ERROR", "updateWidget:id 20 ");
    }




        //Intent resultValue = new Intent();
        // resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds[i]);
        //setResult(RESULT_OK, resultValue);
        //finish();



}
}
