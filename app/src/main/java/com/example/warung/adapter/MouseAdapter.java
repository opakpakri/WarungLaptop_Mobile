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
import com.example.warung.activity.detail.DetailMouse;
import com.example.warung.model.Mouse;

import java.util.List;

public class MouseAdapter extends RecyclerView.Adapter<MouseAdapter.MouseHolder> {
    public Context context;
    private List<Mouse> mouseList;
    public MouseAdapter(Context context , List<Mouse> mouses){
        this.context = context;
        mouseList = mouses;
    }
    @NonNull
    @Override
    public MouseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_view, parent,false);
        return new MouseHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MouseHolder holder, int position) {

        Mouse mouse = mouseList.get(position);
        holder.nama.setText(mouse.getNama().toString());
        holder.merk.setText(mouse.getMerk().toString());
        holder.harga.setText(mouse.getHarga().toString());
        Glide.with(context).load(mouse.getGambar()).into(holder.gambar);

        holder.wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Added to wishlist: " + mouse.getNama(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailMouse.class);

                Bundle bundle =  new Bundle();
                bundle.putString("nama",  mouse.getNama());
                bundle.putString("merk",  mouse.getMerk());
                bundle.putString("harga", mouse.getHarga());
                bundle.putString("gambar", mouse.getGambar());
                bundle.putString("gambar2", mouse.getGambar2());
                bundle.putString("dpi", mouse.getDpi());
                bundle.putString("button",  mouse.getButton());
                bundle.putString("sensor",  mouse.getSensor());

                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mouseList.size();
    }

    public class MouseHolder extends RecyclerView.ViewHolder{
        ImageView gambar;
        TextView nama, merk, harga;
        Button wishlist, detail;
        ConstraintLayout constraintLayout;

        public MouseHolder(@NonNull View itemView) {
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

