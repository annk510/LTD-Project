package com.example.vongship_android.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vongship_android.Adapter.ProductAdapter;
import com.example.vongship_android.Adapter.StoresAdapter;
import com.example.vongship_android.DTO.Product;
import com.example.vongship_android.DTO.Store;
import com.example.vongship_android.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class ProductDetailsActivity  extends AppCompatActivity {
    RecyclerView products;
    ArrayList<Product> productArrayList;
    ProductAdapter productAdapter;
    void loadProductRecyclerView(LinearLayoutManager layoutManager){
        products = findViewById(R.id.listProductInStore);
        products.setHasFixedSize(true);
        products.setLayoutManager(layoutManager);
        productArrayList = new ArrayList<>();
        productArrayList.add(new Product("1","Tên sản phẩm 1","Giá sản phẩm 1","Mô tả của sản phẩm 1",R.drawable.trsua));
        productArrayList.add(new Product("2","Tên sản phẩm 2","Giá sản phẩm 2","Mô tả của sản phẩm 2",R.drawable.trsua));
        productArrayList.add(new Product("3","Tên sản phẩm 3","Giá sản phẩm 3","Mô tả của sản phẩm 3",R.drawable.trsua));
        productArrayList.add(new Product("4","Tên sản phẩm 4","Giá sản phẩm 4","Mô tả của sản phẩm 4",R.drawable.trsua));
        productArrayList.add(new Product("5","Tên sản phẩm 5","Giá sản phẩm 5","Mô tả của sản phẩm 5",R.drawable.trsua));
        productArrayList.add(new Product("6","Tên sản phẩm 6","Giá sản phẩm 6","Mô tả của sản phẩm 6",R.drawable.trsua));
        productAdapter = new ProductAdapter(productArrayList,this,LinearLayoutManager.VERTICAL);
        products.setAdapter(productAdapter);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        loadProductRecyclerView(layoutManager);
        Button button_buy = findViewById(R.id.button_buy);
        button_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(ProductDetailsActivity.this,R.style.BottomSheetDialogTheme);
                final View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_sheet_cards,(LinearLayout)findViewById(R.id.bottom_sheet));
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
                bottomSheetView.findViewById(R.id.remove_one).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextView currentQuantityText = bottomSheetView.findViewById(R.id.quantity);
                        int currentQuantity = Integer.parseInt((String) currentQuantityText.getText());
                        if(currentQuantity > 1) {
                            int newQuantity = currentQuantity - 1;
                            currentQuantityText.setText(String.valueOf(newQuantity));
                        }
                    }
                });
                bottomSheetView.findViewById(R.id.add_one);
                bottomSheetView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextView currentQuantityText = bottomSheetView.findViewById(R.id.quantity);
                        int currentQuantity = Integer.parseInt((String) currentQuantityText.getText());
                        int newQuantity = currentQuantity + 1;
                        currentQuantityText.setText(String.valueOf(newQuantity));
                    }
                });
                bottomSheetView.findViewById(R.id.addtoCard).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        bottomSheetDialog.hide();
                    }
                });
            }
        });
    }
}
