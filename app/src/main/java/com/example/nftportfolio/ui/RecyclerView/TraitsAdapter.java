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
import com.example.nftportfolio.model.Traits;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class TraitsAdapter extends RecyclerView.Adapter<TraitsAdapter.ViewHolder> {

    private ArrayList<Traits> traits;
    private OnClickListener listener;

    public TraitsAdapter(ArrayList<Traits> traits){
        this.traits = traits;
    }

    public TraitsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_traits, parent, false);;
        ViewHolder viewH = new ViewHolder(view);
        return viewH;
    }

    public void setOnClickListner(OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.TraitsType.setText("Type: "+traits.get(position).getTrait_type());
        holder.TraitsValue.setText(traits.get(position).getValue());
        holder.TraitsCount.setText("Count: "+traits.get(position).getTrait_count());
    }

    @Override
    public int getItemCount() {
        return traits.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView TraitsType, TraitsValue, TraitsCount;

        ViewHolder(View itemView){
            super(itemView);
            TraitsType = itemView.findViewById(R.id.traitsType);
            TraitsValue = itemView.findViewById(R.id.traitsValue);
            TraitsCount = itemView.findViewById(R.id.traitsCount);
        }
    }

}
