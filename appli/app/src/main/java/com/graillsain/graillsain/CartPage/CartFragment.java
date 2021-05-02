package com.graillsain.graillsain.CartPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.graillsain.graillsain.Models.Fruit;
import com.graillsain.graillsain.Models.Order;
import com.graillsain.graillsain.Models.Product;
import com.graillsain.graillsain.Models.Storage;
import com.graillsain.graillsain.ProfilPage.OrderAdapter;
import com.graillsain.graillsain.R;

import java.util.ArrayList;
import java.util.Date;

import static com.graillsain.graillsain.Models.Consummer.Martin;

public class CartFragment extends Fragment {

    ListView productsListView;

    public CartFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.page_cart, container, false);

        ListView listView = rootView.findViewById(R.id.list_cart_consumer);

        CartAdapter cartAdapter = new CartAdapter(getContext(), Storage.cartElements);

        listView.setAdapter(cartAdapter);
        return rootView;
    }

}