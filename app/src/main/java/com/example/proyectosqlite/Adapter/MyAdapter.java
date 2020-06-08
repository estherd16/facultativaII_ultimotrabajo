package com.example.proyectosqlite.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import com.example.proyectosqlite.Entities.Asignatura;
import com.example.proyectosqlite.Holder.MyHolder;
import com.example.proyectosqlite.R;

public class MyAdapter extends RecyclerView.Adapter<MyHolder>{
    Context c;
    List<Asignatura> listAsignaturas;

    public MyAdapter(Context c, List<Asignatura> listAsignaturas){
        this.c = c;
        this.listAsignaturas=listAsignaturas;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row, null);

        return new MyHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, int position){
        holder.mTitle.setText(listAsignaturas.get(position).getTitle());
        holder.mDescription.setText((listAsignaturas.get(position).getDescription()));
    }

    @Override
    public int getItemCount(){
        return listAsignaturas.size();
    }
}
