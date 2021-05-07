package com.udecar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.udecar.Datos.Automovil;
import com.udecar.Datos.Motor;

import java.util.ArrayList;

public class VistaModificaciones extends AppCompatActivity {

    private DatabaseReference dataBaseM;
    private TextView tv_NombreAuto, tv_InfoAuto;
    private ArrayList<Motor> arrayMotores = new ArrayList<>();
    //private ImageView imgFoto;
    private Automovil auto;
    private Motor motor = new Motor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_modificaciones);

        dataBaseM = FirebaseDatabase.getInstance().getReference().child("Motor");
        //trae la informacion del item seleccionado
        auto = (Automovil) getIntent().getSerializableExtra("item");

        if (auto != null) {
            tv_NombreAuto = findViewById(R.id.tv_nombreAuto);
            tv_InfoAuto = findViewById(R.id.tv_infoAuto);
            //imgFoto = findViewById(R.id.img_imagenAuto);

            // LLENAMOS LOS ELEMENTOS CON LOS VALORES DE CADA ITEM
            String informacion = "Nombre: " + auto.getNombreAutomovil() + "\n" +
                    "Descripcion: " + auto.getDescripcion() + "\n";
            //imgFoto.setImageResource(auto.getImagenAutomovil());
            tv_NombreAuto.setText(auto.getNombreAutomovil());
            tv_InfoAuto.setText(informacion);
        }

        listarDatos();

    }

    private void listarDatos() {
        dataBaseM.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot templateSnapshot : snapshot.getChildren()){
                        Motor motores = templateSnapshot.getValue(Motor.class);
                        arrayMotores.add(motores);
                    }
                    System.out.println("######## "+arrayMotores.size());

                    for (int i=0;i<arrayMotores.size();i++) {
                        if (auto.getNombreMotor().equals(arrayMotores.get(i).getNombreMotor())) {
                            motor.setNombreMotor(arrayMotores.get(i).getNombreMotor());
                            motor.setCilindraje((long) arrayMotores.get(i).getCilindraje());
                            motor.setPotencia((long) arrayMotores.get(i).getPotencia());
                            motor.setTipoBujia(arrayMotores.get(i).getTipoBujia());
                            motor.setTipoFiltro(arrayMotores.get(i).getTipoFiltro());
                        }
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void vistaModificarMotor (View view){
        Intent myintent = new Intent(VistaModificaciones.this, ModificarMotor.class);
        myintent.putExtra("itemMotor", motor);
        startActivity(myintent);
    }

    public void vistaModificarFrenos (View view){
        Intent myintent = new Intent(VistaModificaciones.this, ModificarFrenos.class);
        myintent.putExtra("item", auto);
        startActivity(myintent);
    }

}

