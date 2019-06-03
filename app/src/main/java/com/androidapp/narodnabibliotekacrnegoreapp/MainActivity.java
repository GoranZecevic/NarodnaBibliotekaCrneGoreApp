package com.androidapp.narodnabibliotekacrnegoreapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.androidapp.narodnabibliotekacrnegoreapp.adapters.LanguageAdapter;
import com.androidapp.narodnabibliotekacrnegoreapp.api_urls.ApiUrls;
import com.androidapp.narodnabibliotekacrnegoreapp.models.Languages;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  LanguageAdapter.OnItemClickListener {

    private RecyclerView recycleView;
    private LanguageAdapter adapter;
    private ArrayList<Languages> arrayList;
    private RequestQueue requestQueue;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleView = (RecyclerView) findViewById(R.id.recyclerid);
        recycleView.setHasFixedSize(true);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<>();

        requestQueue = Volley.newRequestQueue(this);
        PARSEDATA();
    }

    public void PARSEDATA() {
        final String URL = ApiUrls.GET_LANGUAGES ;
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("server_response");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject hit = jsonArray.getJSONObject(i);

                                int lang_code =  hit.getInt("SEND_LANGCODE");
                                String lang = hit.getString("SEND_LANG");
                                String lang_short = hit.getString("SEND_LANGSHORT");
                                String lang_three = hit.getString("SEND_LANGTHREE");
                                int active = hit.getInt("SEND_ACTIVE");

                                arrayList.add(new Languages(lang_code, lang, lang_short, lang_three, active));

                            }

                            adapter = new LanguageAdapter(MainActivity.this, arrayList);
                            recycleView.setAdapter(adapter);
                            adapter.setOnItemClickListener(MainActivity.this);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
        requestQueue.add(request);
    }

    @Override
    public void onItemClick(int position) {
        Languages clickedItem = arrayList.get(position);

        String name = clickedItem.getLang();
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }



}
