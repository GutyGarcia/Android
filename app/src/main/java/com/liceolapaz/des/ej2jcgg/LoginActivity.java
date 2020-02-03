package com.liceolapaz.des.ej2jcgg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {

    private Button login;
    private EditText usuario;
    private EditText contraseña;
    private TextView lblMensaje;
    private int intentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "androiddb", null, 1);

        login = (Button) findViewById(R.id.BtnLogin);
        usuario = (EditText) findViewById(R.id.usuario);
        contraseña = (EditText) findViewById(R.id.contraseña);
        lblMensaje = (TextView) findViewById(R.id.LblMensaje);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if("admin".equals(usuario.getText().toString()) && "liceo".equals(contraseña.getText().toString()) && intentos < 3){
                    Intent login = new Intent(LoginActivity.this, ListaActivity.class);
                    startActivity(login);
                }else{
                    lblMensaje.setVisibility(View.VISIBLE);
                    intentos++;
                }if (intentos >= 3){
                    System.exit(1);
                }
            }
        });
    }
}
