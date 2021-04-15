package com.udecar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ModificarMotor extends AppCompatActivity {

    Spinner listaBujias;
    Spinner listaFiltros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_modificar_motor);

            // bajo
            //inicializar componentes
            listaBujias = (Spinner) findViewById(R.id.ddl_listaBujias); //

            // 6% a la potencia
            listaFiltros = (Spinner) findViewById(R.id.ddl_listaFiltros);// 6% a la potencia

            //llenar Spinner
            LlenarSpiner();
    }

    public void LlenarSpiner(){

        PartesMotor parte1 = new PartesMotor(1, 1,"Bujia A");
        PartesMotor parte2 = new PartesMotor(2, 1,"Bujia B");
        PartesMotor parte3 = new PartesMotor(2, 2,"Bujia C");
        //Creacion del arrayList de tipo "PartesMotor"
        ArrayList<String> partes = new ArrayList<>();
        //llenado del arrayList
        partes.add(parte1.getNombreParte());
        partes.add(parte2.getNombreParte());
        partes.add(parte3.getNombreParte());
        //adaptador de tipo arrayList para el spinner
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, partes);
        listaBujias.setAdapter(adaptador);

        listaBujias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        PartesMotor parteSeleccionada = (PartesMotor) listaBujias.getSelectedItem();
        String mensaje = parteSeleccionada.getNombreParte()+" ha sido seleccionada";
        Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
    }

}