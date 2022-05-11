package com.example.nftportfolio.Webservices;

import com.example.nftportfolio.model.NFT;

public class NFTResponse {
    private int id;
    private String name;

    public NFT getNFT(){
        return new NFT(name, 1);
    }

}
