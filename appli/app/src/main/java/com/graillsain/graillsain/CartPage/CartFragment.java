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


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.page_cart, container, false);

        ListView listView = rootView.findViewById(R.id.list_cart_consumer);

        //liste de produits
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Fruit("Citron", 2));
        products.add(new Fruit("Fraise", 4));
        products.add(new Fruit("Orange", 1));
        products.add(new Fruit("Framboise", 8));

        //liste de commandes
        ArrayList<Order> orders = new ArrayList<Order>();
        Date date = new Date();
        Order firstOrder = new Order(1, Storage.cartElements, date, Martin);
        orders.add(firstOrder); //pour pouvoir passer un order dans le OrderAdapter
        orders.add(new Order(2, Storage.cartElements, date, Martin));
        orders.add(new Order(3, Storage.cartElements, date, Martin));

        OrderAdapter orderAdapter = new OrderAdapter(getContext(), orders);

        listView.setAdapter(orderAdapter);
        return rootView;
    }

}