package com.example.warung.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.warung.R;
import com.example.warung.activity.detail.DetailKeyboard;
import com.example.warung.activity.detail.DetailLaptop;
import com.example.warung.model.Keyboard;
import com.example.warung.model.Laptop;

import java.security.Key;
import java.util.List;

public class KeyboardAdapter extends RecyclerView.Adapter<KeyboardAdapter.KeyboardHolder> {
    public Context context;
    private List<Keyboard> keyboardList;
    public KeyboardAdapter(Context context , List<Keyboard> keyboards){
        this.context = context;
        keyboardList = keyboards;
    }
    @NonNull
    @Override
    public KeyboardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_view, parent,false);
        return new KeyboardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KeyboardHolder holder, int position) {

        Keyboard keyboard = keyboardList.get(position);
        holder.nama.setText(keyboard.getNama().toString());
        holder.merk.setText(keyboard.getMerk().toString());
        holder.harga.setText(keyboard.getHarga().toString());
        Glide.with(context).load(keyboard.getGambar()).into(holder.gambar);

        holder.wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Added to wishlist: " + keyboard.getNama(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailKeyboard.class);

                Bundle bundle =  new Bundle();
                bundle.putString("nama",  keyboard.getNama());
                bundle.putString("merk",  keyboard.getMerk());
                bundle.putString("harga",  keyboard.getHarga());
                bundle.putString("gambar", keyboard.getGambar());
                bundle.putString("gambar2",  keyboard.getGambar2());
                bundle.putString("jumlah_tombol",  keyboard.getJumlahtombol());
                bundle.putString("konektivitas",  keyboard.getKonektivitas());
                bundle.putString("kompatibilitas",  keyboard.getKompatibilitas());
                bundle.putString("ukuran",  keyboard.getUkuran());

                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return keyboardList.size();
    }

    public class KeyboardHolder extends RecyclerView.ViewHolder{
        ImageView gambar;
        TextView nama, merk, harga;
        Button wishlist, detail;
        ConstraintLayout constraintLayout;

        public KeyboardHolder(@NonNull View itemView) {
            super(itemView);

            gambar = itemView.findViewById(R.id.poster_image);
            nama = itemView.findViewById(R.id.textViewNama);
            merk = itemView.findViewById(R.id.textViewMerk);
            harga = itemView.findViewById(R.id.textViewHarga);
            wishlist = itemView.findViewById(R.id.btn_wishlist);
            detail = itemView.findViewById(R.id.btn_detail);
        }
    }
}
