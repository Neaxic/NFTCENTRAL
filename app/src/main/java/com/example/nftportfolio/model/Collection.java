package com.example.nftportfolio.model;

public class Collection {
    //I det det er en liste fra api, og der nok i fremtiden skal mere data heri
    private String slug;

    public Collection(){

    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
