package com.example.cbryu.cardview;

import com.google.gson.annotations.SerializedName;

public class Wisata {
    @SerializedName("idwisata") private  String Idwisata;
    @SerializedName("namawisata") private  String Namawisata;
    @SerializedName("tempatwisata") private  String Tempatwisata;
    @SerializedName("deskripsi") private  String Deskripsi;
    @SerializedName("harga") private  String Harga;
@SerializedName("value") private String Value;
    @SerializedName("message") private String Message;

    public String getValue() {
        return Value;
    }

    public String getMessage() {
        return Message;
    }

    public String getIdwisata() {
        return Idwisata;
    }

    public void setIdwisata(String idwisata) {
        Idwisata = idwisata;
    }

    public String getNamawisata() {
        return Namawisata;
    }

    public void setNamawisata(String namawisata) {
        Namawisata = namawisata;
    }

    public String getTempatwisata() {
        return Tempatwisata;
    }

    public void setTempatwisata(String tempatwisata) {
        Tempatwisata = tempatwisata;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        Deskripsi = deskripsi;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }
}
