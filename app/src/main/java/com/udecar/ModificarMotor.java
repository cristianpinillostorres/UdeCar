package com.udecar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.udecar.Datos.Motor;

import java.util.ArrayList;

public class ModificarMotor extends AppCompatActivity {

    private Spinner listaBujias;
    //private Spinner listaFiltros;
    private Motor motor1;
    //Objeto que apunta a la potencia ORIGINAL del motor
    private TextView rOriginal;
    //Objeto que apunta a la potencia con las modificacioens hechas
    private TextView rModificado;

    //-----------------------------------------------------
    //Aquí debe llegar el documento (tupla) desde el catálogo de modelos de autos

    private float potenciaO = 111;
    private float cilindraje = 1598;
    private int idMotor = 1;
    private String nombreMotor = "Motor Renault Stepway";
    //private String nombreAuto;
    //private ImageView imagenAuto;

    //-----------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_motor);

        //inicializar componentes
        listaBujias = (Spinner) findViewById(R.id.ddl_listaBujias);
        //listaFiltros = (Spinner) findViewById(R.id.ddl_listaFiltros);// 6% a la potencia
        rOriginal = findViewById(R.id.tvRendimientoO);
        rModificado = findViewById(R.id.tvRendimientoM);

        final TextView labelInfo = findViewById(R.id.infoMotor);
        motor1 = new Motor(idMotor,nombreMotor,cilindraje,potenciaO);

        String informacion = "Nombres: "+motor1.getNombreMotor()+"\n"+"Cilindraje: "+motor1.getCilindraje()+"\n"+"Potencia: "+motor1.getPotencia()+"\n";
        rOriginal.setText("Horse power: "+ motor1.getPotencia());
        labelInfo.setText(informacion);

        //Llenar Spinner
        LlenarSpiner();
    }

    public void LlenarSpiner(){
        PartesMotor parte1 = new PartesMotor(1, 1,"U-GROOVE K20PR-U11");                //Ejemplo, mejora 6%
        PartesMotor parte2 = new PartesMotor(2, 1,"PLATINUM TT PK20TT");                //Mejora 4%
        PartesMotor parte3 = new PartesMotor(3, 1,"DOUBLE PLATINUM PK20PR11");          //Mejora 5.5%
        PartesMotor parte4 = new PartesMotor(4, 1,"IRIDIUM LONG LIFE SK20PR-L11");      //Mejora 2.3%
        PartesMotor parte5 = new PartesMotor(5, 1,"IRIDIUM POWER IK20");                //Mejora 4.5%
        //Creacion del arrayList de tipo "PartesMotor"
        ArrayList<String> bujias = new ArrayList<>();
        //llenado del arrayList
        bujias.add(parte1.getNombreParte());
        bujias.add(parte2.getNombreParte());
        bujias.add(parte3.getNombreParte());
        bujias.add(parte4.getNombreParte());
        bujias.add(parte5.getNombreParte());

        //adaptador de tipo arrayList para el spinner
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, bujias);
        listaBujias.setAdapter(adaptador);

        listaBujias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"selecciono: "+parent.getItemAtPosition(position).toString() ,Toast.LENGTH_SHORT).show();
                switch(listaBujias.getSelectedItem().toString()){
                    case "U-GROOVE K20PR-U11":
                        motor1.setPotencia((float) (potenciaO+( potenciaO*0.06)));
                        break;
                    case "PLATINUM TT PK20TT":
                        motor1.setPotencia((float) (potenciaO+( potenciaO*0.04)));
                        break;
                    case "DOUBLE PLATINUM PK20PR11":
                        motor1.setPotencia((float) (potenciaO+( potenciaO*0.055)));
                        break;
                    case "IRIDIUM LONG LIFE SK20PR-L11":
                        motor1.setPotencia((float) (potenciaO+( potenciaO*0.023)));
                        break;
                    case "IRIDIUM POWER IK20":
                        motor1.setPotencia((float) (potenciaO+( potenciaO*0.045)));
                        break;
                    default:
                        break;
                }
                rModificado.setText("hp: "+motor1.getPotencia());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void ObtenerSeleccion(){
        PartesMotor parteSeleccionada = (PartesMotor) listaBujias.getSelectedItem();
        String mensaje = parteSeleccionada.getNombreParte()+" ha sido seleccionada";
        Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
    }

}