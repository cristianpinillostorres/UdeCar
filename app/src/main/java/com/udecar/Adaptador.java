package com.udecar;
/*
Clase que permite llenar la lista dinamica de automoviles
 */
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.udecar.Datos.Automovil;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private ArrayList<Automovil> listaAutos;
    private Context context;
    private LayoutInflater inflater;

    public Adaptador(Context context, ArrayList<Automovil> listaAutos) {
        this.context = context;
        this.listaAutos = listaAutos;
    }

    @Override
    public int getCount() {
        return listaAutos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaAutos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // OBTENER EL OBJETO POR CADA ITEM A MOSTRAR
        final Automovil automovil = (Automovil) getItem(position);
        // CREAMOS E INICIALIZAMOS LOS ELEMENTOS DEL ITEM DE LA LISTA
        convertView = LayoutInflater.from(context).inflate(R.layout.lista_carros, null);
        ImageView img_Auto= (ImageView) convertView.findViewById(R.id.img_Auto);
        TextView tv_NombreAuto = (TextView) convertView.findViewById(R.id.tv_NombreAuto);
        TextView tv_InfoAuto = (TextView) convertView.findViewById(R.id.tv_InfoAuto);
        // LLENAMOS LOS ELEMENTOS CON LOS VALORES DE CADA ITEM
        String informacion = "Nombre: "+automovil.getNombreAutomovil()+"\n"+
                "Descripcion: "+String.valueOf(automovil.getDescripcion())+"\n" +
                "Peso: "+String.valueOf(automovil.getPesoAutomovil())+"\n";

        img_Auto.setImageResource(automovil.getImagenAutomovil());
        tv_NombreAuto.setText(automovil.getNombreAutomovil());
        tv_InfoAuto.setText(informacion);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VistaModificaciones.class);
                intent.putExtra("item", automovil);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
