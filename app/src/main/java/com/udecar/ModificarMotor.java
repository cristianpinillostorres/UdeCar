package com.udecar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.udecar.Datos.Automovil;
import com.udecar.Datos.Bujia;
import com.udecar.Datos.Motor;
import com.udecar.Datos.PartesMotor;

import java.util.ArrayList;

public class ModificarMotor extends AppCompatActivity {
    private Motor motor;

    private Spinner listaBujias;
    private Spinner listaFiltros;
    private TextView labelInfo;
    private TextView labelNombre;
    private TextView labelRendimientoModificado;
    private TextView labelPorcentaje;

    private float potenciaMotor = 0;

    private DatabaseReference dataBase;

    private ArrayList<String> bujias = new ArrayList<>();
    private ArrayList<Bujia> bujiaQUERY = new ArrayList<>();

    private String bujiaSeleccionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_motor);

        dataBase = FirebaseDatabase.getInstance().getReference();
        //llamado de clase del activity anterior
        motor = (Motor) getIntent().getSerializableExtra("itemMotor");
        //inicializar componentes
        listaBujias = (Spinner) findViewById(R.id.ddl_listaBujias);
        listaFiltros = (Spinner) findViewById(R.id.ddl_listaFiltros);
        labelPorcentaje = findViewById(R.id.tv_porcentajeRendimiento);
        labelRendimientoModificado = findViewById(R.id.tv_rendimientoModificado);
        labelNombre = findViewById(R.id.tv_nombreMotor);
        labelInfo = findViewById(R.id.infoMotor);

        String nombre = motor.getNombreMotor();
        String informacion =  "Cilindraje: " + motor.getCilindraje() + "\n" +
                              "Potencia: " + motor.getPotencia() + "\n" +
                              "Bujias: " + motor.getTipoBujia() + "\n" +
                              "Filtros: " + motor.getTipoFiltro()+ "\n";
        potenciaMotor = motor.getPotencia();
        labelNombre.setText(nombre);
        labelInfo.setText(informacion);
        labelRendimientoModificado.setText(""+motor.getPotencia());
         //Llenar Spinner
        bujias.add("--Seleccionar--");
        LlenarSpinerBujias();
        LlenarSpinerFiltros();
        listaBujias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bujiaSeleccionada = listaBujias.getSelectedItem().toString();
                if (bujiaSeleccionada.equals("--Seleccionar--")){
                    motor.setPotencia((potenciaMotor));
                    labelPorcentaje.setText(" - Sin modificar");
                    labelRendimientoModificado.setText(""+motor.getPotencia());
                }else{
                    dataBase.child("Bujia").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.exists()){
                                for (DataSnapshot bujiaQuery : snapshot.getChildren()){
                                    Bujia bujiaModificada = bujiaQuery.getValue(Bujia.class);
                                    if (bujiaModificada.getTipoBujia().equals(bujiaSeleccionada)){
                                        motor.setPotencia((potenciaMotor+( potenciaMotor*bujiaModificada.getPotencia())));
                                        labelPorcentaje.setText(" -  Aumenta "+(bujiaModificada.getPotencia()*100)+"%");
                                        labelRendimientoModificado.setText(""+motor.getPotencia());
                                    }
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(ModificarMotor.this,"Error modificando bujia",Toast.LENGTH_LONG).show();

                        }
                    });
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }

    public void LlenarSpinerBujias(){

        dataBase.child("Bujia").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    for(DataSnapshot bujia : snapshot.getChildren()){
                        Bujia bujiaSpinner = bujia.getValue(Bujia.class);
                        bujias.add(bujiaSpinner.getTipoBujia());
                    }
                    ArrayAdapter<String> adaptador = new ArrayAdapter<>(ModificarMotor.this, R.layout.support_simple_spinner_dropdown_item, bujias);
                    listaBujias.setAdapter(adaptador);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ModificarMotor.this,"Error con la base de datos: bujia",Toast.LENGTH_LONG).show();
            }
        });

    }
    public void LlenarSpinerFiltros(){
        //Partes de tipo Filtros de prueba
        PartesMotor parte6 = new PartesMotor(6, 2,"U-GROOVE K20PR-U11");
        PartesMotor parte7 = new PartesMotor(7, 2,"PLATINUM TT PK20TT");
        PartesMotor parte8 = new PartesMotor(8, 2,"DOUBLE PLATINUM PK20PR11");


        //Creacion del arrayList de tipo "PartesMotor"
        ArrayList<String> filtros = new ArrayList<>();
        //llenado del arrayList
        filtros.add(parte6.getNombreParte());
        filtros.add(parte7.getNombreParte());
        filtros.add(parte8.getNombreParte());
        //adaptador de tipo arrayList para el spinner que muestra las bujias
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, filtros);
        listaFiltros.setAdapter(adaptador);

        //Evento Spiner
        listaBujias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }


}