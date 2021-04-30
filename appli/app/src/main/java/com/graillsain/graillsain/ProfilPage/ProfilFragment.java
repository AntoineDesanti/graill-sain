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

import java.util.ArrayList;

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
        products.add(new Product("citron", 2));
        products.add(new Product("fraise", 4));
        products.add(new Product("orange", 1));
        products.add(new Product("framboise", 8));

        ArrayList<Order> orders = new ArrayList<Order>();
        Order firstOrder = new Order(1, products, 5, null);
        orders.add(firstOrder); //pour pouvoir passer un order dans le OrderAdapter
        orders.add(new Order(2, products, 10, null));
        orders.add(new Order(3, products, 15, null));

        OrderAdapter orderAdapter = new OrderAdapter(getContext(), orders);

        listView.setAdapter(orderAdapter);

        TextView tvNomProfile = rootView.findViewById(R.id.nom_consumer);
        TextView tvStats = rootView.findViewById(R.id.info_consumer);
        TextView tvPresentation = rootView.findViewById(R.id.nom_commerce);

        tvNomProfile.setText("Bienvenue, " + "prémon");//TODO: inclure le profil de la personne pour pouvoir gérer dynamiquement la page profil


        return rootView;
    }
}
