package com.graillsain.graillsain.MapPage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.Camera;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.fragment.app.Fragment;
import com.graillsain.graillsain.R;


public class CameraFragment extends Fragment {

    private Bitmap producerPicture;

    public CameraFragment(Bitmap producerPicture) {
        this.producerPicture = producerPicture;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.camera, container, false);

        ImageView capturedImage = rootView.findViewById(R.id.capturedImage);
        capturedImage.setImageBitmap(producerPicture);

        return rootView;

    }
    

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

}
