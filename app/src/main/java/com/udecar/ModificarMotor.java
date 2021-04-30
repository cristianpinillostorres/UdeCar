package com.udecar;

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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.udecar.Datos.Automovil;
import com.udecar.Datos.Motor;
import com.udecar.Datos.PartesMotor;

import java.util.ArrayList;

public class ModificarMotor extends AppCompatActivity {
    private Motor motor = new Motor();
    private Automovil auto;

    private Button btnGuardar;
    private Spinner listaBujias;
    private Spinner listaFiltros;
    private TextView labelInfo;
    private TextView labelNombre;
    private TextView labelRendimientoModificado;
    private TextView labelPorcentaje;

    private ArrayList<Motor> arrayMotores = new ArrayList<>();
    private float potenciaMotor = 0;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_motor);

        auto = (Automovil) getIntent().getSerializableExtra("item");

        //inicializar componentes
        listaBujias = findViewById(R.id.ddl_listaBujias);
        listaFiltros = findViewById(R.id.ddl_listaFiltros);
        btnGuardar =  findViewById(R.id.btn_guardarModMotor);
        labelPorcentaje = findViewById(R.id.tv_porcentajeRendimiento);
        labelRendimientoModificado = findViewById(R.id.tv_rendimientoModificado);
        labelNombre = findViewById(R.id.tv_nombreMotor);
        labelInfo = findViewById(R.id.infoMotor);

        //motor de prueba
        arrayMotores.add(new Motor(1,"Motor Renault",1598 ,110));
        arrayMotores.add(new Motor(2,"v8",1679 ,120));
        //valida que sea el mismo motor
        String nombre = "" ;
        String informacion = "";
        for (int i=0;i<arrayMotores.size();i++) {
            if (auto.getNombreMotor().equals(arrayMotores.get(i).getNombreMotor())) {
                motor.setIdMotor(arrayMotores.get(i).getIdMotor());
                motor.setNombreMotor(arrayMotores.get(i).getNombreMotor());
                motor.setCilindraje(arrayMotores.get(i).getCilindraje());
                motor.setPotencia(potenciaMotor = arrayMotores.get(i).getPotencia());

                nombre = arrayMotores.get(i).getNombreMotor();
                informacion =  "Cilindraje: " + arrayMotores.get(i).getCilindraje() + "\n" +
                                "Potencia: " + arrayMotores.get(i).getPotencia() + "\n" +
                                "Bujias: " + arrayMotores.get(i).getTipoBujia() + "\n" +
                                "Filtros: " + arrayMotores.get(i).getTipoFiltro()+ "\n";
            }
        }
        labelNombre.setText(nombre);
        labelInfo.setText(informacion);
         //Llenar Spinner
        LlenarSpinerBujias();
        LlenarSpinerFiltros();

    }

    public void LlenarSpinerBujias(){
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
        //adaptador de tipo arrayList para el spinner que muestra las bujias
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, bujias);
        listaBujias.setAdapter(adaptador);

        //Evento Spiner
        listaBujias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch(listaBujias.getSelectedItem().toString()){
                    case "U-GROOVE K20PR-U11":
                        motor.setPotencia((float) (potenciaMotor+( potenciaMotor*0.06)));
                        labelPorcentaje.setText(" -  Aumenta 6%");
                        break;
                    case "PLATINUM TT PK20TT":
                        motor.setPotencia((float) (potenciaMotor+( potenciaMotor*0.04)));
                        labelPorcentaje.setText(" -  Aumenta 4%");
                        break;
                    case "DOUBLE PLATINUM PK20PR11":
                        motor.setPotencia((float) (potenciaMotor+( potenciaMotor*0.055)));
                        labelPorcentaje.setText(" -  Aumenta 5.5%");
                        break;
                    case "IRIDIUM LONG LIFE SK20PR-L11":
                        motor.setPotencia((float) (potenciaMotor+( potenciaMotor*0.023)));
                        labelPorcentaje.setText(" -  Aumenta 2.3%");
                        break;
                    case "IRIDIUM POWER IK20":
                        motor.setPotencia((float) (potenciaMotor+( potenciaMotor*0.045)));
                        labelPorcentaje.setText(" -  Aumenta en 4.5%");
                        break;
                    default:
                        break;
                }
                labelRendimientoModificado.setText(""+motor.getPotencia());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
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
        listaFiltros.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }


}