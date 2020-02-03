package com.liceolapaz.des.ej2jcgg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AltaProductoActivity extends AppCompatActivity {

    private Button aceptar, cancelar;
    private Spinner spinner1;
    private EditText nombre, descripcion, precio, moneda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_alta_producto);
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


        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent login = new Intent(AltaProductoActivity.this, ListaActivity.class);
                startActivity(login);

            }
        });
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resgistrarProductos();
            }
        });
    }

    private void resgistrarProductos() {
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "androiddb", null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();
        db.execSQL(Utilidades.REGISTRAR_PRODUCTO);
        db.close();
    }
}
