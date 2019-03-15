package com.example.cbryu.cardview;


import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WisataViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Wisata> wisatas;
    private Adapter adapter;
    private ApiInterface apiInterface;
    ProgressBar progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata_view);

        progressDialog=findViewById(R.id.progress);
        recyclerView=findViewById(R.id.recycle);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        fetchwisata("");
    }

    private void fetchwisata(String key) {
        apiInterface=Apiclientd.getClientd().create(ApiInterface.class);
        Call<List<Wisata>> call=apiInterface.getwisata(key);
        call.enqueue(new Callback<List<Wisata>>() {
            @Override
            public void onResponse(Call<List<Wisata>> call, Response<List<Wisata>> response) {
                progressDialog.setVisibility(View.GONE);
                wisatas=response.body();
                adapter=new Adapter(wisatas,WisataViewActivity.this);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Wisata>> call, Throwable t) {
                progressDialog.setVisibility(View.GONE);
                Toast.makeText(WisataViewActivity.this,"error on:"+toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
