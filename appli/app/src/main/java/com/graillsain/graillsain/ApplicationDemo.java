package com.graillsain.graillsain;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import java.util.Objects;

public class ApplicationDemo extends Application {
    public static final String CHANNEL_ID = "channelGraillSain";
    private static NotificationManager notificationManager;

    private void createNotificationChannel(CharSequence name,
                                           String descriptionChannel,
                                           int importance)
    {
       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
       {
           NotificationChannel channel = new NotificationChannel(
                   CHANNEL_ID, name, importance);
           channel.setDescription(descriptionChannel);
           // update NotificationManager - cannot be changed after
           notificationManager = getSystemService(NotificationManager.class);
           Objects.requireNonNull(notificationManager).createNotificationChannel(channel);
       }
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        createNotificationChannel("channelGraillSain",
                "Channel principal GraillSain",
                NotificationManager.IMPORTANCE_DEFAULT);
    }
}
