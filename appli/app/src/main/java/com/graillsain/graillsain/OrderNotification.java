package com.graillsain.graillsain;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.graillsain.graillsain.CartPage.CartFragment;

import java.util.Objects;

public class OrderNotification extends Application {
    public static final String CHANNEL_ID = "OrderNotification";
    private static NotificationManager notificationManager;

    private void createNotificationChannel(CharSequence name,
                                           String descriptionChannel,
                                           int importance)
    {
       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
       {
           NotificationChannel channel = new NotificationChannel(
                   CHANNEL_ID, name, importance);
           channel.setShowBadge(true);
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
        createNotificationChannel("OrderNotification",
                "Notification de commande",
                NotificationManager.IMPORTANCE_MAX);
    }
}
