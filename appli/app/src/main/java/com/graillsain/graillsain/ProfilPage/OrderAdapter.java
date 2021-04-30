package com.graillsain.graillsain.ProfilPage;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.graillsain.graillsain.Models.Order;
import com.graillsain.graillsain.Models.Product;
import com.graillsain.graillsain.R;

import java.util.ArrayList;

public class OrderAdapter extends BaseAdapter {

    private Order order;
    private LayoutInflater mInflater;

    public OrderAdapter(Context context, Order commande){
        this.order = commande;
        this.mInflater = LayoutInflater.from(context);
    }

    public int getCount(){
        return 0;
    }


    public Object getItem(int position){
        return order;
    }

    public long getItemId(int position){
        return 0;
    }


    public View getView(int position, View convertView, ViewGroup parent){
        ConstraintLayout layoutItem = (convertView == null ? (ConstraintLayout) mInflater.inflate(R.layout.order_consumer, parent, false) : (ConstraintLayout) convertView);

        TextView tvHeurePassage = layoutItem.findViewById(R.id.heure_passage);
        TextView tvOrder = layoutItem.findViewById(R.id.order);

        //Log.d("Matthieu", "listProducts: " + order);
        //Log.d("Matthieu", "product: " + order.getProducts().get(position));
        //Log.d("Matthieu", "tvName: " + tvName);
        tvHeurePassage.setText(order.getHeurePassage() + "");
        tvOrder.setText("Panier " + order.getId());

        return layoutItem;
    }
}
