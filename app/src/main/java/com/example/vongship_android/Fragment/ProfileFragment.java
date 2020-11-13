package com.example.vongship_android.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.vongship_android.Class.DownloadImageTask;
import com.example.vongship_android.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class ProfileFragment extends Fragment {
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile,container,false);
        TextView txt_name= (TextView) root.findViewById(R.id.nameTv);

        auth = FirebaseAuth.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String email = user.getEmail();

            txt_name.setText(email);
        }
        new DownloadImageTask((ImageView) root.findViewById(R.id.profile_image))
                .execute("https://firebasestorage.googleapis.com/v0/b/doanltdd-60a15.appspot.com/o/Image%2FprofileImage.jpg?alt=media&token=40d48a63-1ac3-4e2c-946d-4b8515f79c62");
        return root;
    }
}