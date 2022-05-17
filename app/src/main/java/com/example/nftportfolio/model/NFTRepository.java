package com.example.nftportfolio.model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.nftportfolio.Webservices.NFTApi;
import com.example.nftportfolio.Webservices.NFTResponse;
import com.example.nftportfolio.Webservices.NFTStatsResponse;
import com.example.nftportfolio.Webservices.ServiceGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class NFTRepository {
    private static NFTRepository instance;
    private final MutableLiveData<ArrayList<NFT>> listOfNFTs;
    private MutableLiveData<Double> walletWorth;

    private NFTRepository(){
         listOfNFTs = new MutableLiveData<>();
         walletWorth = new MutableLiveData<>();
         walletWorth.setValue(0.0);
    }

    public static synchronized NFTRepository getInstance(){
        if(instance == null){
            instance = new NFTRepository();
        }
        return instance;
    }

    public LiveData<ArrayList<NFT>> getListNFTs(){
        return listOfNFTs;
    }

    public void fetchNFTs(String addr){
        NFTApi nftApi = ServiceGenerator.getNftApi();
        Call<NFTResponse> call = nftApi.getNFT(addr);
        call.enqueue(new Callback<NFTResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<NFTResponse> call, Response<NFTResponse> response){
                System.out.println("LOG: "+response.raw());
                if(response.isSuccessful()){
                    listOfNFTs.setValue(response.body().getNFT());

                    for (NFT i: listOfNFTs.getValue()) {
                        fetchStats(i);
                    }
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<NFTResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }

    public void fetchStats(NFT nft){
        NFTApi nftApi = ServiceGenerator.getNftApi();
        Call<NFTStatsResponse> call = nftApi.getStats(nft.getCollection().getSlug());
        call.enqueue(new Callback<NFTStatsResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<NFTStatsResponse> call, Response<NFTStatsResponse> response){
                System.out.println("LOG: "+response.raw());
                if(response.isSuccessful()){
                    nft.setCollectionStats(response.body().getStats());
                    walletWorth.setValue(walletWorth.getValue()+response.body().getStats().getFloor_price());
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<NFTStatsResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }

    public void clearData(){
        walletWorth.setValue(0.0);
        listOfNFTs.setValue(new ArrayList<NFT>());
    }

    public void sortList(){
        Collections.sort(listOfNFTs.getValue(), new Comparator<NFT>() {
        public int compare(NFT n1, NFT n2){
            if(n1.getCollection().getFloor_price() == n2.getCollection().getFloor_price())
                return 0;
            return n1.getCollection().getFloor_price() > n2.getCollection().getFloor_price() ? -1 : 1;
        }
        });

    }

    public LiveData<Double> getWalletWorth(){
        return walletWorth;
    }
}
