package com.udecar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.udecar.Datos.Automovil;
import com.udecar.Firebase.FirebaseService;

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

        FirebaseService catalogo = new FirebaseService();
        catalogo.obtenerAutos();
        while(!catalogo.isBanderaAutos()){
            if (catalogo.isBanderaAutos()){
                arrayAutomoviles.addAll(catalogo.getListaAutos());
                adaptador = new Adaptador(this, arrayAutomoviles);
                lv_Autos.setAdapter(adaptador);
            }
        }

        //arrayAutomoviles.addAll(catalogo.obtenerAutos());
        //arrayAutomoviles.add(new Entidad(R.drawable.img_5, "autoo" "info"));


    }
}