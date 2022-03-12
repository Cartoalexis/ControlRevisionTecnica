package com.example.controlrevisiontecnica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.controlrevisiontecnica.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        x = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(x.getRoot());

        x.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarLogin();
            }
        });
    }

    public void validarLogin(){
        String usuario = x.txtUsuario.getText().toString();
        String clave = x.txtContrasena.getText().toString();

        if(usuario.equals("tecnico") && clave.equals("tecnico123")){
            Intent intent = new Intent(this,Activity2.class);
            startActivity(intent);
        }

        else{
            x.txtUsuario.setText("");
            x.txtContrasena.setText("");
            Toast.makeText(this, "Cuenta no existe", Toast.LENGTH_SHORT).show();
        }


    }
}