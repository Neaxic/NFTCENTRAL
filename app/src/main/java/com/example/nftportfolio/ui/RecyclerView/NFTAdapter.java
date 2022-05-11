package com.example.nftportfolio.ui.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nftportfolio.R;
import com.example.nftportfolio.model.NFT;

import java.util.ArrayList;

public class NFTAdapter extends RecyclerView.Adapter<NFTAdapter.ViewHolder> {

    private ArrayList<NFT> nfts;

    public NFTAdapter(ArrayList<NFT> nfts){
        this.nfts = nfts;
    }

    public NFTAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_items, parent, false);;
        ViewHolder viewH = new ViewHolder(view);
        return viewH;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(nfts.get(position).getName());
        holder.icon.setImageResource(nfts.get(position).getIconId());
    }

    @Override
    public int getItemCount() {
        return nfts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView name;
        private final ImageView icon;

        ViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            icon = itemView.findViewById(R.id.iv_icon);
        }
    }

}
