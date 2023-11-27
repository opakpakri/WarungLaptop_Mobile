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
import com.example.warung.activity.detail.DetailHeadset;
import com.example.warung.activity.detail.DetailLaptop;
import com.example.warung.model.Headset;
import com.example.warung.model.Keyboard;
import com.example.warung.model.Laptop;

import java.security.Key;
import java.util.List;

public class HeadsetAdapter extends RecyclerView.Adapter<HeadsetAdapter.HeadsetHolder> {
    public Context context;
    private List<Headset> headsetList;
    public HeadsetAdapter(Context context , List<Headset> headsets){
        this.context = context;
        headsetList = headsets;
    }
    @NonNull
    @Override
    public HeadsetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_view, parent,false);
        return new HeadsetHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeadsetHolder holder, int position) {

        Headset headset = headsetList.get(position);
        holder.nama.setText(headset.getNama().toString());
        holder.merk.setText(headset.getMerk().toString());
        holder.harga.setText(headset.getHarga().toString());
        Glide.with(context).load(headset.getGambar()).into(holder.gambar);

        holder.wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Added to wishlist: " + headset.getNama(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailHeadset.class);

                Bundle bundle =  new Bundle();
                bundle.putString("nama",  headset.getNama());
                bundle.putString("merk",  headset.getMerk());
                bundle.putString("harga",  headset.getHarga());
                bundle.putString("gambar", headset.getGambar());
                bundle.putString("gambar2",  headset.getGambar2());
                bundle.putString("cable_length",  headset.getCablelength());
                bundle.putString("audio_jack",  headset.getAudiojack());
                bundle.putString("speaker_size",  headset.getSpeakersize());
                bundle.putString("color",  headset.getColor());

                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return headsetList.size();
    }

    public class HeadsetHolder extends RecyclerView.ViewHolder{
        ImageView gambar;
        TextView nama, merk, harga;
        Button wishlist, detail;
        ConstraintLayout constraintLayout;

        public HeadsetHolder(@NonNull View itemView) {
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
