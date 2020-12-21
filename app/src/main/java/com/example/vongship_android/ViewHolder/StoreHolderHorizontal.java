package com.example.vongship_android.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vongship_android.R;

public class StoreHolderHorizontal extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{
    private TextView distance;
    private TextView sales;
    private TextView name;
    private ImageView img;
    private ItemClickListener itemClickListener;

    public ItemClickListener getItemClickListener() {
        return itemClickListener;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public TextView getDistance() {
        return distance;
    }

    public void setDistance(TextView distance) {
        this.distance = distance;
    }

    public TextView getSales() {
        return sales;
    }

    public void setSales(TextView sales) {
        this.sales = sales;
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public StoreHolderHorizontal(@NonNull View itemView) {
        super(itemView);
        this.setName((TextView) itemView.findViewById(R.id.itemstorehorizontal_name)) ;
        this.setImg((ImageView) itemView.findViewById(R.id.itemstorehorizontal_image));
        this.setDistance((TextView) itemView.findViewById(R.id.itemstorehorizontal_distance));
        this.setSales((TextView) itemView.findViewById(R.id.itemstorehorizontal_sales));
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false);
    }

    @Override
    public boolean onLongClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),true);
        return true;
    }

}
