package com.graillsain.graillsain.ProfilPage;

import android.annotation.SuppressLint;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class OrderAdapter extends BaseAdapter {

    private ArrayList<Order> orders;
    private LayoutInflater mInflater;

    public OrderAdapter(Context context, ArrayList<Order> orders){
        this.orders = orders;
        this.mInflater = LayoutInflater.from(context);
    }

    public int getCount(){
        return orders.size();
    }


    public Object getItem(int position){
        return orders;
    }

    public long getItemId(int position){
        return position;
    }


    @SuppressLint("SetTextI18n")
    public View getView(int position, View convertView, ViewGroup parent){
        ConstraintLayout layoutItem = (convertView == null ? (ConstraintLayout) mInflater.inflate(R.layout.order_consumer, parent, false) : (ConstraintLayout) convertView);

        TextView tvHeurePassage = layoutItem.findViewById(R.id.heure_passage);
        TextView tvOrder = layoutItem.findViewById(R.id.order);

        //Log.d(new SimpleDateFormat()); //TODO: voir comment faire pour afficher la date correctemùent dans la ligne juste en-dessous

        tvHeurePassage.setText("Heure de passage : " + orders.get(position).getHeurePassage().getHours()
                + ":" + orders.get(position).getHeurePassage().getMinutes()
                + "\n Total : " + orders.get(position).getTotal() + "0€"); //pour le moment réglé sur l'heure actuelle


        tvOrder.setText("Panier #" + orders.get(position).getId());

        return layoutItem;
    }
}
