package com.example.nftportfolio.ui.collection;

import android.app.Activity;

import java.util.ArrayList;

public interface CollectionViewModel {
    void sendSettings(String nickname, String wallet);
    void signOut(Activity ac);
    ArrayList getUserData();
}
