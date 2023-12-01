package com.example.warung.activity.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.warung.R;

public class DetailKeyboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_keyboard);

        ImageView imageView =  findViewById(R.id.poster_image2);
        TextView nama_tv = findViewById(R.id.textViewNama);
        TextView merk_tv = findViewById(R.id.textViewMerk);
        TextView harga_tv = findViewById(R.id.textViewHarga);
        TextView jumlahtombol_tv = findViewById(R.id.textViewJumlahtombol);
        TextView konektivitas_tv = findViewById(R.id.textViewKonektivitas);
        TextView kompatibilitas_tv = findViewById(R.id.textViewKompatibilitas);
        TextView ukuran_tv = findViewById(R.id.textViewUkuran);

        Bundle bundle = getIntent().getExtras();

        String nama = bundle.getString("nama");
        String merk = bundle.getString("merk");
        String harga = bundle.getString("harga");
        String gambar2 = bundle.getString("gambar2");
        String jumlahtombol = bundle.getString("jumlah_tombol");
        String konektivitas = bundle.getString("konektivitas");
        String kompatibilitas = bundle.getString("kompatibilitas");
        String ukuran = bundle.getString("ukuran");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(nama);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Glide.with(this).load(gambar2).into(imageView);
        nama_tv.setText(nama.toString());
        merk_tv.setText(merk.toString());
        harga_tv.setText(harga.toString());
        jumlahtombol_tv.setText(jumlahtombol.toString());
        konektivitas_tv.setText(konektivitas.toString());
        kompatibilitas_tv.setText(kompatibilitas.toString());
        ukuran_tv.setText(ukuran.toString());
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