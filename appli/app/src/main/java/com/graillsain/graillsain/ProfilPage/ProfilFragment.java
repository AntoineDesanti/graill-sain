package com.graillsain.graillsain.ProfilPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import com.graillsain.graillsain.Models.Storage;
import com.graillsain.graillsain.Models.Vegetable;
import com.graillsain.graillsain.OrderDetailsPage.OrderDetails;
import com.graillsain.graillsain.R;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import static com.graillsain.graillsain.Models.Consummer.Martin;
import static java.lang.String.valueOf;


public class ProfilFragment extends Fragment {



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


        //liste de commandes
        ArrayList<Order> orders = new ArrayList<Order>();
        Date date = new Date();
        Order firstOrder = new Order(1, Storage.cartElements, date, Martin);
        orders.add(firstOrder); //pour pouvoir passer un order dans le OrderAdapter
        orders.add(new Order(2, Storage.cartElements, date, Martin));
        orders.add(new Order(3, Storage.cartElements, date, Martin));

        OrderAdapter orderAdapter = new OrderAdapter(getContext(), orders);

        listView.setAdapter(orderAdapter);

        TextView tvNameProfile = rootView.findViewById(R.id.nom_consumer);
        TextView tvStats = rootView.findViewById(R.id.info_consumer);
        TextView tvPresentation = rootView.findViewById(R.id.nom_commerce);

        tvNameProfile.setText("Bienvenue, " + orders.get(1).getConsummer().getName());
        
        /*
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
        String toPrintStats = "Pourcentage de légumes : " + valueOf(percentageVegetables)
                + "\nPourcentage de fruits : " + valueOf(percentageFruits);

         */

        tvStats.setText("Stats : In progress ..."); //TODO: stats ne fonctionnent pas à revoir


        listView.setOnItemClickListener((parent, view, position, id) -> {

            OrderDetails orderDetailsFragment = new OrderDetails(orders.get(position));

            getChildFragmentManager().beginTransaction()
                    .replace(R.id.page_profil, orderDetailsFragment, "findThisFragment")
                    .addToBackStack(null)
                    .commit();
        });
        return rootView;
    }
}
