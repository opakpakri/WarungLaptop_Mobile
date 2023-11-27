package com.example.warung.activity.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.warung.R;

public class DetailHeadset extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_headset);

        ImageView imageView =  findViewById(R.id.poster_image2);
        TextView nama_tv = findViewById(R.id.textViewNama);
        TextView merk_tv = findViewById(R.id.textViewMerk);
        TextView harga_tv = findViewById(R.id.textViewHarga);
        TextView cablelength_tv = findViewById(R.id.textViewCablelength);
        TextView audiojack_tv = findViewById(R.id.textViewAudiojack);
        TextView speakersize_tv = findViewById(R.id.textViewSpeakersize);
        TextView color_tv = findViewById(R.id.textViewColor);

        Bundle bundle = getIntent().getExtras();

        String nama = bundle.getString("nama");
        String merk = bundle.getString("merk");
        String harga = bundle.getString("harga");
        String gambar2 = bundle.getString("gambar2");
        String cablelength = bundle.getString("cable_length");
        String audiojack = bundle.getString("audio_jack");
        String speakersize = bundle.getString("speaker_size");
        String color = bundle.getString("color");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(nama);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Glide.with(this).load(gambar2).into(imageView);
        nama_tv.setText(nama.toString());
        merk_tv.setText(merk.toString());
        harga_tv.setText(harga.toString());
        cablelength_tv.setText(cablelength.toString());
        audiojack_tv.setText(audiojack.toString());
        speakersize_tv.setText(speakersize.toString());
        color_tv.setText(color.toString());
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