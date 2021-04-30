package com.udecar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import com.udecar.Datos.Automovil;

public class VistaModificaciones extends AppCompatActivity {

    private TextView tv_NombreAuto, tv_InfoAuto;
    //private ImageView imgFoto;
    private Automovil auto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_modificaciones);

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
    }
        public void vistaModificarMotor (View view){
            Intent myintent = new Intent(VistaModificaciones.this, ModificarMotor.class);
            myintent.putExtra("item", auto);
            startActivity(myintent);
        }
        public void vistaModificarFrenos (View view){
            Intent myintent = new Intent(VistaModificaciones.this, ModificarFrenos.class);
            myintent.putExtra("item", auto);
            startActivity(myintent);
        }
}

