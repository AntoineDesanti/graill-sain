package com.graillsain.graillsain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.NotificationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;
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

        BottomNavigationView bottomNav = findViewById(R.id.navigationView);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.menu_map_button:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, mapPageFragment).commit();
                        return true;

                    case R.id.menu_profil_button:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, profilPageFragment).commit();
                        return true;

                    case R.id.menu_cart_button:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, cartPageFragment).commit();
                        return true;

                    case R.id.menu_search_button:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, searchPageFragment).commit();
                        return true;

                    case R.id.menu_news_button:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, newsPageFragment).commit();
                        return true;

                }

                return false;
            }
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