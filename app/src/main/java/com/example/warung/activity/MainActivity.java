package com.example.warung.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.warung.Domain.PopularDomain;
import com.example.warung.R;
import com.example.warung.activity.list.HeadsetMain;
import com.example.warung.activity.list.KeyboardMain;
import com.example.warung.activity.list.LaptopMain;
import com.example.warung.activity.list.MouseMain;
import com.example.warung.adapter.PopularAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterPupolar;
    private RecyclerView recyclerViewPupolar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnLaptop = findViewById(R.id.btn_laptop);
        ImageButton btnKeyboard = findViewById(R.id.btn_keyboard);
        ImageButton btnMouse = findViewById(R.id.btn_mouse);
        ImageButton btnHeadset = findViewById(R.id.btn_headset);
        ImageButton btnProfile = findViewById(R.id.profile_btn);
        ImageButton btnCart = findViewById(R.id.cart_btn);
        ImageButton btnWishlist = findViewById(R.id.wishlist_btn);

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, profile_main.class);
                startActivity(intent);
            }
        });

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Cart.class);
                startActivity(intent);
            }
        });

        btnWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Wishlist.class);
                startActivity(intent);
            }
        });

        btnLaptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LaptopMain.class);
                startActivity(intent);
            }
        });

        btnMouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MouseMain.class);
                startActivity(intent);
            }
        });

        btnKeyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, KeyboardMain.class);
                startActivity(intent);
            }
        });

        btnHeadset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HeadsetMain.class);
                startActivity(intent);
            }
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initRecyclerView();
    }
    private void initRecyclerView() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("Asus ROG Strix SCAR 18GB", "", "pop1",22,5,69249000));
        items.add(new PopularDomain("Asus ROG Zephyrus M16 GU6", "", "pop2",25,4,41749000));
        items.add(new PopularDomain("MSI Katana 15 B13VFK 9S7", "", "pop3",7,4,24499000));
        items.add(new PopularDomain("Asus TUF Gaming F15 FX507", "", "pop4",16,3,22429000));
        recyclerViewPupolar = findViewById(R.id.view1);
        recyclerViewPupolar.setLayoutManager(new LinearLayoutManager( this, LinearLayoutManager. HORIZONTAL,  false));
        adapterPupolar = new PopularAdapter(items);
        recyclerViewPupolar.setAdapter(adapterPupolar);
    }
}