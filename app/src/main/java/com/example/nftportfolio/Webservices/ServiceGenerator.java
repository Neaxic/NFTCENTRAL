package com.example.nftportfolio.Webservices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static NFTApi nftApi;

    public static NFTApi getNftApi(){
        if(nftApi == null){
            nftApi = new Retrofit.Builder()
                    .baseUrl("https://api.opensea.io/api/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(NFTApi.class);
        }
        return nftApi;
    }
}
