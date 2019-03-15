package com.example.cbryu.cardview;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
EditText nmwisata,tmptwisata,deswis,hrgwisata;
Button savewisata;
    Context mContex;

ApiInterface mApiServic;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View ve= inflater.inflate(R.layout.fragment_home,container,false);
        mApiServic = UtilsApi.getAPIService();
        nmwisata=ve.findViewById(R.id.edtnmwisata);
        tmptwisata=ve.findViewById(R.id.edttmptwis);
        deswis=ve.findViewById(R.id.edtdeswis);
        hrgwisata=ve.findViewById(R.id.edthrgwisata);
        savewisata=ve.findViewById(R.id.btnsavewisata);
        initComponents();

        return ve;
    }

    private void initComponents() {

       savewisata.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               requestSaveWisata();
           }








           private void requestSaveWisata() {

               mApiServic.requestSaveWisata(nmwisata.getText().toString(),
                       tmptwisata.getText().toString(),
                       deswis.getText().toString(),
                       hrgwisata.getText().toString())
                       .enqueue(new Callback<ResponseBody>() {
                           @Override
                           public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                               if (response.isSuccessful()){
                                   Log.i("debug", "onResponse: BERHASIL");
                                   try {
                                       JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                       if (jsonRESULTS.getString("error").equals("false")){
                                           Toast.makeText(getContext(), "BERHASIL Menyimpan Data Wisata", Toast.LENGTH_SHORT).show();

                                       }
                                       else {
                                           String error_message = jsonRESULTS.getString("error_msg");
                                           Toast.makeText(getContext(), error_message, Toast.LENGTH_SHORT).show();
                                       }
                                   } catch (JSONException e) {
                                       e.printStackTrace();
                                   } catch (IOException e) {
                                       e.printStackTrace();
                                   }
                               } else {
                                   Log.i("debug", "onResponse: GA BERHASIL");
                               }
                           }

                           @Override
                           public void onFailure(Call<ResponseBody> call, Throwable t) {
                               Log.e("debug", "onFailure: ERROR > " + t.getMessage());
                               Toast.makeText(getContext(), "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
                           }
                       });

           }
       });








    }
}
