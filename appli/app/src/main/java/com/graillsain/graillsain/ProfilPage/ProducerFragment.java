package com.graillsain.graillsain.ProfilPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.graillsain.graillsain.Models.Product;
import com.graillsain.graillsain.R;

import java.util.ArrayList;

public class ProducerFragment extends Fragment{

        private ArrayList<Product> products;

        public ProducerFragment(){
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.page_producer, container, false);

            ListView listView = rootView.findViewById(R.id.list_view);

            ArrayList<Product> products = new ArrayList<Product>();
            products.add(new Product("citron", 2));
            products.add(new Product("fraise", 4));
            products.add(new Product("orange", 1));
            products.add(new Product("framboise", 8));

            ProductAdapter productAdapter = new ProductAdapter( getContext(), products);

            listView.setAdapter(productAdapter);
            return rootView;
        }

}
