package com.liceolapaz.des.ej2jcgg;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class DetalleActivity extends AppCompatActivity {

    private Button aceptar, cancelar, eliminar;
    private Spinner spinner1;
    private EditText nombre, descripcion, precio,moneda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        nombre = (EditText) findViewById(R.id.nombre);
        descripcion = (EditText) findViewById(R.id.descripcion);
        precio = (EditText) findViewById(R.id.precio);
        cancelar = (Button) findViewById(R.id.boton_cancelar);
        aceptar = (Button) findViewById(R.id.boton_aceptar);
        spinner1 = (Spinner) findViewById(R.id.moneda);
        String[] opciones = {"Euro (€)", "Dólar USA($)", "Yen(¥)", "Libra esterlina(£)"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, opciones);

        spinner1.setAdapter(adapter);

        aceptar = (Button) findViewById(R.id.boton_aceptar);
        cancelar = (Button) findViewById(R.id.boton_cancelar);
        eliminar = (Button) findViewById(R.id.boton_eliminar);

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent login = new Intent(DetalleActivity.this, ListaActivity.class);
                startActivity(login);

            }
        });
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resgistrarProductos();
            }
        });
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarProducto();
            }
        });
    }

    private void resgistrarProductos() {
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "androiddb", null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();
        db.execSQL(Utilidades.REGISTRAR_PRODUCTO);
        db.close();
    }
    private void eliminarProducto() {
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "androiddb", null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();
        db.execSQL(Utilidades.ELIMINAR_PRODUCTO);
        db.close();
    }
    private void modificarProducto() {
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "androiddb", null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();
        db.execSQL(Utilidades.MODIFICAR_PRODUCTO);
        db.close();
    }
}

