package com.example.nftportfolio.model;

public class Traits {
    private String trait_type;
    private String value;
    private int trait_count;

    public Traits(){

    }

    public int getTrait_count() {
        return trait_count;
    }

    public String getValue() {
        return value;
    }

    public String getTrait_type() {
        return trait_type;
    }
}
