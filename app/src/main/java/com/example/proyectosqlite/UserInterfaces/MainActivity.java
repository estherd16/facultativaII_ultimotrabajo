package com.example.proyectosqlite.UserInterfaces;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import com.example.proyectosqlite.Adapter.MyAdapter;
import com.example.proyectosqlite.Config.Constants;
import com.example.proyectosqlite.Database.AppDatabase;
import com.example.proyectosqlite.Entities.Asignatura;
import com.example.proyectosqlite.R;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MyAdapter myAdapter;

    List<Asignatura> listAsignaturas;

    AppDatabase db;

    Button btAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, Constants.BD_NAME)
                .allowMainThreadQueries()
                .build();
        listAsignaturas = db.asignaturaDao().getAllAsignatura();

        btAdd = findViewById(R.id.btAdd);
        mRecyclerView = findViewById(R.id.recyclerView1);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new MyAdapter(this, listAsignaturas);
        mRecyclerView.setAdapter(myAdapter);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);

                dialog.setContentView(R.layout.add_new);
                dialog.setTitle("Agregar Asignaturas");
                dialog.setCancelable(false);
                Button btAddNew = (Button) dialog.findViewById(R.id.btNew);
                Button btCancel = (Button) dialog.findViewById(R.id.btCancel);

                btAddNew.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText editText_Name = (EditText) dialog.findViewById(R.id.editText_Name);
                        EditText editText_Des = (EditText) dialog.findViewById(R.id.editText_Desc);
                        ImageView imageAsig = (ImageView) dialog.findViewById(R.id.imageAsig);

                        if ((editText_Name.getText().toString().contentEquals("")) ||
                                (editText_Des.getText().toString().contentEquals(""))) {
                            Toast.makeText(MainActivity.this, "Nombre y descripción es requerido",
                                    Toast.LENGTH_LONG).show();
                        } else {
                            String nAsignatura, nDesc;

                            nAsignatura = editText_Name.getText().toString();
                            nDesc = editText_Des.getText().toString();

                            Asignatura asignaturaObj = new Asignatura();

                            asignaturaObj.setTitle(nAsignatura);
                            asignaturaObj.setDescription(nDesc);

                            long resultadoInsert = db.asignaturaDao().insert(asignaturaObj);
                            if (resultadoInsert > 0) {

                                listAsignaturas = db.asignaturaDao().getAllAsignatura();

                                myAdapter = new MyAdapter(MainActivity.this, listAsignaturas);

                                mRecyclerView.setAdapter(myAdapter);
                                Toast.makeText(MainActivity.this, "Datos Insertados",
                                        Toast.LENGTH_LONG).show();

                                editText_Name.setText("");
                                editText_Des.setText("");
                            } else {
                                Toast.makeText(MainActivity.this, "Error al insertar datos",
                                        Toast.LENGTH_LONG).show();
                            }
                            dialog.cancel();
                        }
                    }
                });
            btCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.cancel();
                }
            });
                dialog.show();
            }
        });

    }
}
       /* btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void OnClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);

                dialog.setContentView(R.layout.add_new);
                dialog.setTitle("Agregar Asignaturas");
                dialog.setCancelable(false);
                Button btAddNew = (Button) dialog.findViewById(R.id.btNew);
                Button btCancel = (Button) dialog.findViewById(R.id.btCancel);
                btAddNew.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void OnClick(View v) {
                        EditText editText_Name = (EditText) dialog.findViewById(R.id.editText_Name);
                        EditText editText_Des = (EditText) dialog.findViewById(R.id.editText_Desc);
                        ImageView imageAsig = (ImageView) dialog.findViewById(R.id.imageAsig);

                        if ((editText_Name.getText().toString().contentEquals("")) ||
                                (editText_Des.getText().toString().contentEquals(""))) {
                            Toast.makeText(MainActivity.this, "Nombre y descripción es requerido",
                                    Toast.LENGTH_LONG).show();
                        } else {
                            String nAsignatura, nDesc;

                            nAsignatura = editText_Name.getText().toString();
                            nDesc = editText_Des.getText().toString();

                            Asignatura asignaturaObj = new Asignatura();

                            asignaturaObj.setTitle(nAsignatura);
                            asignaturaObj.setDescription(nDesc);

                            long resultadoInsert = db.asignaturaDao().insert(asignaturaObj);
                            if (resultadoInsert > 0) {

                                listAsignaturas = db.asignaturaDao().getAllAsignatura();

                                myAdapter = new MyAdapter(MainActivity.this, listAsignaturas);

                                mRecyclerView.setAdapter(myAdapter);
                                Toast.makeText(MainActivity.this, "Datos Insertados",
                                        Toast.LENGTH_LONG).show();

                                editText_Name.setText("");
                                editText_Des.setText("");
                            } else {
                                Toast.makeText(MainActivity.this, "Error al insertar datos",
                                        Toast.LENGTH_LONG).show();
                            }
                            dialog.cancel();
                        }
                    }
                });
                btCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void OnClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });*/

