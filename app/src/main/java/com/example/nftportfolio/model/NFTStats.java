package com.example.nftportfolio.model;

public class NFTStats {
    private int num_owners;
    private int count;
    private String slug;
    private double floor_price;
    private int one_day_sales;
    private double total_volume;

    public double getFloor_price() {
        return floor_price;
    }

    public String getSlug() {
        return slug;
    }

    public double getTotal_volume() {
        return total_volume;
    }

    public int getCount() {
        return count;
    }

    public int getNum_owners() {
        return num_owners;
    }

    public int getOne_day_sales() {
        return one_day_sales;
    }
}
