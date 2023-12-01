package com.example.warung.activity.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.warung.R;

public class DetailLaptop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_laptop);

        ImageView imageView =  findViewById(R.id.poster_image2);
        TextView nama_tv = findViewById(R.id.textViewNama);
        TextView merk_tv = findViewById(R.id.textViewMerk);
        TextView harga_tv = findViewById(R.id.textViewHarga);
        TextView processor_tv = findViewById(R.id.textViewProcessor);
        TextView gpu_tv = findViewById(R.id.textViewGpu);
        TextView os_tv = findViewById(R.id.textViewOs);
        TextView ram_tv = findViewById(R.id.textViewRam);
        TextView storage_tv = findViewById(R.id.textViewStorage);
        TextView display_tv = findViewById(R.id.textViewDisplay);

        Bundle bundle = getIntent().getExtras();

        String nama = bundle.getString("nama");
        String merk = bundle.getString("merk");
        String harga = bundle.getString("harga");
        String gambar2 = bundle.getString("gambar2");
        String processor = bundle.getString("processor");
        String gpu = bundle.getString("gpu");
        String os = bundle.getString("os");
        String ram = bundle.getString("ram");
        String storage = bundle.getString("storage");
        String display = bundle.getString("display");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(nama);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Glide.with(this).load(gambar2).into(imageView);
        nama_tv.setText(nama.toString());
        merk_tv.setText(merk.toString());
        harga_tv.setText(harga.toString());
        processor_tv.setText(processor.toString());
        gpu_tv.setText(gpu.toString());
        os_tv.setText(os.toString());
        ram_tv.setText(ram.toString());
        storage_tv.setText(storage.toString());
        display_tv.setText(display.toString());
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