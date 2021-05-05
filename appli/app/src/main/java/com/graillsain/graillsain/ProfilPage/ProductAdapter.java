package com.graillsain.graillsain.ProfilPage;

import android.content.Context;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.graillsain.graillsain.Models.Product;
import com.graillsain.graillsain.R;

import java.util.ArrayList;
import java.util.Objects;

public class ProductAdapter extends BaseAdapter {

    private ArrayList<Product> listProducts;
    private LayoutInflater mInflater;

    public ProductAdapter(Context context, ArrayList<Product> products){
        this.listProducts = products;
        this.mInflater = LayoutInflater.from(context);
    }

    public int getCount(){
        return listProducts.size();
    }

    public Object getItem(int position){
        return listProducts.get(position);
    }

    public long getItemId(int position){
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent){
        ConstraintLayout layoutItem = (convertView == null ? (ConstraintLayout) mInflater.inflate(R.layout.product_layout, parent, false) : (ConstraintLayout) convertView);

        ImageView productPicture = layoutItem.findViewById(R.id.photo_produit);
        TextView tvName = layoutItem.findViewById(R.id.nom_produit);
        TextView tvPrice = layoutItem.findViewById(R.id.prix_produit);

        tvName.setText(listProducts.get(position).getName());
        tvPrice.setText(String.format("%1$,.2f", listProducts.get(position).getPricePerKilo()) + " €");
        //productPicture.setImageResource(listProducts.get(position).getPicture()); //TODO quand on ajoutera l'attribu photo à la classe Product

        return layoutItem;
    }
}