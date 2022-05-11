package com.example.nftportfolio.ui.settings;

import android.app.Activity;

import java.util.ArrayList;

public interface SettingsViewModel {
    void sendSettings(String nickname, String wallet);
    void signOut(Activity ac);
    ArrayList getUserData();
}
