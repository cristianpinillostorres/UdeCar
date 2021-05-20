package com.udecar;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Inicio extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inicio,container,false);
        return view;
    }

    public void vistaSeleccionarAuto(View view){
        Intent myintent = new Intent(getContext(),VistaSeleccionarAuto.class);
        startActivity(myintent);
    }
    public void vistaAdminitrador(View view){
        Intent myintent = new Intent(getContext(),CrearAutos.class);
        startActivity(myintent);
    }
    public void vistaRegistroUsuario(View view){
        Intent myintent = new Intent(getContext(), Registro.class);
        startActivity(myintent);
    }

    public void iniciarSesion(View view){
        Intent myintent = new Intent(getContext(), Login.class);
        startActivity(myintent);
    }
}