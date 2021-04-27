package com.graillsain.graillsain.ProfilPage;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.graillsain.graillsain.Models.Product;
import com.graillsain.graillsain.R;

import java.util.ArrayList;
import java.util.Objects;

public class ProductAdapter {

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
        LinearLayout layoutItem;

        layoutItem = (LinearLayout) (convertView == null ? mInflater.inflate(R.layout.page_profil, parent, false) : null); //TODO vérifier que c'est bien null ce qu'il faut mettre en 2e option

        ImageView productPicture = layoutItem.findViewById(R.id.photo_produit);
        TextView tvName = layoutItem.findViewById(R.id.nom_produit);
        TextView tvPrice = layoutItem.findViewById(R.id.prix_produit);

        tvName.setText(listProducts.get(position).getName());
        tvPrice.setText(Float.toString((float) listProducts.get(position).getPricePerKilo()) + "0 €");
        //productPicture.setImageResource(listProducts.get(position).getPicture()); //TODO quand on ajoutera l'attribu photo à la classe Product


        return layoutItem;
    }
}
