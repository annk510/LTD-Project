package com.example.vongship_android.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vongship_android.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordsActivity extends AppCompatActivity {

    private EditText inputEmail;
    private Button btnReset;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpasswords);

        inputEmail = (EditText) findViewById(R.id.user_qmk);
        btnReset = (Button) findViewById(R.id.bt_qmk);
        progressBar = (ProgressBar) findViewById(R.id.progressBar3);
        TextView txt_dangnhap= (TextView) findViewById(R.id.txt_dangnhap);


        auth = FirebaseAuth.getInstance();

        txt_dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotPasswordsActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

                String email = inputEmail.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplication(), "Nhập Email bạn đã đăng ký!", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(ForgotPasswordsActivity.this, "Chúng tôi sẽ gửi Email cho bạn để đặt lại mật khẩu!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(ForgotPasswordsActivity.this, "Gửi Email thất bại!", Toast.LENGTH_SHORT).show();
                                }

                                progressBar.setVisibility(View.GONE);
                            }
                        });
            }
        });
    }
}