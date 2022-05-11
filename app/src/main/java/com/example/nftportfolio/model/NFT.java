package com.example.nftportfolio.model;

public class NFT {
    private String token;
    private String url;
    private String addr;
    private String img;
    private String name;

    private int iconId;

    public NFT(String name, int icon) {
        this.name = name;
        iconId = icon;
    }

    public String getName(){
        return name;
    }

    public int getIconId(){
        return iconId;
    }
}
