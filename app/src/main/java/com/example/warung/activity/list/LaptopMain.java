package com.example.warung.activity.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.warung.R;
import com.example.warung.adapter.LaptopAdapter;
import com.example.warung.model.Laptop;
import com.example.warung.volley.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LaptopMain extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private List<Laptop> laptopList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();

        laptopList = new ArrayList<>();
        fetchLaptop();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("List Laptop");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void fetchLaptop() {
        String url="https://gist.githubusercontent.com/opakpakri/b176b5824ae2ff7e8baed7fb978a6f89/raw/43cac9c71a2180dc3b1fff9e5208eb14037173c6/laptop.json";

        JsonArrayRequest jsonArrayRequest =  new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0 ; i < response.length() ; i ++ ){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String nama = jsonObject.getString("nama");
                        String merk = jsonObject.getString("merk");
                        String harga = jsonObject.getString("harga");
                        String gambar = jsonObject.getString("gambar");
                        String gambar2 = jsonObject.getString("gambar2");
                        String processor = jsonObject.getString("processor");
                        String gpu = jsonObject.getString("gpu");
                        String os = jsonObject.getString("os");
                        String ram = jsonObject.getString("ram");
                        String storage = jsonObject.getString("storage");
                        String display = jsonObject.getString("display");

                        Laptop laptop = new Laptop(nama, merk, harga, gambar,gambar2,processor,gpu,os,ram,storage,display);
                        laptopList.add(laptop);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    LaptopAdapter adapter = new LaptopAdapter(LaptopMain.this , laptopList);

                    recyclerView.setAdapter(adapter);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LaptopMain.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonArrayRequest);
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