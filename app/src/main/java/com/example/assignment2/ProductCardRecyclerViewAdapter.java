package com.example.assignment2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment2.model.Match;
import com.example.assignment2.network.ImageRequester;

import java.util.List;

/**
 * Adapter used to show a simple grid of products.
 */
public class ProductCardRecyclerViewAdapter extends RecyclerView.Adapter<ProductCardViewHolder> {

    private List<Match> productList;
    private ImageRequester imageRequester;

    ProductCardRecyclerViewAdapter(List<Match> productList) {
        this.productList = productList;
        /*imageRequester = ImageRequester.getInstance();*/
    }

    @NonNull
    @Override
    public ProductCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.matches_card, parent, false);
        return new ProductCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductCardViewHolder holder, int position) {
        if (productList != null) {
            Match m = this.productList.get(position);
            holder.name.setText(m.name);
            holder.m = m;
            holder.setLiked(m.liked);
            imageRequester.setImageFromUrl(holder.matchImage, m.imageUrl);
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
    public void setMatchesList(List<Match> m) {
        this.productList = m;
    }
}