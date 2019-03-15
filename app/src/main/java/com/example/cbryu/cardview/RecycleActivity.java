package com.example.cbryu.cardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

import java.util.ArrayList;

public class RecycleActivity extends AppCompatActivity {

    RecyclerView recy;
    Adapterss adapterss;
    ArrayList<Modelss> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        recy=findViewById(R.id.rec);
        recy.setLayoutManager(new LinearLayoutManager(this));
        adapterss=new Adapterss(RecycleActivity.this);
populate();
    }
    private  void populate(){

        for (int iter=1;iter<=10;iter++){
            Modelss modelss=new Modelss();
            modelss.setNmss("terserah"+iter);
            list.add(modelss);
        }
        adapterss.setlist(list);
        recy.setAdapter(adapterss);
    }
}
