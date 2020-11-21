package com.example.vongship_android.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vongship_android.R;

public class ProductHolderVertical extends RecyclerView.ViewHolder{
    private TextView name,price,description;
    private ImageView img;

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public TextView getPrice() {
        return price;
    }

    public void setPrice(TextView price) {
        this.price = price;
    }

    public TextView getDescription() {
        return description;
    }

    public void setDescription(TextView description) {
        this.description = description;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public ProductHolderVertical(@NonNull View itemView) {
        super(itemView);
        this.setName((TextView) itemView.findViewById(R.id.itemproduct_name)) ;
        this.setDescription((TextView) itemView.findViewById(R.id.itemproduct_description)); ;
        this.setPrice((TextView) itemView.findViewById(R.id.itemproduct_price)); ;
        this.setImg((ImageView) itemView.findViewById(R.id.itemproduct_image));
    }
}
