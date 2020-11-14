package com.example.vongship_android.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.vongship_android.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private TextView gotoLogin;
    private CheckBox policy;
    private EditText inputGmail, inputPasswords, inputconfirmPasswords;
    private Button button_register;
    private ProgressBar progressBar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        gotoLogin = (TextView)  findViewById(R.id.gotoLogin);
        button_register = (Button) findViewById(R.id.button_register);
        inputGmail = (EditText) findViewById(R.id.inputGmail);
        inputPasswords = (EditText) findViewById(R.id.inputPasswords);
        inputconfirmPasswords =(EditText) findViewById(R.id.inputconfirmPasswords);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        policy = (CheckBox) findViewById(R.id.policy);
        auth = FirebaseAuth.getInstance();



        gotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String gmail = inputGmail.getText().toString().trim();
                String password = inputPasswords.getText().toString().trim();
                String confirm = inputconfirmPasswords.getText().toString().trim();

                if (TextUtils.isEmpty(gmail)) {
                    Toast.makeText(getApplicationContext(), "Email không được trống!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Nhập mật khẩu!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Mật khẩu quá ngắn, trên 6 kí tự!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.equals(confirm)==false) {
                    Toast.makeText(getApplicationContext(), "Mật khẩu nhập không khớp!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (policy.isChecked()==false){
                    Toast.makeText(getApplicationContext(), "Vui lòng đồng ý điều khoản, chính sách!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                //create user
                auth.createUserWithEmailAndPassword(gmail, password)
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(RegisterActivity.this, "Tạo tài khoản thành công:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(RegisterActivity.this, "Thất bại." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                                    finish();
                                }
                            }
                        });

            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarReg);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.abc);    //logo muốn hiện thị trên action bar
        actionBar.setDisplayUseLogoEnabled(true);

        actionBar.setDisplayHomeAsUpEnabled(true);//của nút quay lại trên toolbar, có cái func ở dưới nữa.

        actionBar.setTitle("");
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
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