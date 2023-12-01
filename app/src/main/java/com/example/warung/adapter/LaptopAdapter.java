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
import com.example.warung.activity.detail.DetailLaptop;
import com.example.warung.model.Laptop;

import java.util.List;

public class LaptopAdapter extends RecyclerView.Adapter<LaptopAdapter.LaptopHolder> {
    public Context context;
    private List<Laptop> laptopList;
    public LaptopAdapter(Context context , List<Laptop> laptops){
        this.context = context;
        laptopList = laptops;
    }
    @NonNull
    @Override
    public LaptopHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_view, parent,false);
        return new LaptopHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LaptopHolder holder, int position) {

        Laptop laptop = laptopList.get(position);
        holder.nama.setText(laptop.getNama().toString());
        holder.merk.setText(laptop.getMerk().toString());
        holder.harga.setText(laptop.getHarga().toString());
        Glide.with(context).load(laptop.getGambar()).into(holder.gambar);

        holder.wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Added to wishlist: " + laptop.getNama(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailLaptop.class);

                Bundle bundle =  new Bundle();
                bundle.putString("nama",  laptop.getNama());
                bundle.putString("merk",  laptop.getMerk());
                bundle.putString("harga",  laptop.getHarga());
                bundle.putString("gambar", laptop.getGambar());
                bundle.putString("gambar2",  laptop.getGambar2());
                bundle.putString("processor",  laptop.getProcessor());
                bundle.putString("gpu",  laptop.getGpu());
                bundle.putString("os",  laptop.getOs());
                bundle.putString("ram",  laptop.getRam());
                bundle.putString("storage",  laptop.getStorage());
                bundle.putString("display",  laptop.getDisplay());

                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return laptopList.size();
    }

    public class LaptopHolder extends RecyclerView.ViewHolder{
        ImageView gambar;
        TextView nama, merk, harga;
        Button wishlist, detail;
        ConstraintLayout constraintLayout;

        public LaptopHolder(@NonNull View itemView) {
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
