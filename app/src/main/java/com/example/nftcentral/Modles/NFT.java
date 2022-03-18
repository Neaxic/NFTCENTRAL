package com.example.nftcentral.Modles;

public class NFT {
    private String contract;
    private String token;
    private Boolean isOwner;
    private String owner;
    private String ipfs;
    private String name;
    private String description;
    private String fileURL;

    //Financial
    private double floorPrice;

    //Extra stuff
    private String chain;
    private String type;



    public NFT(){
    }

    public NFT(String contract, String owner, boolean isOwner){
        this.contract = contract;
        this.owner = owner;
        this.isOwner = isOwner;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getOwner() {
        return isOwner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getIpfs() {
        return ipfs;
    }

    public void setIpfs(String ipfs) {
        this.ipfs = ipfs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }

    public void setOwner(Boolean owner) {
        isOwner = owner;
    }
}
