package com.udecar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.udecar.Datos.Automovil;

import java.util.ArrayList;

public class VistaSeleccionarAuto extends AppCompatActivity {

    private ListView lv_Autos;
    private Adaptador adaptador;
    private ArrayList<Automovil> listaAutomoviles = new ArrayList<>();
    private DatabaseReference dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_seleccionar_auto);

        dataBase = FirebaseDatabase.getInstance().getReference().child("Automoviles");

        lv_Autos = findViewById(R.id.lv_Autos);

        listarDatos();
        lv_Autos.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myintent = new Intent(VistaSeleccionarAuto.this,VistaModificaciones.class);
                startActivity(myintent);
            }
        });
    }

    private void listarDatos() {
        dataBase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot templateSnapshot : snapshot.getChildren()){
                        Automovil autos = templateSnapshot.getValue(Automovil.class);
                        listaAutomoviles.add(autos);
                    }
                    adaptador = new Adaptador(VistaSeleccionarAuto.this, listaAutomoviles);
                    lv_Autos.setAdapter(adaptador);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}