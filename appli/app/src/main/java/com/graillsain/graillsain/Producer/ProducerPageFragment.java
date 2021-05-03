package com.graillsain.graillsain.Producer;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import com.graillsain.graillsain.MainActivity;

import com.graillsain.graillsain.MapPage.GPSTracker;
import com.graillsain.graillsain.Models.Producer;
import com.graillsain.graillsain.Models.Product;
import com.graillsain.graillsain.ProfilPage.ProductAdapter;
import com.graillsain.graillsain.R;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;

public class ProducerPageFragment extends Fragment {
    private Producer producer;

    public ProducerPageFragment(Producer producer) {
        this.producer = producer;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.page_producer, container, false);

        ((TextView) rootView.findViewById(R.id.nom_commerce)).setText(this.producer.getName());
        ((TextView) rootView.findViewById(R.id.adresse_commerce)).setText(this.producer.getAddress());

        ListView listView = rootView.findViewById(R.id.list_view);

        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product("citron", 2));
        products.add(new Product("fraise", 4));
        products.add(new Product("orange", 1));
        products.add(new Product("framboise", 8));

        ProductAdapter productAdapter = new ProductAdapter( getContext(), products);
        listView.setAdapter(productAdapter);

        return rootView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }


}