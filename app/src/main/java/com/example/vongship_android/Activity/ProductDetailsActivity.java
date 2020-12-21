package com.example.vongship_android.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vongship_android.Adapter.ProductAdapter;
import com.example.vongship_android.Adapter.StoresAdapter;
import com.example.vongship_android.Class.DownloadImageTask;
import com.example.vongship_android.DTO.Product;
import com.example.vongship_android.DTO.Store;
import com.example.vongship_android.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ProductDetailsActivity  extends AppCompatActivity {
    RecyclerView products;
    ArrayList<Product> productArrayList;
     ProductAdapter productAdapter;
     Product product;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        product = (Product) getIntent().getSerializableExtra("Product");
        TextView name = findViewById(R.id.name);
        name.setText(product.getProductname());
        TextView price = findViewById(R.id.price);
        price.setText(product.getPrice()+ "VNĐ");
        ImageView image = findViewById(R.id.image);
        new DownloadImageTask(image).execute(product.getImg());
        loadProductRecyclerView(layoutManager);
        Button button_buy = findViewById(R.id.button_buy);

        button_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(ProductDetailsActivity.this,R.style.BottomSheetDialogTheme);
                final View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_sheet_cards,(LinearLayout)findViewById(R.id.bottom_sheet));
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
                Button addtocard = bottomSheetView.findViewById(R.id.addtoCard);
                addtocard.setText("Thêm " + product.getPrice() + "VNĐ");
                ImageView image = bottomSheetDialog.findViewById(R.id.image);
                new DownloadImageTask(image).execute(product.getImg());
                TextView itemname = bottomSheetDialog.findViewById(R.id.name);
                itemname.setText(product.getProductname());
                TextView itemprice = bottomSheetDialog.findViewById(R.id.price);
                itemprice.setText(product.getPrice() + "VNĐ");

                bottomSheetView.findViewById(R.id.remove_one).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextView currentQuantityText = bottomSheetView.findViewById(R.id.quantity);
                        int currentQuantity = Integer.parseInt((String) currentQuantityText.getText());
                        if(currentQuantity > 1) {
                            int newQuantity = currentQuantity - 1;
                            currentQuantityText.setText(String.valueOf(newQuantity));
                            Button addtocard = bottomSheetView.findViewById(R.id.addtoCard);
                            addtocard.setText("Thêm "+ (newQuantity*Integer.parseInt(product.getPrice())) + "VNĐ");

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
                        Button addtocard = bottomSheetView.findViewById(R.id.addtoCard);
                        addtocard.setText("Thêm "+ (newQuantity*Integer.parseInt(product.getPrice())) + "VNĐ");
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
        Toolbar toolbar =findViewById(R.id.toolbarProducdetail);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.abc);    //logo muốn hiện thị trên action bar
        actionBar.setDisplayUseLogoEnabled(true);

        actionBar.setDisplayHomeAsUpEnabled(true);//của nút quay lại trên toolbar, có cái func ở dưới nữa.

        actionBar.setTitle("");
    }
    void loadProductRecyclerView(LinearLayoutManager layoutManager){
        products = findViewById(R.id.listProductInStore);
        products.setHasFixedSize(true);
        products.setLayoutManager(layoutManager);


        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Product").whereEqualTo("storeid",product.getStoreid())
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            productArrayList = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Product product = new Product();
                                product.setProductid(document.getId());
                                product.setProductname(document.getString("name"));
                                product.setDescription(document.getString("description"));
                                product.setPrice(document.get("price").toString());
                                product.setImg(document.getString("image"));
                                product.setStoreid(document.getString("storeid"));
                                productArrayList.add(product);
                            }
                            productAdapter = new ProductAdapter(productArrayList,ProductDetailsActivity.this,LinearLayoutManager.VERTICAL);
                            products.setAdapter(productAdapter);
                        } else {
                            Log.w("adad", "Error getting documents.", task.getException());
                        }
                    }
                });

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}