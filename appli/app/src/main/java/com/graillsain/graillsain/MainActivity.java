package com.graillsain.graillsain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.NotificationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.graillsain.graillsain.CartPage.CartFragment;
import com.graillsain.graillsain.MapPage.MapFragment;
import com.graillsain.graillsain.NewsPage.NewsFragment;
import com.graillsain.graillsain.ProfilPage.ProfilFragment;
import com.graillsain.graillsain.SearchPage.SearchFragment;

public class MainActivity extends AppCompatActivity {

    private int notificationId = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Fragment mapPageFragment = new MapFragment();
        final Fragment profilPageFragment = new ProfilFragment();
        final Fragment cartPageFragment = new CartFragment();
        final Fragment searchPageFragment = new SearchFragment();
        final Fragment newsPageFragment = new NewsFragment();




        findViewById(R.id.menu_map_button).setOnClickListener(click -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, mapPageFragment).commit();
           //  return@OnNavigationItemSelectedListener true
        });
        findViewById(R.id.menu_profil_button).setOnClickListener(click -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, profilPageFragment).commit();
        });
        findViewById(R.id.menu_cart_button).setOnClickListener(click -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, cartPageFragment).commit();
        });

        findViewById(R.id.menu_search_button).setOnClickListener(click -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, searchPageFragment).commit();
        });
        findViewById(R.id.menu_news_button).setOnClickListener(click -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, newsPageFragment).commit();
        });





    }

    private void sendNotificationOnChannel(String title, String content, String channelID, int priority)
    {
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this,
                channelID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText("id="+ ++notificationId + " - " + content)
                .setPriority(priority);
        NotificationManagerCompat.from(this).notify(notificationId, notification.build());
    }

}