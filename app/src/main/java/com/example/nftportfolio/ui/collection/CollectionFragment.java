package com.example.nftportfolio.ui.collection;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.nftportfolio.R;
import com.example.nftportfolio.databinding.FragmentCollectionBinding;
import com.example.nftportfolio.databinding.FragmentSettingsBinding;
import com.example.nftportfolio.databinding.FragmentSingleBinding;
import com.example.nftportfolio.model.NFT;
import com.example.nftportfolio.model.NFTRepository;
import com.example.nftportfolio.ui.login.LoginActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;


public class CollectionFragment extends Fragment {

    private FragmentCollectionBinding binding;
    private NFTRepository repo;
    private CollectionViewModelImpl viewModel;

    private TextView title, statsTitle, statsDesc, SaleTitle, SaleDesc;
    private ImageView collectionbanner;

    public static CollectionFragment newInstance() {
        return new CollectionFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentCollectionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        viewModel = new ViewModelProvider(this).get(CollectionViewModelImpl.class);

        repo = NFTRepository.getInstance();

        binding();
        loadText();

        return root;
    }

    private void binding(){
        title = binding.textCollection;

        statsTitle = binding.textStatsTitle;
        statsDesc = binding.textStatsDesc;

        SaleTitle = binding.textSaleTitle;
        SaleDesc = binding.textSaleDesc;

        collectionbanner = binding.collectionBanner;
    }

    private void loadText(){
        NFT tmp = repo.getSelectedNFT();
        if(tmp == null) return;

        title.setText(tmp.getCollection().getName());
        statsTitle.setText("Collection Stats");
        statsDesc.setText("Collection stats\n" +
                "Current floor price: "+tmp.getCollection().getStats().getFloor_price()+"\n"+
                "Collection Supply: "+tmp.getCollection().getStats().getCount()+"\n"+
                "Collection Unique Owners: "+tmp.getCollection().getStats().getNum_owners()+"\n"+
                "Collection Total Volume: "+tmp.getCollection().getStats().getTotal_volume()+"\n"+
                "Collection all-time AVG price: "+tmp.getCollection().getStats().getAverage_price()+"\n"+
                "Collection total sales: "+tmp.getCollection().getStats().getTotal_sales());

        SaleTitle.setText("Sales Stats");
        SaleDesc.setText(
                "Sale Statictis"+"\n"+
                "Last 1 day AVG price: "+tmp.getCollection().getStats().getOne_day_average_price()+"\n"+
                "Last 7 day AVG price: "+tmp.getCollection().getStats().getSeven_day_average_price()+"\n"+
                "Last 30 day AVG price: "+tmp.getCollection().getStats().getThirty_day_average_price());

        try {
            Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(repo.getSelectedNFT().getCollection().getBanner_image_url()).getContent());
            collectionbanner.setImageBitmap(bitmap);
        } catch (IOException e) {
            collectionbanner.setImageResource(R.drawable.ic_baseline_block_24);

//            e.printStackTrace();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}