package com.graillsain.graillsain.CartPage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.graillsain.graillsain.Models.CartElement;
import com.graillsain.graillsain.Models.Product;
import com.graillsain.graillsain.Models.Storage;
import com.graillsain.graillsain.R;

import java.util.ArrayList;

public class CartAdapter extends BaseAdapter {

    private ArrayList<CartElement> products;
    private LayoutInflater mInflater;

    public CartAdapter(Context context, ArrayList<CartElement> products){
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
        ConstraintLayout layoutItem = (convertView == null ? (ConstraintLayout) mInflater.inflate(R.layout.cart_consumer, parent, false) : (ConstraintLayout) convertView);
        TextView tvCartElement = layoutItem.findViewById(R.id.cart_element_text);

            tvCartElement.setText((int)products.get(position).getQuantity()
                    + "x "
                    + products.get(position).getProduct().getName()
                    + " (" + products.get(position).getWeight() + "g )"
                    + "\t\t"
                    + products.get(position).getWeight()*products.get(position).getProduct().getPricePerKilo()
                    + "€"
            );

        return layoutItem;
    }
}
