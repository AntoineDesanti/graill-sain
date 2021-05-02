package com.graillsain.graillsain.CartPage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.graillsain.graillsain.Models.Product;

import java.util.ArrayList;

public class CartAdapter extends BaseAdapter {

    private ArrayList<Product> products;
    private LayoutInflater mInflater;

    public CartAdapter(Context context, ArrayList<Product> products){
        this.mInflater = LayoutInflater.from(context);
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
