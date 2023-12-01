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
import com.example.warung.adapter.MouseAdapter;
import com.example.warung.model.Mouse;
import com.example.warung.volley.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MouseMain extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private List<Mouse> mouseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mouse_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();

        mouseList = new ArrayList<>();
        fetchMouse();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("List Mouse");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void fetchMouse() {
        String url="https://gist.githubusercontent.com/opakpakri/a4a3bed6fc9bd0ad5b06bfbba1a87d67/raw/823396e94920806f53540d599aa4e8e3d57e5c31/mouse.json";
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
                        String dpi = jsonObject.getString("dpi");
                        String button = jsonObject.getString("button");
                        String sensor = jsonObject.getString("sensor");

                        Mouse mouse = new Mouse(nama, merk, harga, gambar, gambar2, dpi,button,sensor);
                        mouseList.add(mouse);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    MouseAdapter adapter = new MouseAdapter(MouseMain.this , mouseList);

                    recyclerView.setAdapter(adapter);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MouseMain.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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