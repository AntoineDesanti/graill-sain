package com.graillsain.graillsain.CartPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.graillsain.graillsain.Models.Fruit;
import com.graillsain.graillsain.Models.Order;
import com.graillsain.graillsain.Models.Product;
import com.graillsain.graillsain.Models.Storage;
import com.graillsain.graillsain.ProfilPage.OrderAdapter;
import com.graillsain.graillsain.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.graillsain.graillsain.Models.Consummer.Martin;
import static com.graillsain.graillsain.Models.Storage.date;

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

        Button confirmationButton = (Button)rootView.findViewById(R.id.confirmationButton);
        confirmationButton.setOnClickListener((v) -> {
            Storage.orders.add(new Order((int) ((Math.random() * (9999-1000)) + 1000), Storage.cartElements, date, Martin));
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, new OrderConfirmationFragment());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        ListView listView = rootView.findViewById(R.id.list_cart_consumer);

        CartAdapter cartAdapter = new CartAdapter(getContext(), Storage.cartElements);

        listView.setAdapter(cartAdapter);

        Spinner sp = rootView.findViewById(R.id.availableSlots);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.support_simple_spinner_dropdown_item, Storage.availableSlotsForTakingOrder);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        return rootView;
    }


}