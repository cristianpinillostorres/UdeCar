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
import com.udecar.Datos.Bujia;

import java.util.ArrayList;
import java.util.List;

public class CrearAutos<categoria> extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private List<Automovil> listAutos = new ArrayList<Automovil>();
    ArrayAdapter<Automovil> arrayAdapterAutos;

    private EditText nombreAuto;
    private EditText tipoFreno;
    private EditText tipoMotor;
    private EditText descripcion, peso, bujia, potencia;
    private Button btnCrear, btnActualizar;
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
        bujia = (EditText) findViewById(R.id.txtBujia);
        potencia = (EditText) findViewById(R.id.txtBujia);
        peso = (EditText) findViewById(R.id.txtPeso);
        btnCrear= (Button) findViewById(R.id.btnCrear);
        btnActualizar= (Button) findViewById(R.id.btn_Actualizar);
        sp_Categoria = findViewById(R.id.spCategoria);
        sp_Categoria.setOnItemSelectedListener(this);

        autos = (ListView) findViewById(R.id.lvAutos);


        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        listAutos();
       categoria();


       btnCrear.setOnClickListener(this);
       btnActualizar.setOnClickListener(this);


        autos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                autoSelected = (Automovil) parent.getItemAtPosition(position);
                nombreAuto.setText(autoSelected.getNombreAutomovil());
                tipoFreno.setText(autoSelected.getNombreFrenos());
                tipoMotor.setText(autoSelected.getNombreMotor());
                descripcion.setText(autoSelected.getDescripcion());
                //peso.setText((int) autoSelected.getPesoAutomovil());

            }
        });


    }
 private void categoria (){
     String [] categorias ={"Categoria 1", "Categoria 2", "Categoria 3"};
     sp_Categoria.setAdapter((new ArrayAdapter<String>(CrearAutos.this, android.R.layout.simple_spinner_dropdown_item, categorias)));

    }

    private void listAutos() {
        databaseReference.child("Automoviles").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listAutos.clear();
                for (DataSnapshot auto : dataSnapshot.getChildren()){
                    Automovil a = auto.getValue(Automovil.class);
                    a.setNombreAutomovil(auto.getKey());
                    a.setPesoAutomovil(Float.parseFloat(auto.child("pesoAutomovil").getValue().toString()));
                    a.setNombreMotor(auto.child("nombreMotor").getValue().toString());
                    a.setDescripcion(auto.child("descripcion").getValue().toString());
                    a.setNombreFrenos(auto.child("nombreFrenos").getValue().toString());
                    a.setImagenAutomovil(Integer.parseInt(auto.child("imagenAutomovil").getValue().toString()));
                    a.setCategoria(auto.child("categoria").getValue().toString());
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
        String descrip = descripcion.getText().toString();
        String categ = sp_Categoria.toString();
        String bujiaa = bujia.toString();
        String potenciaa = potencia.toString();
        String pso = peso.getText().toString();


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

        if (TextUtils.isEmpty(descrip)){
            Toast.makeText(this, "Por favor ingrese una descripcion", Toast.LENGTH_SHORT).show();
            return;
        }


        else {
            Automovil a = new Automovil();
            Bujia b = new Bujia();



            a.setNombreAutomovil(nombre);
            a.setNombreFrenos(freno);
            a.setNombreMotor(motor);
            a.setDescripcion(descrip);
            a.setCategoria(categ);
            //a.setPesoAutomovil(pso);
            b.setTipoBujia(bujiaa);
           // b.setPotencia(potenciaa);
//Firebase
            databaseReference.child("Automoviles").child(a.getNombreAutomovil()).setValue(a);
            databaseReference.child("Bujia").child(a.getNombreAutomovil()).setValue(a);
            Toast.makeText(this, "Agregado", Toast.LENGTH_SHORT).show();
            limpiarCajas();
        }



    }

    private void actualizar(){
        String nombre = nombreAuto.getText().toString();
        String freno = tipoFreno.getText().toString();
        String motor = tipoMotor.getText().toString();
        String categ = sp_Categoria.toString();
        String descrip = descripcion.getText().toString();
        // pso = peso.getText().toString();

        Automovil b = new Automovil();
        b.setNombreMotor(autoSelected.getNombreAutomovil());
        b.setNombreAutomovil(nombreAuto.getText().toString().trim());
        b.setNombreFrenos(tipoFreno.getText().toString().trim());
        b.setNombreMotor(tipoMotor.getText().toString().trim());
        b.setCategoria(sp_Categoria.getSelectedItem().toString().trim());


        databaseReference.child("Automoviles").child(b.getNombreAutomovil()).setValue(b);
        Toast.makeText(this,"Actualizado", Toast.LENGTH_LONG).show();
        limpiarCajas();


    }

    private void limpiarCajas(){
        nombreAuto.setText("");
        tipoFreno.setText("");
        tipoMotor.setText("");
        descripcion.setText("");
        peso.setText("");



    }


    @Override
    public void onClick(View v) {
        Registrar();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}