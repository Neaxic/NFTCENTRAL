package com.example.nftportfolio.ui.settings;

import android.app.Activity;
import android.widget.EditText;

import java.util.ArrayList;

public interface SettingsViewModel {
    void sendSettings(String nickname, String wallet);
    void signOut(Activity ac);
    void getUserData(EditText nick, EditText wallet);
}
