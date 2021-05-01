package com.graillsain.graillsain.ProfilPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.graillsain.graillsain.Models.Order;
import com.graillsain.graillsain.Models.Product;
import com.graillsain.graillsain.R;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class ProfilFragment extends Fragment {

    private ArrayList<Product> products;

    public ProfilFragment(){
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.page_profil, container, false);

        ListView listView = rootView.findViewById(R.id.list_commande_consumer);

        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product("Citron", 2));
        products.add(new Product("Fraise", 4));
        products.add(new Product("Orange", 1));
        products.add(new Product("Framboise", 8));

        ArrayList<Order> orders = new ArrayList<Order>();
        Date date = new Date();
        Order firstOrder = new Order(1, products, 5, date);
        orders.add(firstOrder); //pour pouvoir passer un order dans le OrderAdapter
        orders.add(new Order(2, products, 10, date));
        orders.add(new Order(3, products, 15, date));

        OrderAdapter orderAdapter = new OrderAdapter(getContext(), orders);

        listView.setAdapter(orderAdapter);

        TextView tvNomProfile = rootView.findViewById(R.id.nom_consumer);
        TextView tvStats = rootView.findViewById(R.id.info_consumer);
        TextView tvPresentation = rootView.findViewById(R.id.nom_commerce);

        tvNomProfile.setText("Bienvenue, " + "prémon");//TODO: inclure le profil de la personne pour pouvoir gérer dynamiquement la page profil


        return rootView;
    }
}
