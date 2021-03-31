package com.graillsain.graillsain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private int notificationId = 0;

    private void sendNotificationOnChannel(String title, String content,
                                           String channelID, int priority)
    {
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this,
                channelID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText("id="+ ++notificationId + " - " + content)
                .setPriority(priority);
        NotificationManagerCompat.from(this).notify(notificationId, notification.build());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonNotify).setOnClickListener(click ->
        {
            Log.d("Notification", "Notification sent");
            String title = ((EditText) findViewById(R.id.edit_text_title)).getText().toString();
            String message = ((EditText) findViewById(R.id.edit_text_message)).getText().toString();
            sendNotificationOnChannel(title, message, ApplicationDemo.CHANNEL_ID,
                    NotificationCompat.PRIORITY_HIGH);
        });
    }
}