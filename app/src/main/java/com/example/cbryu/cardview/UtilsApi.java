package com.example.cbryu.cardview;

public class UtilsApi {

    public static final String BASE_URL_API="http://192.168.100.205/mhs/";
    public static ApiInterface getAPIService(){
        return ApiClient.getClient(BASE_URL_API).create(ApiInterface.class);
    }

}
