package com.udecar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.udecar.Datos.Automovil;

import java.util.ArrayList;

public class VistaSeleccionarAuto extends AppCompatActivity {

    private ListView lv_Autos;
    private Adaptador adaptador;
    private ArrayList<Automovil> arrayAutomoviles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_seleccionar_auto);

        lv_Autos = (ListView) findViewById(R.id.lv_Autos);

        llenarLista();

        lv_Autos.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myintent = new Intent(VistaSeleccionarAuto.this,VistaModificaciones.class);
                startActivity(myintent);
            }
        });
    }

    private void llenarLista(){
        //se declaran 5 automoviles
        arrayAutomoviles.add(new Automovil(1, "Chevrolet Spark", R.drawable.automovil,
                3.67f, "x", "", "Motor Chevrolet","f"));
        arrayAutomoviles.add(new Automovil(2, "Renault Stepway ", R.drawable.automovil,
                3.67f, "x", "", "Motor Renault","f"));
        arrayAutomoviles.add(new Automovil(3, "Chevrolet Corsa",R.drawable.automovil ,
                3.67f, "x", "", "Motor Chevrolet","f"));
        arrayAutomoviles.add(new Automovil(4, "Renault Logan",R.drawable.automovil ,
                3.67f, "x", "", "Motor Renault","f"));

        //arrayAutomoviles.add(new Entidad(R.drawable.img_5, "autoo" "info"));

        adaptador = new Adaptador(this, arrayAutomoviles);
        lv_Autos.setAdapter(adaptador);
    }
}