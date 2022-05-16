package com.example.nftportfolio.ui.collection;

import android.app.Activity;

import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CollectionViewModelImpl extends ViewModel implements CollectionViewModel {

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;

    public CollectionViewModelImpl(){
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
    }

    @Override
    public void sendSettings(String nickname, String wallet) {
        //Display name
        DatabaseReference myName = database.getReference("users").child(mAuth.getCurrentUser().getUid()).child("Nickname");
        myName.setValue(nickname);

        //Wallet update
        DatabaseReference myWallet = database.getReference("users").child(mAuth.getCurrentUser().getUid()).child("Wallet");
        myWallet.setValue(wallet);
    }

    @Override
    public void signOut(Activity ac) {
        //signout fancy pancy ting
        mAuth.signOut();
    }

    @Override
    public ArrayList getUserData() {
        ArrayList tmp = new ArrayList();
        if(database.getReference("users").child(mAuth.getCurrentUser().getUid()).child("Nickname") != null)
            tmp.add(database.getReference("users").child(mAuth.getCurrentUser().getUid()).child("Nickname"));
        else
            tmp.add("undefined");
        if(database.getReference("users").child(mAuth.getCurrentUser().getUid()).child("Wallet") != null)
            tmp.add(database.getReference("users").child(mAuth.getCurrentUser().getUid()).child("Wallet"));
        else
            tmp.add("undefined");

        return tmp;
    }
}