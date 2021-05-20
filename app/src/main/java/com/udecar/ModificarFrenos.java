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

import java.util.ArrayList;

public class ModificarFrenos extends AppCompatActivity {

    Spinner spLista, spLista2;
    EditText tiposDeFreno;
    EditText pinzas;
    Button btn_guardarModFrenos;

    private DatabaseReference mDatabase;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_frenos);

        mDatabase = FirebaseDatabase.getInstance().getReference("GuardarDatosModificados");

        spLista =(Spinner) findViewById(R.id.sp_pistones);
        spLista2 = (Spinner) findViewById(R.id.sp_tiposFrenos);
        tiposDeFreno = (EditText) findViewById(R.id.tipo_Freno);
        pinzas = (EditText) findViewById (R.id.twFiltro);
        btn_guardarModFrenos = (Button) findViewById(R.id.btn_guardarModFrenos);

    }

    public void registrarModificaciones (){

        String pinza= spLista.getSelectedItem().toString();
        String tipoFreno = spLista2.getSelectedItem().toString();
        //String porcentaje = .getSelectedItem().toString();

        if (!TextUtils.isEmpty(pinza)){
            String id = mDatabase.push().getKey();
            Toast.makeText(this, "Datos guardados", Toast.LENGTH_LONG).show();

        }
    }

}
