package com.example.nftportfolio.ui.collection;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.nftportfolio.R;
import com.example.nftportfolio.databinding.FragmentCollectionBinding;
import com.example.nftportfolio.databinding.FragmentSettingsBinding;
import com.example.nftportfolio.ui.login.LoginActivity;

import java.util.ArrayList;


public class CollectionFragment extends Fragment {

    private FragmentCollectionBinding binding;
    private CollectionViewModelImpl viewModel;
    private Spinner dropdown;

    private String[] items = new String[]{"1", "2", "3"};

    public static CollectionFragment newInstance() {
        return new CollectionFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentCollectionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        viewModel = new ViewModelProvider(this).get(CollectionViewModelImpl.class);


//        binding();
        onClick();

        //loadText();

        return root;
    }

//    private void binding(){
//        ArrayAdapter<CharSequence> stringName = ArrayAdapter.createFromResource(getActivity(), items, android.R.layout.simple_spinner_item);
//        stringName.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        dropdown = binding.spinner;
//        dropdown.setAdapter(stringName);
//    }

    private void onClick(){

    }

    private void loadText(){
//        dropdown.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}