package com.example.vongship_android.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

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
import android.view.MenuItem;
import android.widget.TextView;

import com.example.vongship_android.Adapter.CategoriesAdapter;
import com.example.vongship_android.Adapter.BannerAdapter;
import com.example.vongship_android.Adapter.StoresAdapter;
import com.example.vongship_android.DTO.Categories;
import com.example.vongship_android.DTO.Store;
import com.example.vongship_android.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FoodDeliveryActivity extends AppCompatActivity {
    RecyclerView categories;
    RecyclerView stores,stores1;
    ArrayList<Categories> categoriesArrayList;
    ArrayList<Store> storeArrayList;
    CategoriesAdapter categoriesAdapter;
    StoresAdapter storesAdapter;
    void loadCategoriesRecyclerView(LinearLayoutManager layoutManager){
        categories = findViewById(R.id.CategoriesRecyclerView);
        categories.setHasFixedSize(true);
        categories.setLayoutManager(layoutManager);
        categoriesArrayList = new ArrayList<>();
        categoriesArrayList.add(new Categories(1,"Cơm",R.drawable.comga));
        categoriesArrayList.add(new Categories(2,"Bánh Mỳ",R.drawable.banhmy));
        categoriesArrayList.add(new Categories(3,"Trà Sữa",R.drawable.trasua));
        categoriesArrayList.add(new Categories(4,"Cà Phê",R.drawable.caphe));
        categoriesArrayList.add(new Categories(5,"Nước Giải Khát",R.drawable.rauma));
        categoriesArrayList.add(new Categories(7,"Bánh Cuốn",R.drawable.banhep));
        categoriesAdapter = new CategoriesAdapter(categoriesArrayList,this,LinearLayoutManager.HORIZONTAL);
        categories.setAdapter(categoriesAdapter);

    }
    void loadStoreRecyclerView(LinearLayoutManager layoutManager){
        stores = findViewById(R.id.StoresRecyclerView);
        stores.setHasFixedSize(true);
        stores.setLayoutManager(layoutManager);
        storeArrayList = new ArrayList<>();
        storeArrayList.add(new Store("Bánh Ép Huế Hải Phòng","400 m","Freeship 2km",R.drawable.banhep));
        storeArrayList.add(new Store("Cà Phê Trung Nguyên","1.2 km","Freeship 2km",R.drawable.caphe));
        storeArrayList.add(new Store("Cơm Chiên Hảo Hảo","700 m","Freeship 2km",R.drawable.comchien));
        storeArrayList.add(new Store("Bánh Cuốn Lê Duẫn","1.7 km","Freeship 3km",R.drawable.banhcuon));
        storeArrayList.add(new Store("Cơm Gà Trần Cao Vân","900 m","Freeship 3km",R.drawable.comga));
        storeArrayList.add(new Store("Milk Tea & Coffee Bông","2 km","Freeship 2km",R.drawable.trasua));
        storesAdapter = new StoresAdapter(storeArrayList,this,LinearLayoutManager.HORIZONTAL);
        stores.setAdapter(storesAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_delivery);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        loadCategoriesRecyclerView(layoutManager);

//        stores = findViewById(R.id.StoresRecyclerView);
//        stores.setHasFixedSize(true);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
//        stores.setLayoutManager(layoutManager1);
//        stores.setAdapter(categoriesAdapter);
        loadStoreRecyclerView(layoutManager1);
        stores1 = findViewById(R.id.StoresRecyclerView1);
        stores1.setHasFixedSize(true);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        stores1.setLayoutManager(layoutManager2);
        stores1.setAdapter(storesAdapter);

        ViewPager viewPager = findViewById(R.id.viewPager);
        BannerAdapter adapter = new BannerAdapter(this);
        viewPager.setAdapter(adapter);
        TextView currentLocation = (TextView) findViewById(R.id.currentLocation);
        currentLocation.setText(VT());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarFood);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.abc);    //logo muốn hiện thị trên action bar
        actionBar.setDisplayUseLogoEnabled(true);

        actionBar.setDisplayHomeAsUpEnabled(true);//của nút quay lại trên toolbar, có cái func ở dưới nữa.

        actionBar.setTitle("");


    }

    public String VT() {
        LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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
        Geocoder geoCoder = new Geocoder(this, Locale.getDefault());
        List<Address> matches = null;
        try {
            matches = geoCoder.getFromLocation(latitude, longitude, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Address bestMatch = (matches.isEmpty() ? null : matches.get(0));
        String address=null;
        if(bestMatch !=null){
            address= bestMatch.getAddressLine(0);
        }

        return address;

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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
}