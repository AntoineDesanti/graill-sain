package com.graillsain.graillsain.Producer;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.graillsain.graillsain.Models.New;
import com.graillsain.graillsain.Models.Producer;
import com.graillsain.graillsain.Models.Product;
import com.graillsain.graillsain.NewsPage.NewsAdapter;
import com.graillsain.graillsain.ProfilPage.ProductAdapter;
import com.graillsain.graillsain.R;

import java.util.ArrayList;

public class ProducerPageFragment extends Fragment {
    private Producer producer;

    public ProducerPageFragment(Producer producer) {
        this.producer = producer;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.page_producer, container, false);

        ((TextView) rootView.findViewById(R.id.nom_commerce)).setText(this.producer.getName());
        ((TextView) rootView.findViewById(R.id.adresse_commerce)).setText(" 📍 "+this.producer.getAddress());


        ListView lvProducts = (ListView) rootView.findViewById(R.id.list_view_producer);
        ProducerPageAdapter adapter = new ProducerPageAdapter(getContext());

        lvProducts.setAdapter(adapter);
        adapter.addAll(new Product("Citrons", 2, R.drawable.citron),
                new Product("Fraises", 4, R.drawable.fraise),
                new Product("Oranges", 1, R.drawable.orange),
                new Product("Framboises", 8, R.drawable.framboise));

        return rootView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }


}