package com.udecar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.udecar.Datos.Automovil;

import java.util.ArrayList;

public class VistaSeleccionarAuto extends AppCompatActivity {

    private ListView lv_Autos;
    private Adaptador adaptador;
    private ArrayList<Automovil> listaAutomoviles = new ArrayList<>();
    private FirebaseFirestore miFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_seleccionar_auto);

        miFirestore = FirebaseFirestore.getInstance();

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
        miFirestore.collection("automovil").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for(QueryDocumentSnapshot documento : task.getResult()) {
                        Automovil autos = documento.toObject(Automovil.class);
                        listaAutomoviles.add(autos);
                    }
                    adaptador = new Adaptador(VistaSeleccionarAuto.this, listaAutomoviles);
                    lv_Autos.setAdapter(adaptador);

                } else {
                    Log.d("ListarAutos", "Error obteniendo los documentos: ", task.getException());
                }
            }
        });

    }
}