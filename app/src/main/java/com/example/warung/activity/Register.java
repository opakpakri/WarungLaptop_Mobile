package com.example.warung.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.warung.R;
import com.example.warung.db.dbHelper;

public class Register extends AppCompatActivity {
    private EditText edtUsername, edtPassword, edtnohp, edtemail, edtUpass;
    private Button btnregister;
    private TextView pgLogin;
    private dbHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        myDbHelper = new dbHelper(this);
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_passwd);
        edtnohp = findViewById(R.id.edt_nohp);
        edtemail = findViewById(R.id.edt_email);
        edtUpass = findViewById(R.id.edt_repasswd);
        btnregister = findViewById(R.id.btn_register);
        pgLogin = findViewById(R.id.pg_login);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                String nohp = edtnohp.getText().toString();
                String email = edtemail.getText().toString();
                String rePassword = edtUpass.getText().toString();

                if (username.isEmpty() || password.isEmpty() || nohp.isEmpty() || email.isEmpty() || rePassword.isEmpty()) {
                    showToast("Semua field harus diisi");
                } else {
                    if (password.equals(rePassword)) {
                        // Password cocok, simpan ke database
                        myDbHelper.addUser(username, password, nohp, email);
                        // Tambahkan logika lain jika diperlukan
                        showToast("Pendaftaran berhasil!");
                        finish();
                    } else {
                        // Password tidak cocok
                        showToast("Password tidak cocok");
                    }
                }
            }
        });

        pgLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Kembali ke halaman login
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
