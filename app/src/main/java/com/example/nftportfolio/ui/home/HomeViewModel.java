package com.example.nftportfolio.ui.home;

import androidx.lifecycle.LiveData;

import com.example.nftportfolio.model.NFT;

import java.util.ArrayList;

public interface HomeViewModel {
    void refresh();
    void sort();
    void setSelected(NFT nft);
    }
