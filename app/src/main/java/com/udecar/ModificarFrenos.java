package com.udecar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ModificarFrenos extends AppCompatActivity {
Spinner spLista, spLista2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_frenos);

    spLista =(Spinner)findViewById(R.id.sp_Pistones);
    spLista2 = (Spinner)findViewById(R.id.sp_TiposFrenos);

        LlenarSpiner();
    }

    public void LlenarSpiner(){


        PartesFrenos parte1 = new  PartesFrenos (1,"2 Pistones");
        PartesFrenos parte2 = new  PartesFrenos (2,"4 Pistones");
        PartesFrenos parte3 = new  PartesFrenos (2,"6 Pistones");

        ArrayList<String> partes = new ArrayList<>();

        partes.add(parte1.getNombreParte());
        partes.add(parte2.getNombreParte());
        partes.add(parte3.getNombreParte());

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, partes);
        spLista.setAdapter(adaptador);


        spLista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"selecciono: "+parent.getItemAtPosition(position).toString() ,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void LlenarSpinerDiscos(){


        PartesFrenos parte1 = new  PartesFrenos (1,"Discos ventilados");
        PartesFrenos parte2 = new  PartesFrenos (2,"Disco 4 ruedas");
        PartesFrenos parte3 = new  PartesFrenos (2,"Disco solido-Tambor");
        PartesFrenos parte4 = new  PartesFrenos (2,"Disco ventilado-Tambor");


        ArrayList<String> partes = new ArrayList<>();

        partes.add(parte1.getNombreParte());
        partes.add(parte2.getNombreParte());
        partes.add(parte3.getNombreParte());
        partes.add(parte4.getNombreParte());

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, partes);
        spLista2.setAdapter(adaptador);


        spLista2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"selecciono: "+parent.getItemAtPosition(position).toString() ,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void ObtenerSeleccion(){
        PartesMotor parteSeleccionada = (PartesMotor) spLista.getSelectedItem();
        PartesMotor parteSeleccionada2 = (PartesMotor) spLista2.getSelectedItem();
        String mensaje = parteSeleccionada.getNombreParte()+" ha sido seleccionada";
        Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
    }
}
