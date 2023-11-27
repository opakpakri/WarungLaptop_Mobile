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
import com.example.warung.adapter.HeadsetAdapter;
import com.example.warung.adapter.KeyboardAdapter;
import com.example.warung.adapter.LaptopAdapter;
import com.example.warung.model.Headset;
import com.example.warung.model.Keyboard;
import com.example.warung.model.Laptop;
import com.example.warung.volley.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HeadsetMain extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private List<Headset> headsetList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headset_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();

        headsetList = new ArrayList<>();
        fetchHeadset();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("List Headset");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void fetchHeadset() {
        String url="https://gist.githubusercontent.com/opakpakri/b7ed338b295025f03b7fff97fae7128b/raw/d37515989b459bc4f8cf02d8b3aff433d49790b5/headset.json";

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
                        String cablelength = jsonObject.getString("cable_length");
                        String audiojack = jsonObject.getString("audio_jack");
                        String speakersize = jsonObject.getString("speaker_size");
                        String color = jsonObject.getString("color");

                        Headset headset = new Headset(nama, merk, harga, gambar,gambar2,cablelength,audiojack,speakersize,color);
                        headsetList.add(headset);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    HeadsetAdapter adapter = new HeadsetAdapter(HeadsetMain.this , headsetList);

                    recyclerView.setAdapter(adapter);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HeadsetMain.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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