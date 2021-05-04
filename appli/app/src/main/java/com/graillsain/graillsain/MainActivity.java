package com.graillsain.graillsain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceManager;

import android.Manifest;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.graillsain.graillsain.CartPage.CartFragment;
import com.graillsain.graillsain.CartPage.OrderConfirmationFragment;
import com.graillsain.graillsain.MapPage.MapFragment;
import com.graillsain.graillsain.Models.Producer;
import com.graillsain.graillsain.NewsPage.NewsFragment;
import com.graillsain.graillsain.ProfilPage.ProfilFragment;
import com.graillsain.graillsain.SearchPage.SearchFragment;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int notificationId = 0;
    private List<Producer> producers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        producers = Producer.producers;

        setContentView(R.layout.activity_main);

        final Fragment mapPageFragment = new MapFragment();
        final Fragment profilPageFragment = new ProfilFragment();
        final Fragment cartPageFragment = new CartFragment();
        final Fragment searchPageFragment = new SearchFragment();
        final Fragment newsPageFragment = new NewsFragment();

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                            Manifest.permission.CAMERA
                    },
                    100);
        }


        BottomNavigationView bottomNav = findViewById(R.id.navigationView);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, mapPageFragment)
                .commit();


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

    public void sendNotificationOnChannel(String title, String content, String channelID, int priority)
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