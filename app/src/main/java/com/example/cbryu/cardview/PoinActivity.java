package com.example.cbryu.cardview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PoinActivity extends AppCompatActivity {
    int poinAkhir,nilaiscore;
    String hasil, hasilAkhir;
    TextView txtNilai, txtJawabanBenar, txtText,txtNilaiScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poin);
        Intent main = getIntent();
        poinAkhir   = main.getExtras().getInt("score");
        nilaiscore   = main.getExtras().getInt("nilaiscore");
        hasil       = main.getExtras().getString("hAkhir");
        txtNilai    = (TextView) findViewById(R.id.txtscore);
        txtNilai.setText(Integer.toString(poinAkhir));
        txtNilaiScore    = (TextView) findViewById(R.id.txtnilai);
        txtNilaiScore.setText(Integer.toString(nilaiscore));
        txtText     = (TextView) findViewById(R.id.text);
        txtText.setVisibility(View.GONE);
        txtJawabanBenar = (TextView) findViewById(R.id.textbenar);
        hasilAkhir  = "Hasil : \n"+hasil;
        txtJawabanBenar.setText(hasilAkhir);
    }

    public void selesai(View view){
        Intent back=new Intent(this,SoalActivity.class);
        startActivity(back);


    }


    @Override
    public void onBackPressed() {
        finish();
    }


}
