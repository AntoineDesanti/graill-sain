package com.graillsain.graillsain.ProfilPage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.graillsain.graillsain.Models.Order;
import com.graillsain.graillsain.OrderDetailsPage.OrderDetails;
import com.graillsain.graillsain.Producer.ProducerPageFragment;
import com.graillsain.graillsain.R;

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

        TextView tvSchedule = layoutItem.findViewById(R.id.heure_passage);
        TextView tvOrder = layoutItem.findViewById(R.id.order);

        //Log.d(new SimpleDateFormat()); //TODO: voir comment faire pour afficher la date correctemùent dans la ligne juste en-dessous

        tvSchedule.setText("Heure de passage : " + orders.get(position).getSchedule().getHours()
                + ":" + orders.get(position).getSchedule().getMinutes()
                + "\n Total : " + orders.get(position).getTotal() + "0€"); //pour le moment réglé sur l'heure actuelle

        String printProducts = "";
        for (int i=0; i<3; i++)
            printProducts += orders.get(position).getProducts().get(i).getProduct().getName() + ", "; // pour l'affichage des produits dans la listview
        tvOrder.setText("Panier #" + orders.get(position).getId() + "\n" + printProducts);

        return layoutItem;
    }
}
