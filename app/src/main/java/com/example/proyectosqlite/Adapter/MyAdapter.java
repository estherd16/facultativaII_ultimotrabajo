package com.example.proyectosqlite.Adapter;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.proyectosqlite.Config.Constants;
import com.example.proyectosqlite.Database.AppDatabase;
import com.example.proyectosqlite.Entities.Asignatura;
import com.example.proyectosqlite.Holder.MyHolder;
import com.example.proyectosqlite.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {
    Context c;
    List<Asignatura> listAsignaturas;
    AppDatabase db;
    View.OnCreateContextMenuListener contextClick;

    public MyAdapter(Context c, List<Asignatura> listAsignaturas, View.OnCreateContextMenuListener contextClick){
        this.c=c;
        this.listAsignaturas = listAsignaturas;
        db = Room.databaseBuilder(c, AppDatabase.class, Constants.BD_NAME)
            .allowMainThreadQueries()
            .build();

        this.contextClick = contextClick;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,null);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, final int position) {
        holder.mTitle.setText(listAsignaturas.get(position).getTitle());
        holder.mDescription.setText(listAsignaturas.get(position).getDescription());

        holder.setCreateContextMenu(this.contextClick);

    }

    @Override
    public int getItemCount() {
        return listAsignaturas.size();
    }

}
