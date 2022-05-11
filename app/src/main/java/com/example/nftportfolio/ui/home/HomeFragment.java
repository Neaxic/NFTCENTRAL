package com.example.nftportfolio.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nftportfolio.R;
import com.example.nftportfolio.databinding.FragmentHomeBinding;
import com.example.nftportfolio.model.NFT;
import com.example.nftportfolio.ui.RecyclerView.NFTAdapter;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private FirebaseAuth mAuth;
    HomeViewModel viewModel;

    RecyclerView nftList;

    private FragmentHomeBinding binding;
    private TextView textView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(HomeViewModelImpl.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mAuth = FirebaseAuth.getInstance();

        //Liste
        nftList = binding.getRoot().findViewById(R.id.rv);
        nftList.hasFixedSize();
        nftList.setLayoutManager(new LinearLayoutManager(this.getContext()));

        ArrayList<NFT> nfts = new ArrayList<>();
        nfts.add(new NFT("Bulbasaur", R.drawable.p1));
        nfts.add(new NFT("Ivysaur", R.drawable.p2));
        nfts.add(new NFT("Ivysaur2", R.drawable.p2));
        nfts.add(new NFT("Ivysaur3", R.drawable.p2));
        nfts.add(new NFT("Ivysaur4", R.drawable.p2));
        nfts.add(new NFT("Ivysaur5", R.drawable.p2));
        nfts.add(new NFT("Ivysaur6", R.drawable.p2));
        nfts.add(new NFT("Ivysaur7", R.drawable.p2));

        NFTAdapter a = new NFTAdapter(nfts);
        nftList.setAdapter(a);



        bindings();
        setText();
        return root;
    }

    private void setText() {
        if(mAuth.getCurrentUser() != null)
            textView.setText("Hej "+mAuth.getCurrentUser().getEmail());
        else
            textView.setText("Ikke logget ind");
    }

    private void bindings() {
        textView = binding.textHome;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}