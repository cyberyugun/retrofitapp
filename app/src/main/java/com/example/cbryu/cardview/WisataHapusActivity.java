package com.example.cbryu.cardview;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.http.HttpResponseCache;
import android.os.Build;
import android.os.StrictMode;
import android.provider.Settings;
import android.renderscript.Sampler.Value;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WisataHapusActivity extends AppCompatActivity {
//String idwisata;
//InputStream is=null;
//String result=null,line=null;
//int code;

//ConnectivityManager conMgr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata_hapus);
//if (Build.VERSION.SDK_INT>9){
//    StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
//    StrictMode.setThreadPolicy(policy);
//}
//conMgr=(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        {
//            if (conMgr.getActiveNetworkInfo()!=null
//                    && conMgr.getActiveNetworkInfo().isAvailable()
//                    && conMgr.getActiveNetworkInfo().isConnected()){
//
//            }else{
//                Toast.makeText(getApplicationContext(),"No Internet Connection",
//                        Toast.LENGTH_SHORT).show();
//            }
//        }
//    idwisata=getIntent().getStringExtra("idwisata");
//    hapusdata();
    }

//    private void hapusdata() {
//        ArrayList<NameValuePair> nameValuePairs=new ArrayList<>();
//        nameValuePairs.add(new BasicNameValuePair("idwisata",idwisata));
//        try {
//            HttpClient httpClient=new DefaultHttpClient();
//            HttpPost httpPost=new HttpPost("http://192.168.100.205/mhs/hapuswisata.php");
//            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//            HttpResponse response=httpClient.execute(httpPost);
//            HttpEntity entity=response.getEntity();
//            is=entity.getContent();
//            Log.e("pass 1","koneksi sukses");
//        }catch (Exception e){
//Log.e("Fall 1",e.toString());
//Toast.makeText(getApplicationContext(),"invalid ip or domain",Toast.LENGTH_LONG).show();
//        }
//        try {
//            BufferedReader reader=new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
//            StringBuilder sb = new StringBuilder();
//            while ((line=reader.readLine())!=null){
//                sb.append(line+"\n");
//            }
//is.close();
//            result=sb.toString();
//            Log.e("Pass 2","Koneksi Sukses");
//        }catch (Exception e){
//            Log.e("Fail 1",e.toString());
//        }
//        JSONObject json_data=null;
//        try {
//            json_data=new JSONObject(result);
//        }catch (JSONException e){
//            e.printStackTrace();
//        }
//
//        try {
//            code=json_data.getInt("value");
//        }catch (JSONException e){
//            e.printStackTrace();
//        }
//
//        if (code==1){
//            Toast.makeText(getBaseContext(),"Data Dihapus",Toast.LENGTH_LONG).show();
//            Intent i=new Intent(WisataHapusActivity.this,WisataViewActivity.class);
//            startActivity(i);
//            finish();
//        }
//        else {
//            Toast.makeText(getBaseContext(),"gagal",Toast.LENGTH_LONG).show();
//        }


//    ApiInterface    apiInterface=Apiclientd.getClientd().create(ApiInterface.class);
//        Call<Value> call=apiInterface.gethapuswisata(idwisata);
//        call.enqueue(new Callback<Value>() {
//            @Override
//            public void onResponse(Call<Value> call, Response<Value> response) {
//                String value= response.body().;
//                String message=response.body().toString();
//                if (value.equals("1")){
//                    Toast.makeText(WisataHapusActivity.this,message,Toast.LENGTH_SHORT).show();
//                    finish();
//                }else {
//                    Toast.makeText(WisataHapusActivity.this,message,Toast.LENGTH_SHORT).show();
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Value> call, Throwable t) {
//t.printStackTrace();
//Toast.makeText(WisataHapusActivity.this,"Jaringan Error",Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }
}
