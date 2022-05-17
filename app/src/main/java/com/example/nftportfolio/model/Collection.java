package com.example.nftportfolio.model;

public class Collection {
    private String slug;
    private String name;
    private String description;

    private String image_url;
    private String banner_image_url;

    private String created_date;

    private NFTStats stats;

    public Collection(){
        stats = new NFTStats();
    }

    public void setStats(NFTStats stats) {
        this.stats = stats;
    }

    public NFTStats getStats() {
        return stats;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public String getBanner_image_url() {
        return banner_image_url;
    }

    public String getCreated_date() {
        return created_date;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getName() {
        return name;
    }
}
