package com.example.vongship_android.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.vongship_android.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ChangeProfileActivity extends AppCompatActivity {
    EditText edtDtae;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_profile);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.gender,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        edtDtae = (EditText) findViewById(R.id.edtDate);
        edtDtae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseDate();
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Thay đổi thông tin cá nhân");
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            EditText edt_name= findViewById(R.id.txt_change_name);
            EditText edt_mail= findViewById(R.id.txt_change_mail);
            edt_name.setText(user.getDisplayName());
            edt_mail.setText(user.getEmail());

        final EditText name= findViewById(R.id.txt_change_name);
        Button bt_change= findViewById(R.id.bt_change_profile);
        bt_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                        .setDisplayName(name.getText().toString())
                        .build();
                user.updateProfile(profileUpdates)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "Đã cập nhật", Toast.LENGTH_SHORT).show();
                                    onBackPressed();
                                }
                            }
                        });

            }
        });
        }

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
    private  void ChooseDate(){
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);
                SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");
                edtDtae.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },2000,04,02);
        datePickerDialog.show();
    }

}