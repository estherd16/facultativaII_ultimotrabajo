package com.example.proyectosqlite.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.proyectosqlite.Entities.Asignatura;
import com.example.proyectosqlite.Interfaces.AsignaturaDao;

@Database(entities = {Asignatura.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{

    public abstract AsignaturaDao asignaturaDao();

    private static AppDatabase sInstance;

}
