package com.example.nftportfolio.ui.settings;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.example.nftportfolio.ui.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SettingsViewModelImpl extends ViewModel implements SettingsViewModel {

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;

    public SettingsViewModelImpl(){
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
    public void getUserData(EditText nick, EditText wallet) {
        database.getReference("users").child(mAuth.getCurrentUser().getUid()).child("Wallet").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.getValue() != null){
                    String dbWallet = snapshot.getValue().toString();
                        wallet.setText(dbWallet);

                }   else
                    wallet.setText("Wallet");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        database.getReference("users").child(mAuth.getCurrentUser().getUid()).child("Nickname").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.getValue() != null) {
                    nick.setText(snapshot.getValue().toString());
                }
                else
                    nick.setText("Nickname");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}