package com.example.nftportfolio.model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.nftportfolio.Webservices.NFTApi;
import com.example.nftportfolio.Webservices.NFTResponse;
import com.example.nftportfolio.Webservices.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class NFTRepository {
    private static NFTRepository instance;
    private final MutableLiveData<NFT> currNFT;

    private NFTRepository(){
         currNFT = new MutableLiveData<>();
    }

    public static synchronized NFTRepository getInstance(){
        if(instance == null){
            instance = new NFTRepository();
        }
        return instance;
    }

    public LiveData<NFT> getNFTs(){
        return currNFT;
    }

    public void fetchNFTs(String addr){
        NFTApi nftApi = ServiceGenerator.getNftApi();
        Call<NFTResponse> call = nftApi.getNFT(addr);
        call.enqueue(new Callback<NFTResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<NFTResponse> call, Response<NFTResponse> response){
                if(response.isSuccessful()){
                    currNFT.setValue(response.body().getNFT());
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<NFTResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }
}
