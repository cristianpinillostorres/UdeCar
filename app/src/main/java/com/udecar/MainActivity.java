package com.udecar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Automovil automovil1 = new Automovil(1, "spark", 3.67f, 56.8f, "motorA", "abs", "automatica");
        //Motor motorA = new motor(1,1500,4,1000,3000,"Inteccion directa");
        final TextView labelNombre = findViewById(R.id.tv_nombreAuto);
        final TextView labelTamaño = findViewById(R.id.tv_tamañoAuto);
        final TextView labelPeso = findViewById(R.id.tv_pesoAuto);
        final TextView labelMotor = findViewById(R.id.tv_motorAuto);
        final TextView labelFrenos = findViewById(R.id.tv_frenosAuto);
        final TextView labelTrasmision = findViewById(R.id.tv_transmisionAuto);

        labelNombre.setText("Nombre: "+automovil1.getNombreAutomovil());
        labelTamaño.setText("Tamaño: "+String.valueOf(automovil1.getTamañoAutomovil()));
        labelPeso.setText("Peso: "+String.valueOf(automovil1.getPesoAutomovil()));
        labelMotor.setText("Motor: "+automovil1.getMotorAutomovil());
        labelFrenos.setText("Frenos: "+automovil1.getFrenosAutomovil());
        labelTrasmision.setText("Transmision: "+automovil1.getTransmisionAutomovil());
    }
    public void vistaModificarMotor(View view){
        Intent myintent = new Intent(MainActivity.this,ModificarMotor.class);
        startActivity(myintent);
    }
    public void vistaModificarFrenos(View view){
        Intent myintent = new Intent(MainActivity.this,ModificarFrenos.class);
        startActivity(myintent);
    }
    public void vistaModificarTransmision(View view){
        Intent myintent = new Intent(MainActivity.this,ModificarTransmision.class);
        startActivity(myintent);
    }


}