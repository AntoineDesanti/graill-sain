
package com.graillsain.graillsain.MapPage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import com.graillsain.graillsain.Models.Producer;
import com.graillsain.graillsain.Producer.ProducerPageFragment;
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
    private Bitmap capturedImage;

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

        ImageButton addProducerButton =  view.findViewById(R.id.add_producer_button);
        addProducerButton.setOnClickListener(click ->{

            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, 100);

        });

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

        ArrayList<ProducerOverlayItem> items = getProducersOverlay();
        ProducerOverlayItem userLocationOverlay = new ProducerOverlayItem("Vous", "", userLocation);
        Drawable currentLocationMarker = getResources().getDrawable(R.drawable.baseline_location_on_black_24dp, getContext().getTheme());
        userLocationOverlay.setMarker(currentLocationMarker);

        items.add(userLocationOverlay);
        // Drawable m = chezMichel.getMarker(0)

        ItemizedOverlayWithFocus<ProducerOverlayItem> mOverlay = new ItemizedOverlayWithFocus<>(getContext(), items, new ItemizedIconOverlay.OnItemGestureListener<ProducerOverlayItem>() {
            @Override
            public boolean onItemSingleTapUp(int index, ProducerOverlayItem item) {
                ProducerPageFragment producerPageFragment = new ProducerPageFragment(item.getProducer());

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.globalActivityView, producerPageFragment, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
                return true;
            }

            @Override
            public boolean onItemLongPress(int index, ProducerOverlayItem item) {
                return true;
            }
        });

        mOverlay.setFocusItemsOnTap(true);
        mapView.getOverlays().add(mOverlay);

        view.findViewById(R.id.center_map_button).setOnClickListener(click -> {
            mapController.setCenter(startPoint);
        });
    }

    private ArrayList<ProducerOverlayItem> getProducersOverlay(){
        ArrayList<ProducerOverlayItem> producersOverlay = new ArrayList<>();
        Producer.producers.stream().forEach(p -> {
            GeoPoint location = new GeoPoint(p.getLatitude(),p.getLongitude());
            ProducerOverlayItem overlayItem = new ProducerOverlayItem(p.getName(), p.getVerified() ? "Producteur Vérifié" : "Producteur", location,p);
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100){
            this.capturedImage = (Bitmap) data.getExtras().get("data");


            ShareProducerFragment nextFrag = new ShareProducerFragment(this.capturedImage);
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(((ViewGroup)getView().getParent()).getId(), nextFrag, "findThisFragment")
                    .addToBackStack(null)
                    .commit();
        }
    }
}