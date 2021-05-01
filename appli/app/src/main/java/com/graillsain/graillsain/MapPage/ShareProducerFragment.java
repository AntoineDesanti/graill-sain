package com.graillsain.graillsain.MapPage;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.graillsain.graillsain.Models.Producer;
import com.graillsain.graillsain.R;

import org.osmdroid.util.GeoPoint;


public class ShareProducerFragment extends Fragment {

    private Bitmap producerPicture;
    private GeoPoint currentLocation;

    public ShareProducerFragment(Bitmap producerPicture, GeoPoint userLocation) {
        this.producerPicture = producerPicture;
        currentLocation = userLocation;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.share_producer, container, false);

        Button backButton = rootView.findViewById(R.id.back_button);
        backButton.setOnClickListener( click -> {
            getActivity().onBackPressed();
        });

        ((TextView) rootView.findViewById(R.id.inputLocation)).setText(""+currentLocation.getLatitude()+" - "+currentLocation.getLongitude()+" 📍");

        ImageView capturedImage = rootView.findViewById(R.id.capturedImage);
        capturedImage.setImageBitmap(producerPicture);

        return rootView;

    }
    

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((Button) view.findViewById(R.id.submit_button)).setOnClickListener(click -> {
            submitSharingForm();
        });
    }

    public void submitSharingForm(){
        Producer.producers.add(
                new Producer("Mon nouveau producteur", "333 Av ADAzf", currentLocation.getLatitude(),
                currentLocation.getLongitude(),false));
        getActivity().onBackPressed();
    }

}
