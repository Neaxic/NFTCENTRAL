package com.example.nftportfolio.model;

public class NFTStats {
    private double count;

    private double floor_price;

    private double one_day_sales;

    private double one_day_average_price;
    private double seven_day_average_price;
    private double thirty_day_average_price;

    private double total_volume;
    private double total_sales;
    private double num_owners;
    private double average_price;

    public NFTStats(){}

    public double getFloor_price() {
        return floor_price;
    }

    public double getAverage_price() {
        return average_price;
    }

    public double getOne_day_average_price() {
        return one_day_average_price;
    }

    public double getSeven_day_average_price() {
        return seven_day_average_price;
    }

    public double getThirty_day_average_price() {
        return thirty_day_average_price;
    }

    public double getTotal_sales() {
        return total_sales;
    }

    public double getTotal_volume() {
        return total_volume;
    }

    public double getCount() {
        return count;
    }

    public double getNum_owners() {
        return num_owners;
    }

    public double getOne_day_sales() {
        return one_day_sales;
    }
}
