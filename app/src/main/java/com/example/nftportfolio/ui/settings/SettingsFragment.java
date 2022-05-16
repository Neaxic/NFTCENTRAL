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
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.nftportfolio.R;
import com.example.nftportfolio.databinding.FragmentHomeBinding;
import com.example.nftportfolio.databinding.FragmentSettingsBinding;
import com.example.nftportfolio.ui.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;


public class SettingsFragment extends Fragment {

    private FragmentSettingsBinding binding;
    private SettingsViewModelImpl viewModel;
    private EditText nickname, wallet;
    private Button submit, signout;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        viewModel = new ViewModelProvider(this).get(SettingsViewModelImpl.class);

        binding();
        onClick();

        loadText();

        return root;
    }

    private void binding(){
        nickname = binding.displayInput;
        wallet = binding.walletInput;

        submit = binding.settingsSubmit;
        signout = binding.signOut;
    }

    private void onClick(){
        signout.setOnClickListener(v -> {
            viewModel.signOut(getActivity());
            //Ved at signout tager tid, og burde reelt skifte view efter success (Men) brugte for lang tid på livedata efter at man skal skifte view i fragmentet
            Intent i = new Intent(getActivity(), LoginActivity.class);
            startActivity(i);
        });

        submit.setOnClickListener(v -> {
            viewModel.sendSettings(nickname.getText().toString(), wallet.getText().toString());
        });
    }

    private void loadText(){
        viewModel.getUserData(nickname, wallet);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}