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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private EditText txtEmail;
    private EditText txtContraseña;
    private Button btnIngresar;
    private Button btnRecuperar;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        txtEmail = (EditText)  findViewById(R.id.TextEmail);
        txtContraseña = (EditText) findViewById(R.id.TextPassword);


        btnIngresar = (Button) findViewById(R.id.btnLogin);
        btnRecuperar = (Button) findViewById(R.id.btnRecuperarContraseña);

        progressDialog = new ProgressDialog(this);

        btnIngresar.setOnClickListener(this);

        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, RecuperarContra.class));
            }
        });
    }


    private void ingresarUsuario(){

        final String email = txtEmail.getText().toString().trim();
        String password = txtContraseña.getText().toString().trim();


        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Por favor ingrese un correo", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Por favor ingrese una contraseña", Toast.LENGTH_SHORT).show();
            return;
        }



        progressDialog.setMessage("Realizando proceso en line");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener (this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this, "Bienvenido", Toast.LENGTH_LONG).show();
                            Intent intencion = new Intent(getApplication(),PrincipalUsuario.class);
                            intencion.putExtra(PrincipalUsuario.user, email);
                            startActivity(intencion);
                        }else{
                            Toast.makeText(Login.this, "No se pudo registrar el usuario. Intente nuevamente ", Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }

                });

    }
    @Override
    public void onClick (View view){

        ingresarUsuario();
    }


}