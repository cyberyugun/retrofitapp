package com.example.cbryu.cardview;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
CardView ca,cb,cc,cd,ce;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    ca=findViewById(R.id.cda);
    ca.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intenta=new Intent(MainActivity.this,BottomNavActivity.class);
            startActivity(intenta);
        }
    });
    cb=findViewById(R.id.cdb);

        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentb=new Intent(MainActivity.this,RecycleActivity.class);
                startActivity(intentb);
            }
        });


        cc=findViewById(R.id.cdc);

        cc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentc=new Intent(MainActivity.this,SoalActivity.class);
                startActivity(intentc);
            }
        });

        cd=findViewById(R.id.cdd);
        cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentd=new Intent(MainActivity.this,WisataViewActivity.class);
                startActivity(intentd);
            }
        });

        ce=findViewById(R.id.cde);
        ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intente=new Intent(MainActivity.this,GalleryActivity.class);
                startActivity(intente);
            }
        });
    }



    @Override
    public void onBackPressed() {
        AlertDialog.Builder menukeluar=new AlertDialog.Builder(MainActivity.this);
        menukeluar.setMessage("Apakah Anda Yakin Keluar?").setCancelable(false)
                .setPositiveButton("YA", new AlertDialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent exit=new Intent(Intent.ACTION_MAIN);
                        exit.addCategory(Intent.CATEGORY_HOME);
                        exit.setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                        startActivity(exit);
                    }
                }).setNegativeButton("Tidak", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog judul=menukeluar.create();
        judul.setTitle("Kluar aplikasi");
        judul.show();

    }

}
