package com.example.cbryu.cardview;

import com.google.gson.annotations.SerializedName;

import okhttp3.Response;

public class User {
    @SerializedName("response")
    private String Response;

    @SerializedName("nama")
    private String Nama;

    public String getResponse() {
        return Response;
    }

    public String getNama() {
        return Nama;
    }

}
