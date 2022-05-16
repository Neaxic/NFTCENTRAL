package com.example.nftportfolio.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.nftportfolio.Repository;
import com.example.nftportfolio.model.NFTRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeViewModelImpl extends ViewModel implements HomeViewModel {

    private final MutableLiveData<String> mText;
    private NFTRepository repo;

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private String myWallet;

    public HomeViewModelImpl() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        DatabaseReference walletRef = database.getReference("users").child(mAuth.getCurrentUser().getUid()).child("Wallet");
        walletRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                myWallet = snapshot.getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        repo = NFTRepository.getInstance();
    }

    public LiveData<String> getText() {
        return mText;
    }

    @Override
    public void refresh() {
        //Slet tidligere data
        repo.clearData();

        repo.fetchNFTs(myWallet);
    }
}