package com.graillsain.graillsain.CartPage;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.zxing.qrcode.*;
import com.graillsain.graillsain.Models.Storage;
import com.graillsain.graillsain.R;

import net.glxn.qrgen.android.QRCode;

import java.util.UUID;

public class OrderConfirmationFragment extends Fragment {

    public OrderConfirmationFragment(){
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.page_order_confirmation, container, false);

        Bitmap qrcode = QRCode.from(UUID.randomUUID().toString()).bitmap();
        ImageView qrCodeImage = (ImageView) rootView.findViewById(R.id.QRCodeView);
        qrCodeImage.setImageBitmap(qrcode);

        return rootView;
    }

}
