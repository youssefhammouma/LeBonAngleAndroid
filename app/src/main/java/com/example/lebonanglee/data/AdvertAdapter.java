package com.example.lebonanglee.data;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lebonanglee.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AdvertAdapter extends RecyclerView.Adapter<AdvertAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView author;
        TextView email;
        TextView price;
        TextView publishedDate;

        public ViewHolder(View view){
            super(view);
            title = view.findViewById(R.id.itm_advert_name);
            author = view.findViewById(R.id.itm_advert_author);
            email = view.findViewById(R.id.itm_advert_email);
            price = view.findViewById(R.id.itm_advert_price);
            publishedDate = view.findViewById(R.id.itm_advert_published_at);
        }
    }

    private ArrayList<Advert> adverts = new ArrayList<>();
    private Context context;

    public AdvertAdapter(ArrayList<Advert> adverts, Context context){
        this.adverts = adverts;
        this.context = context;
    }

    @NonNull
    @Override
    public AdvertAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdvertAdapter.ViewHolder holder, int position) {
        final String advert_name = adverts.get(position).getTitle();
        final String advert_author = adverts.get(position).getAuthor();
        final String advert_email = adverts.get(position).getEmail();
        final Date advert_publishedDate = adverts.get(position).getPublishedAt();
        final int advert_price = adverts.get(position).getPrice();
        final String advert_priceString = Integer.toString(advert_price);

        holder.title.setText("Titre : " + advert_name);
        holder.author.setText("Auteur : " + advert_author);
        holder.email.setText("Email : " + advert_email);
        holder.price.setText("Prix : " + advert_priceString + "$");
        holder.publishedDate.setText("Date de publication : " + advert_publishedDate);

    }

    @Override
    public int getItemCount() {
        return adverts.size();
    }
}
