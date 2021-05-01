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

import com.graillsain.graillsain.Models.Fruit;
import com.graillsain.graillsain.Models.Order;
import com.graillsain.graillsain.Models.Product;
import com.graillsain.graillsain.Models.Vegetable;
import com.graillsain.graillsain.R;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import static com.graillsain.graillsain.Models.Consummer.Martin;
import static java.lang.String.valueOf;

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

        //liste de produits
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Fruit("Citron", 2));
        products.add(new Fruit("Fraise", 4));
        products.add(new Fruit("Orange", 1));
        products.add(new Fruit("Framboise", 8));

        //liste de commandes
        ArrayList<Order> orders = new ArrayList<Order>();
        Date date = new Date();
        Order firstOrder = new Order(1, products, 5, date, Martin);
        orders.add(firstOrder); //pour pouvoir passer un order dans le OrderAdapter
        orders.add(new Order(2, products, 10, date, Martin));
        orders.add(new Order(3, products, 15, date, Martin));

        OrderAdapter orderAdapter = new OrderAdapter(getContext(), orders);

        listView.setAdapter(orderAdapter);

        TextView tvNomProfile = rootView.findViewById(R.id.nom_consumer);
        TextView tvStats = rootView.findViewById(R.id.info_consumer);
        TextView tvPresentation = rootView.findViewById(R.id.nom_commerce);

        tvNomProfile.setText("Bienvenue, " + orders.get(1).getConsummer().getName());


        int vegetables = 0, fruits = 0;
        int sizeTotal = 0;

        for ( Order order : orders ) {
            for (int i=0; i<order.getProducts().size(); i++){
                if (order.getProducts().get(i) instanceof Fruit)
                    fruits++;
                else
                    vegetables++;
            }
            sizeTotal += order.getProducts().size();
        }

        double percentageFruits = fruits/sizeTotal;
        double percentageVegetables = vegetables/sizeTotal;

        tvStats.setText("Pourcentage de légumes : " + valueOf(percentageVegetables)
                + "\nPourcentage de fruits : " + valueOf(percentageFruits)); //TODO: stats ne fonctionnent pas à revoir


        return rootView;
    }
}
