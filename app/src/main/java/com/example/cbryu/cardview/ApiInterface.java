package com.example.cbryu.cardview;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    //fungsi memanggil API login.php
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> loginRequest(@Field("username") String username,
                                    @Field("password") String password);

    // Fungsi ini untuk memanggil API register.php
    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseBody> registerRequest(@Field("nama") String nama,
                                       @Field("username") String username,
                                       @Field("password") String password);

    // Fungsi ini untuk memanggil API register.php
    @FormUrlEncoded
    @POST("inputwisata.php")
    Call<ResponseBody> requestSaveWisata(@Field("namawisata") String namawisata,
                                       @Field("tempatwisata") String tempatwisata,
                                       @Field("deskripsi") String deskripsi,
                                          @Field("harga") String harga );

}