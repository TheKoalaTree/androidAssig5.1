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

public class PropertyAdapter extends RecyclerView.Adapter<PropertyAdapter.PropertyViewHolder> {
    private List<Property> propertyList;
    private Context context;

    private OnRowClickListener listener;//!

    public PropertyAdapter(List<Property> propertyList, Context context, OnRowClickListener clickListener) {
        this.propertyList = propertyList;
        this.context = context;

        this.listener = clickListener;//!
    }

    @NonNull
    @Override
    public PropertyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.property_row,parent,false);
        return new PropertyViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull PropertyViewHolder holder, int position) {
    holder.propertyImageView.setImageResource(propertyList.get(position).getImage());
    holder.headlineTextView.setText(propertyList.get(position).getHeadline());
    holder.subtitleTextView.setText(propertyList.get(position).getSubtitle());
    }

    @Override
    public int getItemCount() {
        return propertyList.size();
    }

    public class PropertyViewHolder extends  RecyclerView.ViewHolder implements  View.OnClickListener{
        public ImageView propertyImageView;
        public TextView headlineTextView,  subtitleTextView;
        public OnRowClickListener onRowClickListener;

        public PropertyViewHolder(@NonNull View itemView, OnRowClickListener onRowClickListener) {
            super(itemView);
            propertyImageView = itemView.findViewById(R.id.propertyImageView);
            headlineTextView = itemView.findViewById(R.id.headlineTextView);
            subtitleTextView = itemView.findViewById(R.id.subtitleTextView);
            this.onRowClickListener = onRowClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onRowClickListener.onItemClick(getAdapterPosition());
        }
    }
    public interface OnRowClickListener{
        void onItemClick(int position);
    }
}
