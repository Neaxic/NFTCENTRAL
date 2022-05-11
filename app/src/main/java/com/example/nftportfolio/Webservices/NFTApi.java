package com.example.nftportfolio.Webservices;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NFTApi {

    @GET("api/v2/pokemon/{name}")
    Call<NFTResponse> getNFT(@Path("name") String name);
}
