package com.udecar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.api.Authentication;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    private EditText txtEmail;
    private EditText txtNombre;
    private EditText txtContraseña;
    private Button btnRegistrar;
    private ProgressDialog progressDialog;

    private String nombre = "";
    private String email = "";
    private String password = "";

    private FirebaseAuth firebaseAuth;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        firebaseAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        txtEmail = (EditText)  findViewById(R.id.TxtEmail);
        txtContraseña = (EditText) findViewById(R.id.TxtContraseña);
        txtNombre = (EditText) findViewById(R.id.TxtNombre);

        btnRegistrar = (Button) findViewById(R.id.botonRegistrar);

        progressDialog = new ProgressDialog(this);

        btnRegistrar.setOnClickListener(this);

    }

    private void registrarUsuario(){

        final String email = txtEmail.getText().toString().trim();
        final String password = txtContraseña.getText().toString().trim();
        final String nombre = txtNombre.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Por favor ingrese un correo", Toast.LENGTH_SHORT).show();
            return;
        }

            if (TextUtils.isEmpty(password)){
                Toast.makeText(this, "Por favor ingrese una contraseña", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(nombre)){
                Toast.makeText(this, "Por favor ingrese un nombre", Toast.LENGTH_SHORT).show();
                return;
            }

            progressDialog.setMessage("Realizando proceso en linea");
            progressDialog.show();

            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener (this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){

                                Map<String, Object> map = new HashMap<>();
                                map.put("nombre", nombre);
                                map.put("correo", email);
                                map.put("contraseña", password);


                                String id = firebaseAuth.getCurrentUser().getUid();

                                mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task2) {
                                        if(task2.isSuccessful()){
                                            startActivity(new Intent(Registro.this, PrincipalUsuario.class));
                                            finish();
                                        }

                                    }
                                });

                                Toast.makeText(Registro.this, "se ha registrado el email", Toast.LENGTH_LONG).show();
                            }else{
                                if (task.getException() instanceof FirebaseAuthUserCollisionException){
                                    Toast.makeText(Registro.this, "Este usuario ya existe ", Toast.LENGTH_LONG).show();
                                }else{
                                    Toast.makeText(Registro.this, "No se pudo registrar el usuario. Intente nuevamente ", Toast.LENGTH_LONG).show();
                                }
                            }

                            progressDialog.dismiss();
                        }

                    });

        }
    @Override
    public void onClick (View view){

        registrarUsuario();
    }


}