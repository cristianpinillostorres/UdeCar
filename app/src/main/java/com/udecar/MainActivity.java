package com.udecar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void vistaSeleccionarAuto(View view){
        Intent myintent = new Intent(MainActivity.this,VistaSeleccionarAuto.class);
        startActivity(myintent);
    }
    public void vistaAdminitrador(View view){
        Intent myintent = new Intent(MainActivity.this,CrearAutos.class);
        startActivity(myintent);
    }
    public void vistaRegistroUsuario(View view){
        Intent myintent = new Intent(MainActivity.this, Registro.class);
        startActivity(myintent);
    }

    public void iniciarSesion(View view){
        Intent myintent = new Intent(MainActivity.this, Login.class);
        startActivity(myintent);
    }

    @Override
    protected void onStart() {

        firebaseAuth = FirebaseAuth.getInstance();
        super.onStart();

        if (firebaseAuth.getCurrentUser() != null){
            startActivity(new Intent(MainActivity.this, PrincipalUsuario.class));
            finish();
        }
    }

}