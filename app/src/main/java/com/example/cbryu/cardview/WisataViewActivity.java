package com.example.cbryu.cardview;


import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.support.v7.widget.SearchView;
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        SearchManager  searchManager=(SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView=(SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName())
        );

        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                fetchwisata(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fetchwisata(newText);
                return false;
            }
        });
        return true;
    }
}
