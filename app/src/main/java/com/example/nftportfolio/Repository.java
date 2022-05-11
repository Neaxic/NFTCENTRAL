package com.example.nftportfolio;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Repository {

    private static Repository instance;
    private FirebaseUser user;

    private Repository(){
        user = FirebaseAuth.getInstance().getCurrentUser();
    }

    public static Repository getInstance(){
        if(instance == null)
            instance = new Repository();

        return instance;
    }

}
