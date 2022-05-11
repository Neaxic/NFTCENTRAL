package com.example.nftportfolio.ui.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.nftportfolio.R;
import com.example.nftportfolio.ui.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;


public class SettingsFragment extends Fragment {

    private SettingsViewModelImpl viewModel;
    private EditText nickname;
    private EditText wallet;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_settings, container, false);
        viewModel = new ViewModelProvider(this).get(SettingsViewModelImpl.class);

        nickname = (EditText) getActivity().findViewById(R.id.usernameField);
        wallet = (EditText) getActivity().findViewById(R.id.walletInput);

        Button d = root.findViewById(R.id.signOut);
        Button b = root.findViewById(R.id.settingsSubmit);
        d.setOnClickListener(v -> {
            viewModel.signOut(getActivity());
            //Ved at signout tager tid, og burde reelt skifte view efter success (Men) brugte for lang tid på livedata efter at man skal skifte view i fragmentet
            Intent i = new Intent(getActivity(), LoginActivity.class);
            startActivity(i);
        });
        b.setOnClickListener(v -> {
            viewModel.sendSettings(nickname.getText().toString(), "");
        });

        //loadText();

        return root;
    }

    private void loadText(){
        ArrayList a = viewModel.getUserData();

        if(a.size() > 0 && nickname != null && wallet != null){
            nickname.setText(a.get(0).toString());
            wallet.setText(a.get(1).toString());
        }
    }

}