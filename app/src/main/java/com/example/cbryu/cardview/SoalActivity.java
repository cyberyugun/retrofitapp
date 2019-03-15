package com.example.cbryu.cardview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class SoalActivity extends AppCompatActivity {

    public int i1, i2, i3, i4, i5, jumlah;
    public TextView soal1, soal2, soal3, soal4, soal5;
    public Spinner jaw1, jaw2, jaw3, jaw4, jaw5;
    public Button hitungNilai;
    public static int score = 0,nilaiscore,scoree;
    public String jawaban, jawabanHasil, kunciJawaban;
    public static String jawabanH="";

    String[]jawabanPertanyaan1 = {"Pilih jawaban",
            "A. Bahan makanan yang bergizi",
            "B. Bahan makanan yang harganya mahal",
            "C. Bahan makaann yang banyak mengandung vitamin saja",
            "D. bahan makanan yang murah"};
    String[]jawabanPertanyaan2 = {"Pilih jawaban",
            "A. Sate, burger, tahu",
            "B. Ikan asin, bandeng, tempe",
            "C. Tempe, ikan, sayur sop",
            "D. Sayur sop, tumis kangkung, sate"};
    String[]jawabanPertanyaan3 = {"Pilih jawaban",
            "A. Sakit mag",
            "B. Sakit hati",
            "C. Sakit perut",
            "D. Sakit gigi"};
    String[]jawabanPertanyaan4 = {"Pilih jawaban",
            "A. di makan",
            "B. di potong-potong",
            "C. di masak",
            "D. di sayur"};
    String[]jawabanPertanyaan5 = {"Pilih jawaban",
            "A. wajan",
            "B. panci",
            "C. kuali",
            "D. dandang"};


    int[]kunci={1,3,3,2,4};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal);

        soal1 = (TextView)findViewById(R.id.soal1);
        soal2 = (TextView)findViewById(R.id.soal2);
        soal3 = (TextView)findViewById(R.id.soal3);
        soal4 = (TextView)findViewById(R.id.soal4);
        soal5 = (TextView)findViewById(R.id.soal5);


        jaw1=(Spinner)findViewById(R.id.pilsoal1);
        jaw2=(Spinner)findViewById(R.id.pilsoal2);
        jaw3=(Spinner)findViewById(R.id.pilsoal3);
        jaw4=(Spinner)findViewById(R.id.pilsoal4);
        jaw5=(Spinner)findViewById(R.id.pilsoal5);


        hitungNilai=(Button)findViewById(R.id.btnhitung);

        soal1.setText("1. Yang dimaksud dengan bahan makanan yang sehat adalah ... ? ");
        soal2.setText("2. Daftar makanan di bawah ini yang merupakan makanan yang sehat yaitu ... ");
        soal3.setText("3. Apa yang akan terjadi jika kita mengkonsumsi bahan makanan yang kotor ... ");
        soal4.setText("4. Cara mencuci sayur yang baik sebelum dibuat makanan adalah di cuci sebelum .... ");
        soal5.setText("5. Apabila kita ingin menanak nasi alat yang digunakan adalah .... ");


        ArrayAdapter<String> jawab1=new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, jawabanPertanyaan1);

        jawab1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jaw1.setAdapter(jawab1);
        jaw1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                i1 = jaw1.getSelectedItemPosition();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        ArrayAdapter<String> jawab2=new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, jawabanPertanyaan2);

        jawab2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jaw2.setAdapter(jawab2);
        jaw2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                i2 = jaw2.getSelectedItemPosition();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        ArrayAdapter<String> jawab3=new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, jawabanPertanyaan3);

        jawab3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jaw3.setAdapter(jawab3);
        jaw3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                i3 = jaw3.getSelectedItemPosition();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        ArrayAdapter<String> jawab4=new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, jawabanPertanyaan4);

        jawab4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jaw4.setAdapter(jawab4);
        jaw4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                i4 = jaw4.getSelectedItemPosition();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        ArrayAdapter<String> jawab5=new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, jawabanPertanyaan5);

        jawab5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jaw5.setAdapter(jawab5);
        jaw5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                i5 = jaw5.getSelectedItemPosition();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });





    }


    public void hitungpoin(View view){
        int indexJwb[]={i1,i2,i3,i4,i5};
        int noSoal;
        for (int i=0; i<kunci.length;i++){
            if (indexJwb[i]==1){
                jawaban="A";
            }else if (indexJwb[i]==2){
                jawaban="B";
            }else if (indexJwb[i]==3){
                jawaban="C";
            }else if (indexJwb[i]==4){
                jawaban="D";
            }else {
                jawaban="kosong";
            }
            if (kunci[i]==1){
                kunciJawaban="A";
            }else if (kunci[i]==2){
                kunciJawaban="B";
            }else if (kunci[i]==3){
                kunciJawaban="C";
            }else if (kunci[i]==4){
                kunciJawaban="D";
            }else {
                kunciJawaban="Tidak ada jawaban yang dipilih";
            }

            if (indexJwb[i]== kunci[i]){
                score=score+1 ;
                nilaiscore=score*20;
                jawabanHasil=jawaban+"==(Jawaban User Benar)=>"+kunciJawaban+"\n";
            }else{
                jawabanHasil=jawaban+"==(Jawaban User Salah)=>"+kunciJawaban+"\n";
            }
            noSoal=i+1;
            jawabanH=jawabanH+Integer.toString(noSoal)+". "+jawabanHasil;
        }
        Intent nilaiSoal = new Intent(this, PoinActivity.class);
        nilaiSoal.putExtra("score", score);
        nilaiSoal.putExtra("nilaiscore", nilaiscore);
        nilaiSoal.putExtra("hAkhir", jawabanH);
        startActivity(nilaiSoal);


    }
    @Override
    public void onBackPressed(){
        finish();

    }

}
