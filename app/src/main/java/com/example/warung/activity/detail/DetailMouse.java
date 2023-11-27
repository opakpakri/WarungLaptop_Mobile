package com.example.warung.activity.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.warung.R;

public class DetailMouse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mouse);

        ImageView imageView =  findViewById(R.id.poster_image2);
        TextView nama_tv = findViewById(R.id.textViewNama);
        TextView merk_tv = findViewById(R.id.textViewMerk);
        TextView harga_tv = findViewById(R.id.textViewHarga);
        TextView dpi_tv = findViewById(R.id.textViewDpi);
        TextView button_tv = findViewById(R.id.textViewButton);
        TextView sensor_tv = findViewById(R.id.textViewSensor);
        Bundle bundle = getIntent().getExtras();

        String nama = bundle.getString("nama");
        String merk = bundle.getString("merk");
        String harga = bundle.getString("harga");
        String gambar2 = bundle.getString("gambar2");
        String dpi = bundle.getString("dpi");
        String button = bundle.getString("button");
        String sensor = bundle.getString("sensor");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(nama);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Glide.with(this).load(gambar2).into(imageView);
        nama_tv.setText(nama.toString());
        merk_tv.setText(merk.toString());
        harga_tv.setText(harga.toString());
        dpi_tv.setText(dpi.toString());
        button_tv.setText(button.toString());
        sensor_tv.setText(sensor.toString());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {// Kembali ke halaman sebelumnya
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}