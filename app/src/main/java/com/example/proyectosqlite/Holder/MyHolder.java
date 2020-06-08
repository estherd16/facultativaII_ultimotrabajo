package com.example.proyectosqlite.Holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectosqlite.R;

public class MyHolder extends RecyclerView.ViewHolder {
    public ImageView mImageView;
    public TextView mTitle, mDescription;

    public MyHolder(@NonNull View itemView){
        super(itemView);

        this.mImageView=itemView.findViewById(R.id.imagelv);
        this.mDescription=itemView.findViewById(R.id.description);
        this.mTitle=itemView.findViewById(R.id.title);
    }
}
