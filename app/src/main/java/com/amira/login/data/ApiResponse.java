package com.amira.login.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiResponse {

    public static final String baseUrl="http://166.62.117.167/BMW_GKL/mobileApp/";
    public static Retrofit retrofit=null;

    public static Retrofit getApiData(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl( baseUrl )
                    .addConverterFactory( GsonConverterFactory.create() )
                    .build();
        }
        return retrofit;
    }


}
