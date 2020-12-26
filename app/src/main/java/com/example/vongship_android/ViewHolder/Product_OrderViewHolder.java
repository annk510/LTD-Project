package com.example.vongship_android.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vongship_android.R;

public class Product_OrderViewHolder extends RecyclerView.ViewHolder{
    private ImageView cong1,tru1;
    private TextView name,totalmoney,quantity;

    public ImageView getCong1() {
        return cong1;
    }

    public void setCong1(ImageView cong1) {
        this.cong1 = cong1;
    }

    public ImageView getTru1() {
        return tru1;
    }

    public void setTru1(ImageView tru1) {
        this.tru1 = tru1;
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public TextView getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(TextView totalmoney) {
        this.totalmoney = totalmoney;
    }

    public TextView getQuantity() {
        return quantity;
    }

    public void setQuantity(TextView quantity) {
        this.quantity = quantity;
    }

    public Product_OrderViewHolder(@NonNull View itemView) {
        super(itemView);
        this.setCong1((ImageView) itemView.findViewById(R.id.cong1));
        this.setTru1((ImageView) itemView.findViewById(R.id.tru1));
        this.setName((TextView) itemView.findViewById(R.id.name));
        this.setTotalmoney((TextView) itemView.findViewById(R.id.totalmoney));
        this.setQuantity((TextView) itemView.findViewById(R.id.quantity));
    }
}
