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
import com.example.warung.adapter.KeyboardAdapter;
import com.example.warung.adapter.LaptopAdapter;
import com.example.warung.model.Keyboard;
import com.example.warung.model.Laptop;
import com.example.warung.volley.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class KeyboardMain extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private List<Keyboard> keyboardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();

        keyboardList = new ArrayList<>();
        fetchKeyboard();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("List Laptop");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void fetchKeyboard() {
        String url="https://gist.githubusercontent.com/opakpakri/d4cb269eb7b1cbf791d29e6b8519fe36/raw/78714b8a6775c3723ad29c7286d7d2e249975646/keyboard.json";

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
                        String jumlahtombol = jsonObject.getString("jumlah_tombol");
                        String konektivitas = jsonObject.getString("konektivitas");
                        String kompatibilitas = jsonObject.getString("kompatibilitas");
                        String ukuran = jsonObject.getString("ukuran");

                        Keyboard keyboard = new Keyboard(nama, merk, harga, gambar,gambar2,jumlahtombol,konektivitas,kompatibilitas,ukuran);
                        keyboardList.add(keyboard);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    KeyboardAdapter adapter = new KeyboardAdapter(KeyboardMain.this , keyboardList);

                    recyclerView.setAdapter(adapter);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(KeyboardMain.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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