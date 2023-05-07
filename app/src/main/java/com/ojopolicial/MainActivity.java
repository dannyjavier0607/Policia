package com.ojopolicial;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.Principal;

public class MainActivity extends AppCompatActivity {
    AlertDialog alerta = null;
    EditText usuario, contraseña;
    EditText usuario2,contraseña2;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        setTheme(R.style.Theme_OjoPolicial);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.usuario);
        contraseña = findViewById(R.id.contrasena);
        usuario2 = findViewById(R.id.usuario);
        contraseña2= findViewById(R.id.contrasena);

        btnlogin= (Button) findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (usuario2.getText().toString().equals("admin")&& contraseña2.getText().toString().equals("admin")){
                    startActivity(new Intent(MainActivity.this,Normaladmin.class));
                    Toast.makeText(MainActivity.this,"Credenciales Correctas!",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Credenciales Incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (usuario2.getText().toString().equals("admin")&& contraseña2.getText().toString().equals("admin")){
                    startActivity(new Intent(MainActivity.this,Normaladmin.class));
                    Toast.makeText(MainActivity.this,"Credenciales Correctas!",Toast.LENGTH_SHORT).show();
                }
                    if (usuario.getText().toString().equals("Superadmin")&& contraseña.getText().toString().equals("12345")){
                   startActivity(new Intent(MainActivity.this,MenuActivity.class));
                    Toast.makeText(MainActivity.this,"Credenciales Correctas!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Credenciales Incorrectas", Toast.LENGTH_SHORT).show();

                }
            }
        });

        getAlertaNotGps();
    }

    private void getAlertaNotGps() {
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("¿Permitir que OjoPolicial pueda acceder a la ubicación de este dispositivo?")
                .setCancelable(false)
                .setIcon(R.drawable.mapaicon)
                .setTitle("GPS")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@SuppressWarnings("unused")final DialogInterface dialog, @SuppressWarnings("unused")final int id) {
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));

                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, @SuppressWarnings("unused")final int id) {
                        dialog.cancel();
                    }
                });
        alerta = builder.create();
        alerta.show();
    }
}