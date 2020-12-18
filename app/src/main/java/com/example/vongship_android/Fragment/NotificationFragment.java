package com.example.vongship_android.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.vongship_android.Activity.NotificationsDetailActivity;
import com.example.vongship_android.Activity.ProductDetailsActivity;
import com.example.vongship_android.Adapter.NotificationFragAdapter;
import com.example.vongship_android.Adapter.ProductAdapter;
import com.example.vongship_android.DTO.NotificationFrag;
import com.example.vongship_android.DTO.Product;
import com.example.vongship_android.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class NotificationFragment extends Fragment {
    ListView listView;
    NotificationFragAdapter adapter;
    ArrayList<NotificationFrag> fragArrayList;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications,container,false);
        listView = (ListView) root.findViewById(R.id.ListView);
        Anhxa();



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent myIntent = new Intent(getActivity(), NotificationsDetailActivity.class);
                NotificationFragment.this.startActivity(myIntent);
            }
        });
        return root;
    }

    private void Anhxa() {

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Notifications")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            fragArrayList = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                NotificationFrag notifi = new NotificationFrag();
                                notifi.setmTitle(document.get("title").toString());
                                notifi.setmDescription(document.get("description").toString());
                                notifi.setImages(document.get("images").toString());

                                fragArrayList.add(notifi);
                            }
                            adapter = new NotificationFragAdapter(getActivity(), R.layout.item_notification, fragArrayList);
                            listView.setAdapter(adapter);
                        } else {
                            Log.w("adad", "Error getting documents.", task.getException());
                        }
                    }
                });

    }
}
