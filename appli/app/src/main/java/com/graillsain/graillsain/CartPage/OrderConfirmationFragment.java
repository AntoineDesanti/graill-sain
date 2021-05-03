package com.graillsain.graillsain.CartPage;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.zxing.qrcode.*;
import com.graillsain.graillsain.Models.Storage;
import com.graillsain.graillsain.Producer.CodeScannerFragment;
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

        Button confirmationButton = (Button)rootView.findViewById(R.id.scanCodeButton);
        confirmationButton.setOnClickListener((v) -> {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, new CodeScannerFragment());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });


        Bitmap qrcode = QRCode.from(String.valueOf(Storage.orders.get(0).getId())).bitmap();
        ImageView qrCodeImage = (ImageView) rootView.findViewById(R.id.QRCodeView);
        qrCodeImage.setImageBitmap(qrcode);

        return rootView;
    }

}
