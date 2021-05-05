package com.graillsain.graillsain.NewsPage;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.graillsain.graillsain.Models.New;
import com.graillsain.graillsain.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;


public class NewsAdapter extends ArrayAdapter<New> {
    public NewsAdapter(Context context) {
        super(context, R.layout.card_item_news);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.card_item_news, parent, false);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        New model = getItem(position);

        holder.imageView.setImageResource(model.getImageId());
        holder.tvTitle.setText(model.getTitle());
        holder.tvSubtitle.setText(model.getDescription());

        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView tvTitle;
        TextView tvSubtitle;

        ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.new_image);
            tvTitle = (TextView) view.findViewById(R.id.new_text_title);
            tvSubtitle = (TextView) view.findViewById(R.id.new_text_description);
        }
    }
}