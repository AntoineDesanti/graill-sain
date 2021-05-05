package com.graillsain.graillsain;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.Timer;
import java.util.TimerTask;

public class NotificationService extends Service {


    Timer timer;
    TimerTask timerTask;
    String TAG = "Timers";
    int Your_X_SECS = 5;

    private static int notificationId = 0;


    public static void sendNotificationOnChannel(String title, String content, String channelID, int priority, Context context)
    {
        NotificationCompat.Builder notification = new NotificationCompat.Builder(context,
                channelID)
                .setSmallIcon(R.drawable.icon_app)
                .setContentTitle(title)
                .setContentText(content)
                .setPriority(priority)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(content));
        NotificationManagerCompat.from(context).notify(++notificationId, notification.build());
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand");
        super.onStartCommand(intent, flags, startId);

        startTimer();

        return START_STICKY;
    }


    @Override
    public void onCreate() {
        Log.e(TAG, "onCreate");


    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy");
        stoptimertask();
        super.onDestroy();


    }

    //we are going to use a handler to be able to run in our TimerTask
    final Handler handler = new Handler();


    public void startTimer() {
        //set a new Timer
        timer = new Timer();

        //initialize the TimerTask's job
        initializeTimerTask();

        //schedule the timer, after the first 5000ms the TimerTask will run every 10000ms
        timer.schedule(timerTask, 5000, Your_X_SECS * 1000); //
        //timer.schedule(timerTask, 5000,1000); //
    }

    public void stoptimertask() {
        //stop the timer, if it's not already null
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public void initializeTimerTask() {

        timerTask = new TimerTask() {
            public void run() {

                //use a handler to run a toast that shows the current timestamp
                handler.post(new Runnable() {
                    public void run() {

                        //TODO CALL NOTIFICATION FUNC
                        sendNotificationOnChannel("hello", "hi", "main", 1);

                    }
                });
            }
        };
    }

    private void sendNotificationOnChannel(String title, String content, String channelID, int priority)
    {
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this,
                channelID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText(content)
                .setPriority(priority);
        NotificationManagerCompat.from(this).notify(0, notification.build());
    }
}