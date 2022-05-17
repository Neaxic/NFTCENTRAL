package com.example.nftportfolio.ui.NFTStats;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nftportfolio.R;
import com.example.nftportfolio.databinding.FragmentCollectionBinding;
import com.example.nftportfolio.databinding.FragmentSingleBinding;
import com.example.nftportfolio.model.NFT;
import com.example.nftportfolio.model.NFTRepository;
import com.example.nftportfolio.ui.RecyclerView.NFTAdapter;
import com.example.nftportfolio.ui.RecyclerView.TraitsAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class NFTStatsFragment extends Fragment {

    private FragmentSingleBinding binding;
    private NFTRepository repo;
    private NFTStatsViewModelImpl viewModel;

    private RecyclerView traitsList;

    private TextView taitsTitle;
    private ImageView imgColllection, imgNFT;


    public static NFTStatsFragment newInstance() {
        return new NFTStatsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentSingleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        viewModel = new ViewModelProvider(this).get(NFTStatsViewModelImpl.class);

        repo = NFTRepository.getInstance();

        binding();
        loadText();

        return root;
    }

    private void binding(){
        taitsTitle = binding.textTraitsTitle;

        imgColllection = binding.ImgTraitsCol;
        imgNFT = binding.ImgTraitsNFT;

        traitsList = binding.rtraits;
        traitsList.hasFixedSize();
        traitsList.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }

    private void loadText(){
        NFT tmp = repo.getSelectedNFT();
        if(tmp == null) return;

        taitsTitle.setText("Your personal NFT Traits");

        try {
            Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(repo.getSelectedNFT().getCollection().getImage_url()).getContent());
            imgColllection.setImageBitmap(bitmap);

            Bitmap bitmap2 = BitmapFactory.decodeStream((InputStream)new URL(repo.getSelectedNFT().getImg()).getContent());
            imgNFT.setImageBitmap(bitmap2);
        } catch (IOException e) {
            imgColllection.setImageResource(R.drawable.ic_baseline_block_24);
            imgNFT.setImageResource(R.drawable.ic_baseline_block_24);
        }

        TraitsAdapter a = new TraitsAdapter(repo.getSelectedNFT().getTraits());
        traitsList.setAdapter(a);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}