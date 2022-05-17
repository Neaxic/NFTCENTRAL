package com.example.nftportfolio.ui.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nftportfolio.R;
import com.example.nftportfolio.model.NFT;
import com.example.nftportfolio.model.NFTRepository;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class NFTAdapter extends RecyclerView.Adapter<NFTAdapter.ViewHolder> {

    private ArrayList<NFT> nfts;
    private OnClickListener listener;

    public NFTAdapter(ArrayList<NFT> nfts){
        this.nfts = nfts;
    }

    public NFTAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_items, parent, false);;
        ViewHolder viewH = new ViewHolder(view);
        return viewH;
    }

    public void setOnClickListner(OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Opdatere ikke efter nye col stats (MutableLiveData / omprioriter i repo) (TODO ikke vigtig)
        holder.name.setText(nfts.get(position).getName());
        holder.pricing.setText("Current FP: "+nfts.get(position).getCollection().getStats().getFloor_price()+", Sales: "+nfts.get(position).getCollection().getStats().getOne_day_sales()+ ", Supply: "+nfts.get(position).getCollection().getStats().getCount()+", owners: "+nfts.get(position).getCollection().getStats().getNum_owners());
        try {
            Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(nfts.get(position).getImg()).getContent());
            holder.icon.setImageBitmap(bitmap);
        } catch (IOException e) {
            holder.icon.setImageResource(R.drawable.ic_baseline_block_24);

//            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return nfts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView name;
        private final ImageView icon;
        private final TextView pricing;

        ViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            pricing = itemView.findViewById(R.id.tv_pricing);
            icon = itemView.findViewById(R.id.iv_icon);
            itemView.setOnClickListener(v ->{
                listener.onClick(nfts.get(getBindingAdapterPosition()));
            });
        }
    }

}
