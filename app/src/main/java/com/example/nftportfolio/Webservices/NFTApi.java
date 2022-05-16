package com.example.nftportfolio.Webservices;

import com.example.nftportfolio.model.NFTStats;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NFTApi {
    @Headers({
        "X-API-KEY: aecdc215545648c6a19ccfc219c3e126"
    })

    @GET("assets/")
    Call<NFTResponse> getNFT(@Query("owner") String name);

    @GET("/collection/{slug}/stats")
    Call<NFTStatsResponse> getStats(@Path("slug") String slug);
}
