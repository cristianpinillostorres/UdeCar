package com.udecar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class PrincipalUsuario extends AppCompatActivity {
public static final String user = "name";

private Button btnCerrarSesion;
private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_usuario);

        mAuth = FirebaseAuth.getInstance();
        btnCerrarSesion = (Button) findViewById(R.id.btn_terminar);

        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(PrincipalUsuario.this, Login.class));
                finish();
            }
        });
    }
}