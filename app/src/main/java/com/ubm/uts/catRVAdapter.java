package com.ubm.uts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class catRVAdapter extends RecyclerView.Adapter<catRVAdapter.MyViewHolder> {


    int[]arr;
    String[]arr1;

    //Get Method
    public catRVAdapter(int[] arr, String[]arr1) {
        this.arr = arr;
        this.arr1 = arr1;
    }
    @NonNull
    @Override
    //Initialize ViewHolder
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_rv_item,parent,false);
        MyViewHolder MyViewHolder = new MyViewHolder(view);
        return MyViewHolder;
    }

    @Override
    //Input data to ViewHolder
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nameImageView.setImageResource(arr[position]);
        holder.nameTextView.setText(arr1[position]);
    }

    @Override
    //Item Counts
    public int getItemCount() {
        return arr.length;
    }

    //Create ViewHolder
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public ImageView nameImageView;
        //Search for specific elements in View
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.tvCategory);
            nameImageView = (ImageView) itemView.findViewById(R.id.ivCategory);
        }

    }
}
