package com.udecar.Firebase;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class FirebaseService {

    //Objeto para instanciar la base de datos Firebase
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    //private CollectionReference listaAutos = db.collection("automovil");

    //Objeto consulta a todos los automoviles de la base de datos
    //private Query listaAutomoviles = db.collection("automovil");


    //Variables de ejemplo (ELIMINAR LUEGO DE PRUEBAS)
    private static  String email = "", nombre = "", password = "";

    //Variable booleana para controlar que se cumpla o no una tarea;
    private static boolean completado = false ;


    //Prueba de nuevo usuario, NO ESTÁ DEFINIDO
    private void nuevoUsuario(String email,String password,String nombre){

        this.email = email;
        this.password = password;
        this.nombre = nombre;

        Map<String , Object> usuario = new HashMap<>();
        usuario.put("Email",this.email);
        usuario.put("Contraseña",this.password);
        usuario.put("Nombre",this.nombre);

        db.collection("usuarios").add(usuario).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if(task.isSuccessful()){
                    //Toast.makeText(MainActivity.this,"Registro exitoso",Toast.LENGTH_SHORT).show();
                }
                else{
                    //Toast.makeText(MainActivity.this,"Registro exitoso",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    // <--------------------------- Inserción de nueva bujía --------------------------->

    // Idea, devolver un booleano al activity que está solicitando el método para generar un mensaje
    // desde la pestaña del activity ya que desde aquí no se puede generar la notificación.

    private boolean nuevaBujia(String tipoBujia,float potencia){


        //Objeto tipo HashMap para almacenar en Firestore
        Map<String , Object> bujia = new HashMap<>();
        bujia.put("potencia",potencia);

        /*Parámetros, nombre de la colección (tabla) "db.collection()", nombre que por el que se va
        a identificar documento (llave primaria) ".document()" y objeto tipo HashMap que va a
        almacenarse como objeto JSON .set()*/

        db.collection("bujia").document(tipoBujia).set(bujia).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    completado = true;
                }
            }
        });
        return completado;
    }

    // <-------------------------------------------------------------------------------->

    // <--------------------------- Inserción de nuevo modelo de automóvil --------------------------->

    private boolean nuevoAuto(String nombreAuto, String nombreMotor, String nombreFrenos, String categoria, float cilindraje, float potencia, String tipoBujia, String tipoFiltro, float peso){

        Map<String , Object> auto = new HashMap<>();
        auto.put("nombreMotor",nombreMotor);
        auto.put("nombreFrenos",nombreFrenos);
        auto.put("categoria",categoria);
        auto.put("cilindraje",cilindraje);
        auto.put("potencia",potencia);
        auto.put("tipoBujia",tipoBujia);
        auto.put("tipoFiltro", tipoFiltro);
        auto.put("peso",peso);

        /*Parámetros, nombre de la colección (tabla) "db.collection()", nombre que por el que se va
        a identificar documento (llave primaria) ".document()" y objeto tipo HashMap que va a
        almacenarse como objeto JSON .set()*/

        db.collection("automoviles").document(nombreAuto).set(auto).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    completado = true;
                }
            }
        });

        return completado;
    }

    // <---------------------------------------------------------------------------------------------->

    // <------------------------------ Obtener listado de autos ------------------------------>

    public void obtenerAutos (){
        db.collection("automovil").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot documento : task.getResult()) {
                        documento.getId();
                        documento.getData();
                    }
                }else{
                    task.getException();
                }
            }
        });
    }

    // <-------------------------------------------------------------------------------------->


    public FirebaseFirestore getDb() {
        return db;
    }

    public void setDb(FirebaseFirestore db) {
        this.db = db;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        FirebaseService.email = email;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        FirebaseService.nombre = nombre;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        FirebaseService.password = password;
    }

    public static boolean isCompletado() {
        return completado;
    }

    public static void setCompletado(boolean completado) {
        FirebaseService.completado = completado;
    }
}
