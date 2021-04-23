package com.udecar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.udecar.Datos.Automovil;
import com.udecar.Datos.Frenos;
import com.udecar.Datos.PartesFrenos;

import java.util.ArrayList;

public class ModificarFrenos extends AppCompatActivity {
    private Frenos frenos= new Frenos();
    private Automovil auto;

    private Spinner listaPistones;
    private Spinner listaTiposFrenos;
    private TextView labelInfo;
    private TextView labelNombre;

    private ArrayList<Frenos> arrayFrenos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_frenos);

        auto = (Automovil) getIntent().getSerializableExtra("item");
        //inicializar componentes
        listaPistones =(Spinner)findViewById(R.id.sp_pistones);
        listaTiposFrenos = (Spinner)findViewById(R.id.sp_tiposFrenos);
        labelNombre = findViewById(R.id.tv_nombreFrenos);
        labelInfo = findViewById(R.id.tv_infoFrenos);

        //frenos de prueba
        //arrayFrenos.add(new Frenos(1,"."));
        //arrayFrenos.add(new Frenos(2,"."));

        //valida que sea el mismo motor
        String nombre = "" ;
        String informacion = "";
        /*for (int i=0;i<arrayFrenos.size();i++) {
            if (auto.getNombrFrenos().equals(arrayFrenos.get(i).getNombreFrenos())) {

                nombre = arrayFrenos.get(i).getNombreFrenos();
                informacion =  "Cilindraje: " + arrayFrenos.get(i).getCilindraje() + "\n" +
                        "Potencia: " + arrayFrenos.get(i).getPotencia() + "\n" +
                        "Bujias: " + arrayFrenos.get(i).getTipoBujia() + "\n" +
                        "Filtros: " + arrayFrenos.get(i).getTipoFiltro()+ "\n";
            }
        }

        */

        labelNombre.setText(nombre);
        labelInfo.setText(informacion);

        LlenarSpiner();
        LlenarSpinerDiscos();

    }

    public void LlenarSpiner(){


        PartesFrenos parte1 = new  PartesFrenos (1,"2 Pistones",1);
        PartesFrenos parte2 = new  PartesFrenos (2,"4 Pistones",1);
        PartesFrenos parte3 = new  PartesFrenos (2,"6 Pistones",1);

        ArrayList<String> partes = new ArrayList<>();

        partes.add(parte1.getNombreParte());
        partes.add(parte2.getNombreParte());
        partes.add(parte3.getNombreParte());

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, partes);
        listaPistones.setAdapter(adaptador);


        listaPistones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        PartesFrenos parte1 = new  PartesFrenos (1,"Discos ventilados",2);
        PartesFrenos parte2 = new  PartesFrenos (2,"Disco 4 ruedas",2);
        PartesFrenos parte3 = new  PartesFrenos (2,"Disco solido-Tambor",2);
        PartesFrenos parte4 = new  PartesFrenos (2,"Disco ventilado-Tambor",2);

        ArrayList<String> partes = new ArrayList<>();

        partes.add(parte1.getNombreParte());
        partes.add(parte2.getNombreParte());
        partes.add(parte3.getNombreParte());
        partes.add(parte4.getNombreParte());

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, partes);
        listaTiposFrenos.setAdapter(adaptador);

        listaTiposFrenos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"selecciono: "+parent.getItemAtPosition(position).toString() ,Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

}
