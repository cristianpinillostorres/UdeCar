package com.udecar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.udecar.Datos.PartesFrenos;

import java.util.ArrayList;

public class ModificarFrenos extends AppCompatActivity {

    private Spinner spLista, spLista2;
    private Button btn_guardarModFrenos;

    private DatabaseReference mDatabase;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_frenos);

        mDatabase = FirebaseDatabase.getInstance().getReference("GuardarDatosModificados");

        spLista = findViewById(R.id.sp_pistones);
        spLista2 = findViewById(R.id.sp_tiposFrenos);
        btn_guardarModFrenos = findViewById(R.id.btn_guardarModFrenos);

        LlenarSpiner();
        LlenarSpinerDiscos();
    }

    public void registrarModificaciones (){

        String pinza= spLista.getSelectedItem().toString();
        String tipoFreno = spLista2.getSelectedItem().toString();
        //String porcentaje = .getSelectedItem().toString();

        if (!TextUtils.isEmpty(pinza)){
            String id = mDatabase.push().getKey();
            //Toast.makeText(this, "Datos guardados", Toast.LENGTH_LONG).show(id, pinza, tipoFreno);
            Toast.makeText(this, "Datos guardados", Toast.LENGTH_LONG).show();
        }
    }

    public void LlenarSpiner(){

        PartesFrenos parte1 = new PartesFrenos(1, "2 Pistones", 3);
        PartesFrenos parte2 = new PartesFrenos(2, "4 Pistones", 1);
        PartesFrenos parte3 = new  PartesFrenos (3, "6 Pistones", 2);

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


        PartesFrenos parte1 = new  PartesFrenos (1, "Discos ventilados", 1);
        PartesFrenos parte2 = new  PartesFrenos (2,"Disco 4 ruedas", 2);
        PartesFrenos parte3 = new  PartesFrenos (3,"Disco solido-Tambor", 3);
        PartesFrenos parte4 = new  PartesFrenos (4,"Disco ventilado-Tambor", 4);


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

}
