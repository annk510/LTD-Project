package com.example.vongship_android.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vongship_android.Adapter.ProductAdapter;
import com.example.vongship_android.Adapter.Product_OrderAdapter;
import com.example.vongship_android.DTO.Product;
import com.example.vongship_android.DTO.Product_order;
import com.example.vongship_android.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;

public class Cart extends AppCompatActivity {
    public static TextView totalmoneytext;
    public static RecyclerView cart;
    public static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        totalmoneytext = findViewById(R.id.totalmoney);
        int totalmoney =15000;
        for (Product_order product_order:ProductDetailsActivity.product_orderArrayList
             ) {
            totalmoney += Integer.parseInt(product_order.getQuatity())*Integer.parseInt(product_order.getPrice());
        }
        totalmoneytext.setText(String.valueOf(totalmoney));
        cart = findViewById(R.id.cart);
        context = Cart.this;
        Product_OrderAdapter product_orderAdapter = new Product_OrderAdapter(ProductDetailsActivity.product_orderArrayList,this);
        cart.setHasFixedSize(true);
        cart.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        cart.setAdapter(product_orderAdapter);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar_cart);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Giỏ Hàng");

        final TextView location = findViewById(R.id.vt_Cart);
        location.setText(VT());

        TextView userName = findViewById(R.id.UserName);
        TextView storeName = findViewById(R.id.storeName);
        TextView storeAddr = findViewById(R.id.storeAddress);
        if (ProductDetailsActivity.product_orderArrayList.isEmpty()){
            storeAddr.setText("");
            storeName.setText("Bạn chưa có món nào trong giỏ hàng !");
            storeName.setTextSize(18);
        }


        for (Product_order product_order:ProductDetailsActivity.product_orderArrayList  ) {
            storeName.setText(product_order.getProductname());
        }


        FirebaseAuth auth = FirebaseAuth.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            if(user.getDisplayName().equals("")){
                userName.setText(user.getEmail());
            }else{
                userName.setText(user.getDisplayName());
            }
        }
        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        Button addCart = findViewById(R.id.add_cart);
        addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> orders = new HashMap<>();
                orders.put("userid",user.getUid());
                final LocalDateTime currentime = LocalDateTime.now();
                String time = currentime.toString();
                orders.put("createtime", time);
                orders.put("location",location.getText());
                db.collection("Orders").add(orders);
                final TextView doc = null;

                db.collection("Orders").whereEqualTo("createtime",time).whereEqualTo("userid",user.getUid().toString()).limit(1)
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        for (Product_order product_order:ProductDetailsActivity.product_orderArrayList) {
                                            Map<String, Object> ordersD1 = new HashMap<>();
                                            ordersD1.put("productId",product_order.getProductid());
                                            ordersD1.put("productName",product_order.getProductname());
                                            ordersD1.put("quantity",product_order.getQuatity());
                                            db.collection("Orders").document(document.getId()).collection("Orderdetail").add(ordersD1);

                                        }
                                    }
                                    Toast.makeText(getApplicationContext(), "Đặt hàng thành công", Toast.LENGTH_SHORT).show();
                                    onBackPressed();
                                    onBackPressed();
                                    ProductDetailsActivity.product_orderArrayList.clear();
                                }
                            }
                        });

            }
        });




    }
    public String VT() {
        LocationManager locationManager = (LocationManager) Cart.this.getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(Cart.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Cart.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return null;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, locationListener);
        Criteria criteria = new Criteria();

        Location lastLocation = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
        double latitude = 0;
        double longitude = 0;
        if(lastLocation!= null){
            latitude = lastLocation.getLatitude();
            longitude = lastLocation.getLongitude();
        }
        Geocoder geoCoder = new Geocoder(Cart.this, Locale.getDefault());
        List<Address> matches = null;
        try {
            matches = geoCoder.getFromLocation(latitude, longitude, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String address=null;
        if(matches != null){
            Address bestMatch = (matches.isEmpty() ? null : matches.get(0));
            if(bestMatch != null){
                address= bestMatch.getAddressLine(0);
            }

        }

        return address;

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: // nút back
                onBackPressed();
                return true;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    LocationListener locationListener= new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location location) {
            double longitude= location.getLongitude();
            double lat= location.getLatitude();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(@NonNull String provider) {

        }

        @Override
        public void onProviderDisabled(@NonNull String provider) {

        }
    };
}