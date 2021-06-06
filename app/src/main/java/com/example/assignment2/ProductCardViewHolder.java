package com.example.assignment2;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.assignment2.model.Match;

public class ProductCardViewHolder extends RecyclerView.ViewHolder {

    public NetworkImageView matchImage;
    public TextView name;
    public Match m;
    CheckBox likeBtn;

    public ProductCardViewHolder(@NonNull View itemView) {
        super(itemView);
        /*matchImage = itemView.findViewById(R.id.match_image);*/
        name = itemView.findViewById(R.id.match_name);
        likeBtn = (CheckBox) itemView.findViewById(R.id.like_button);
        likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyListener myListener = (MyListener) itemView.getContext();
                if (myListener != null) {
                    myListener.matchesLikeToast(m);
                }
            }
        });
    }

    public void setLiked(boolean liked) {
        likeBtn.setChecked(liked);
    }

}