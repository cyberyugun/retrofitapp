package com.example.cbryu.cardview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
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

public class UpdateDataActivity extends AppCompatActivity {
    EditText nmwisata,tmptwisata,deswis,hrgwisata;
    Button savewisata;
    Context mContex;

    ApiInterface mApiServic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);
        mContex=this;
        initComponents();

    }

    private void initComponents() {

        mApiServic = UtilsApi.getAPIService();
        nmwisata=findViewById(R.id.edtnmwisataa);
        tmptwisata=findViewById(R.id.edttmptwisa);
        deswis=findViewById(R.id.edtdeswisa);
        hrgwisata=findViewById(R.id.edthrgwisataa);
        savewisata=findViewById(R.id.btnsavewisataa);
        Intent data=getIntent();
        final  String iddata=data.getStringExtra("idwisata");
        if (iddata !=null ){
            savewisata.setVisibility(View.VISIBLE);
            nmwisata.setText(data.getStringExtra("namawisata"));
            tmptwisata.setText(data.getStringExtra("tempatwisata"));
            deswis.setText(data.getStringExtra("deskripsi"));
            hrgwisata.setText(data.getStringExtra("harga"));

        }

        savewisata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestSaveWisata();
            }







//UPDATE DATA
            private void requestSaveWisata() {


                //                nmwisata.setText(data.getStringExtra("namawisata"));
//                tmptwisata.setText(data.getStringExtra("tempatwisata"));
//                deswis.setText(data.getStringExtra("deskripsi"));
//                hrgwisata.setText(data.getStringExtra("harga"));

                Call<ResponseBody> call=mApiServic.UbahWisata(
        iddata,
                        nmwisata.getText().toString(),
                        tmptwisata.getText().toString(),
                        deswis.getText().toString(),
                        hrgwisata.getText().toString()
                        );

                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            Log.i("debug", "onResponse: BERHASIL");
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                if (jsonRESULTS.getString("value").equals("1")){
                                    Toast.makeText(mContex, "BERHASIL Mengubah Data Wisata", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(mContex,WisataViewActivity.class));


                                }
                                else {
                                    String error_message = jsonRESULTS.getString("message");
                                    Toast.makeText(mContex, error_message, Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(mContex, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });








    }


    //Delete Data

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_delete,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Peringatan");
        builder.setMessage("Apakah Anda yakin akan menghapus data ini?").setCancelable(false)
                .setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent data =getIntent();
                        final String iddata=data.getStringExtra("idwisata");
                        Call<ResponseBody> call=mApiServic.deletewisata(iddata);
                        call.enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                if (response.isSuccessful()){
                                    Log.i("debug", "onResponse: BERHASIL");
                                    try {
                                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                        if (jsonRESULTS.getString("value").equals("1")){
                                            Toast.makeText(mContex, "BERHASIL Menghapus Data Wisata", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(mContex,WisataViewActivity.class));

                                        }
                                        else {
                                            String error_message = jsonRESULTS.getString("message");
                                            Toast.makeText(mContex, error_message, Toast.LENGTH_SHORT).show();
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
Log.e("debug","onFailure: ERROR> "+ t.getMessage());
Toast.makeText(mContex,"Koneksi Internet Bermasalah",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                })
                .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
        return super.onOptionsItemSelected(item);
    }
}
