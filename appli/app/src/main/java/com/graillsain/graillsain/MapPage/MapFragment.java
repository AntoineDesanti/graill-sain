package com.graillsain.graillsain.MapPage;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import com.graillsain.graillsain.Models.Location;
import com.graillsain.graillsain.Models.Producer;
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

public class MapFragment extends Fragment {
    private MapView mapView;
    private GPSTracker gpsTracker;
    private GeoPoint userLocation;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.page_map, container, false);
        return rootView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gpsTracker = new GPSTracker(this.getContext());

        Configuration.getInstance().load(view.getContext(), PreferenceManager.getDefaultSharedPreferences(view.getContext()));
        mapView = view.findViewById(R.id.osm_map);
        mapView.setTileSource(TileSourceFactory.MAPNIK); //render map
        mapView.setBuiltInZoomControls(true); //map zoomable

        if(gpsTracker.canGetLocation()){
            Double latitude =  gpsTracker.getLatitude(); // returns latitude
            Double longitude = gpsTracker.getLongitude();
            userLocation = new GeoPoint(latitude, longitude);
        }
        GeoPoint startPoint;

        if(userLocation != null) startPoint = userLocation;
        else startPoint = new GeoPoint(43.57197, 7.11657);

        IMapController mapController;
        mapController = mapView.getController();
        mapController.setZoom(18.0);
        mapController.setCenter(startPoint);

        ArrayList<OverlayItem> items = getProducersOverlay();
        OverlayItem userLocationOverlay = new OverlayItem("Vous", "",userLocation);
        Drawable currentLocationMarker = getResources().getDrawable(R.drawable.baseline_location_on_black_24dp, getContext().getTheme());
        userLocationOverlay.setMarker(currentLocationMarker);

        items.add(userLocationOverlay);
       // Drawable m = chezMichel.getMarker(0)

        ItemizedOverlayWithFocus<OverlayItem> mOverlay = new ItemizedOverlayWithFocus<OverlayItem>(getContext(), items, new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return true;
            }

            @Override
            public boolean onItemLongPress(int index, OverlayItem item) {
                return false;
            }
        });

        mOverlay.setFocusItemsOnTap(true);
        mapView.getOverlays().add(mOverlay);

        view.findViewById(R.id.center_map_button).setOnClickListener(click -> {
            mapController.setCenter(startPoint);
        });
    }

    private ArrayList<OverlayItem> getProducersOverlay(){
        ArrayList<OverlayItem> producersOverlay = new ArrayList<>();
        Producer.producers.stream().forEach(p -> {
            GeoPoint location = new GeoPoint(p.getLatitude(),p.getLongitude());
            OverlayItem overlayItem = new OverlayItem(p.getName(), p.getVerified() ? "Producteur Vérifié" : "Producteur", location);
           // Drawable ProducerMarker = getResources().getDrawable(R.drawable.baseline_shopping_basket_teal_400_24dp, getContext().getTheme());
            //overlayItem.setMarker(ProducerMarker);
            producersOverlay.add(overlayItem);
        });


        return producersOverlay;
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }
}