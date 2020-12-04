package com.example.vongship_android.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.vongship_android.Activity.CardManageActivity;
import com.example.vongship_android.Activity.DetailProfileFeature;
import com.example.vongship_android.Activity.DetailProfileStore;
import com.example.vongship_android.Activity.FavoriteShopActivity;
import com.example.vongship_android.Activity.LoshipCommunityActivity;
import com.example.vongship_android.Activity.QuestionActivity;
import com.example.vongship_android.Activity.RecommendAppActivity;
import com.example.vongship_android.Class.DownloadImageTask;
import com.example.vongship_android.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class ProfileFragment extends Fragment {
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;
    private TextView tv_favorShop, tv_cardManage, tv_question, tv_comment;
    private TextView txtStore;
    private TextView txtFeature;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile,container,false);
        TextView txt_name= (TextView) root.findViewById(R.id.nameTv);
        root.findViewById(R.id.recommend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RecommendAppActivity.class);
                startActivity(intent);
            }
        });
        tv_question=(TextView)root.findViewById(R.id.question);
        tv_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), QuestionActivity.class);
                ProfileFragment.this.startActivity(intent);
            }
        });
        tv_cardManage=(TextView)root.findViewById(R.id.card_manage);
        tv_cardManage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CardManageActivity.class);
                ProfileFragment.this.startActivity(intent);
            }
        });
        tv_favorShop=(TextView)root.findViewById(R.id.favor_shop);
        tv_favorShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FavoriteShopActivity.class);
                ProfileFragment.this.startActivity(intent);
            }
        });
        tv_comment=(TextView)root.findViewById(R.id.tv_comment);
        tv_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoshipCommunityActivity.class);
                ProfileFragment.this.startActivity(intent);
            }
        });

        txtStore = (TextView)root.findViewById(R.id.detailstore);
        txtStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DetailProfileStore.class);
                ProfileFragment.this.startActivity(intent);
            }
        });

        txtFeature = (TextView)root.findViewById(R.id.detailfeature);
        txtFeature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DetailProfileFeature.class);
                ProfileFragment.this.startActivity(intent);
            }
        });

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