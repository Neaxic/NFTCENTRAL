package com.example.nftportfolio.ui.NFTStats;

import android.app.Activity;

import java.util.ArrayList;

public interface NFTStatsViewModel {
    void sendSettings(String nickname, String wallet);
    void signOut(Activity ac);
    ArrayList getUserData();
}
