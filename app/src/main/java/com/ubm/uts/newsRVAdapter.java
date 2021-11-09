package com.ubm.uts;

import android.view.LayoutInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class newsRVAdapter extends RecyclerView.Adapter<newsRVAdapter.MyViewHolder> {


    int[]arr;
    String[]arr1,arr2;
    public newsRVAdapter(int[] arr, String[] arr1, String[] arr2) {
        this.arr = arr;
        this.arr1 = arr1;
        this.arr2 = arr2;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_rv_item,parent,false);
        MyViewHolder MyViewHolder = new MyViewHolder(view);
        return MyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nameImageView.setImageResource(arr[position]);
        holder.nameTextView.setText(arr1[position]);
        holder.nameTextView2.setText(arr2[position]);
    }

    @Override
    public int getItemCount() {
        return arr.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView nameTextView2;
        public ImageView nameImageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.tvNews);
            nameImageView = (ImageView) itemView.findViewById(R.id.ivNews);
            nameTextView2 = (TextView) itemView.findViewById(R.id.tvSubTitle);
        }
    }
}
