package com.example.vongship_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.vongship_android.DTO.InvFriend;
import com.example.vongship_android.DTO.ProductPoint;
import com.example.vongship_android.R;

import java.util.List;

public class ProductPointAdapter extends BaseAdapter {
    private Context context;
    int layout;
    List<ProductPoint> productList;

    public ProductPointAdapter(Context context, int layout, List<ProductPoint> productList) {
        this.context = context;
        this.layout = layout;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.item_point_shop, null);

        ImageView Image = (ImageView) convertView.findViewById(R.id.product_img);
        TextView Name = (TextView) convertView.findViewById(R.id.name);
        TextView Sale = (TextView) convertView.findViewById(R.id.sale);
        TextView Point = (TextView) convertView.findViewById(R.id.point);

        ProductPoint Product = productList.get(position);

        Image.setImageResource(Product.getImage());
        Name.setText(Product.getName());
        Sale.setText(Product.getSale());
        Point.setText(Product.getPoint());
        return convertView;
    }
}
