package com.example.travel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {
    private List<Property> propertyList;
    private Context context;

    private OnRowClickListener listener;//!

    public BannerAdapter(List<Property> propertyList, Context context) {
        this.propertyList = propertyList;
        this.context = context;


    }

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_banner_item, parent, false);
        return new BannerViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {
        holder.propertyImageView.setImageResource(propertyList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return propertyList.size();
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView propertyImageView;


        public BannerViewHolder(@NonNull View itemView, OnRowClickListener onRowClickListener) {
            super(itemView);
            propertyImageView = itemView.findViewById(R.id.propertyImageView);


        }


        @Override
        public void onClick(View view) {

        }
    }

    public interface OnRowClickListener {
        void onItemClick(int position);
    }
}
