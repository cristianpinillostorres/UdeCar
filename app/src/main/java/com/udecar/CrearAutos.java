package com.udecar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.udecar.Datos.Automovil;
import com.udecar.Datos.PartesMotor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrearAutos extends AppCompatActivity implements View.OnClickListener {

    private List<Automovil> listAutos = new ArrayList<Automovil>();
    ArrayAdapter<Automovil> arrayAdapterAutos;

    private EditText nombreAuto;
    private EditText tipoFreno;
    private EditText tipoMotor;
    private EditText descripcion, peso;
    private Button btnCrear, btnActualizar, btnEliminar;
    private Spinner sp_Categoria;
    private ListView autos;

    private ProgressDialog progressDialog;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    Automovil autoSelected;
   
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_autos);

        nombreAuto = (EditText) findViewById(R.id.textNombreAuto);
        tipoFreno = (EditText) findViewById(R.id.txtTipoFreno);
        tipoMotor = (EditText) findViewById(R.id.txtTipoMotor);
        descripcion = (EditText) findViewById(R.id.txtDescripcion);
        peso = (EditText) findViewById(R.id.txtPeso);
        btnCrear= (Button) findViewById(R.id.btnCrear);
        btnActualizar= (Button) findViewById(R.id.btn_Actualizar);
        btnEliminar= (Button) findViewById(R.id.btn_Eliminar);
        sp_Categoria = (Spinner) findViewById(R.id.spCategoria); 

        autos = (ListView) findViewById(R.id.lvAutos);


        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        listAutos();
        llenarCategoria();


       btnCrear.setOnClickListener(this);
       btnActualizar.setOnClickListener(this);
       btnEliminar.setOnClickListener(this);

        autos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                autoSelected = (Automovil) parent.getItemAtPosition(position);
                nombreAuto.setText(autoSelected.getNombreAutomovil());
                tipoFreno.setText(autoSelected.getNombreFrenos());
                tipoMotor.setText(autoSelected.getNombreMotor());
                descripcion.setText(autoSelected.getDescripcion());
                peso.setText((int) autoSelected.getPesoAutomovil());
            }
        });

    }

    private void llenarCategoria() {
        PartesMotor parte1 = new PartesMotor(6, 5, "Categoria 1");
        PartesMotor parte2 = new PartesMotor(6, 6, "Categoria 2");
        PartesMotor parte3 = new PartesMotor(6, 7, "Categoria 3");

        ArrayList<String> partes = new ArrayList<>();

        partes.add(parte1.getNombreParte());
        partes.add(parte2.getNombreParte());
        partes.add(parte3.getNombreParte());

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, partes);
        sp_Categoria.setAdapter(adaptador);


        sp_Categoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"selecciono: "+parent.getItemAtPosition(position).toString() ,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void listAutos() {
        databaseReference.child("Automoviles").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listAutos.clear();
                for (DataSnapshot objSnaptshot : dataSnapshot.getChildren()){
                    Automovil a = objSnaptshot.getValue(Automovil.class);
                    listAutos.add(a);

                    arrayAdapterAutos = new ArrayAdapter<Automovil>(CrearAutos.this, android.R.layout.simple_list_item_1, listAutos);
                    autos.setAdapter(arrayAdapterAutos);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    private void Registrar (){
        String nombre = nombreAuto.getText().toString();
        String freno = tipoFreno.getText().toString();
        String motor = tipoMotor.getText().toString();

        if (TextUtils.isEmpty(nombre)){
            Toast.makeText(this, "Por favor ingrese un nombre de auto", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(freno)){
            Toast.makeText(this, "Por favor ingrese un tipo de freno", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(motor)){
            Toast.makeText(this, "Por favor ingrese un tipo de motor", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            Automovil a = new Automovil();
            a.getIdAuto(UUID.randomUUID().toString());
            a.setNombreAutomovil(nombre);
            a.setNombreFrenos(freno);
            a.setNombreMotor(motor);
            databaseReference.child("Automoviles").child(a.getIdAuto()).setValue(a);
            Toast.makeText(this, "Agregado", Toast.LENGTH_SHORT).show();
            limpiarCajas();
        }



    }

    private void actualizar(){
        String nombre = nombreAuto.getText().toString();
        String freno = tipoFreno.getText().toString();
        String motor = tipoMotor.getText().toString();

        Automovil b = new Automovil();
        b.setIdAuto(autoSelected.getIdAuto());
        b.setNombreAutomovil(nombreAuto.getText().toString().trim());
        b.setNombreFrenos(tipoFreno.getText().toString().trim());
        b.setNombreMotor(tipoMotor.getText().toString().trim());
        databaseReference.child("Automoviles").child(b.getIdAuto()).setValue(b);
        Toast.makeText(this,"Actualizado", Toast.LENGTH_LONG).show();
        limpiarCajas();


    }

    private void eliminar() {
        Automovil p = new Automovil();
        p.setIdAuto(autoSelected.getIdAuto());
        databaseReference.child("Automoviles").child(p.getIdAuto()).removeValue();
        Toast.makeText(this,"Eliminado", Toast.LENGTH_LONG).show();
        limpiarCajas();

    }


    private void limpiarCajas(){
        nombreAuto.setText("");
        tipoFreno.setText("");
        tipoMotor.setText("");

    }


    @Override
    public void onClick(View v) {
        Registrar();
        actualizar();
        eliminar();
    }


}