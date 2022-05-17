package com.example.nftportfolio.model;

import java.util.ArrayList;

public class NFT {
    private int id;
    private String token_id;
    private String permalink;
    private String description;
    private String image_url;
    private String name;

    private Collection collection;
    private ArrayList<Traits> traits;

    private int iconId;

    public NFT(String name, int icon) {
        this.name = name;
        iconId = icon;

        collection = new Collection();
    }

    public NFT() {
    }

    public ArrayList<Traits> getTraits() {
        return traits;
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

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
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
