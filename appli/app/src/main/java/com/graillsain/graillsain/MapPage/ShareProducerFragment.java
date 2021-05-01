package com.graillsain.graillsain.MapPage;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.graillsain.graillsain.R;


public class ShareProducerFragment extends Fragment {

    private Bitmap producerPicture;

    public ShareProducerFragment(Bitmap producerPicture) {
        this.producerPicture = producerPicture;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.share_producer, container, false);

        Button backButton = rootView.findViewById(R.id.back_button);
        backButton.setOnClickListener( click -> {
            getActivity().onBackPressed();
        });

        ImageView capturedImage = rootView.findViewById(R.id.capturedImage);
        capturedImage.setImageBitmap(producerPicture);

        return rootView;

    }
    

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

}
