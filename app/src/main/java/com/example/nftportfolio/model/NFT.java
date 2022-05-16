package com.example.nftportfolio.model;

import java.util.ArrayList;

public class NFT {
    private int id;
    private String token_id;
    private String permalink;
    private String description;
    private String image_url;
    private String name;
    private NFTStats collection;

    private int iconId;

    public NFT(String name, int icon) {
        this.name = name;
        iconId = icon;
    }
    public NFT() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public String getImg() {
        return image_url;
    }

    public NFTStats getCollection() {
        return collection;
    }

    public void setCollectionStats(NFTStats collection) {
        this.collection = collection;
    }

    public int getIconId() {
        return iconId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.image_url = img;
    }

    public String getToken_id() {
        return token_id;
    }
    public String getPermalink() {
        return permalink;
    }
    public String getDescription() {
        return description;
    }
}
