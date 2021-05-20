package com.udecar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

        dataBase = FirebaseDatabase.getInstance().getReference();

        lv_Autos = findViewById(R.id.lv_autos);

        listarDatos();
        lv_Autos.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myintent = new Intent(VistaSeleccionarAuto.this,VistaModificaciones.class);
                startActivity(myintent);
            }
        });
    }
    //Conexión con Realtime Database
    private void listarDatos() {
        dataBase.child("Automoviles").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    for (DataSnapshot auto : snapshot.getChildren()){
                        Automovil nuevoAuto = new Automovil();
                        nuevoAuto.setNombreAutomovil(auto.getKey());
                        //nuevoAuto.setPesoAutomovil(Float.parseFloat(auto.child("pesoAutomovil").getValue().toString()));
                        nuevoAuto.setNombreMotor(auto.child("nombreMotor").getValue().toString());
                        nuevoAuto.setDescripcion(auto.child("descripcion").getValue().toString());
                        nuevoAuto.setNombreFrenos(auto.child("nombreFrenos").getValue().toString());
                        nuevoAuto.setImagenAutomovil(Integer.parseInt(auto.child("imagenAutomovil").getValue().toString()));
                       // nuevoAuto.setCategoria(auto.child("categoria").getValue().toString());
                        listaAutomoviles.add(nuevoAuto);
                    }
                    adaptador = new Adaptador(VistaSeleccionarAuto.this, listaAutomoviles);
                    lv_Autos.setAdapter(adaptador);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(VistaSeleccionarAuto.this,"Error consultando base de datos", Toast.LENGTH_LONG).show();
            }
        });

    }
}