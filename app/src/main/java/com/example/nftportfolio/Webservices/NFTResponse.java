package com.example.nftportfolio.Webservices;

import com.example.nftportfolio.model.NFT;

import java.util.ArrayList;

public class NFTResponse {
    //Får listen af NFT'er inde i
    private ArrayList<NFT> assets;

    public ArrayList getNFT(){
        return assets;
    }

}
