package com.liceolapaz.des.ej2jcgg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {

    ImageButton añadir;
    ListView listViewProductos;
    ArrayList<String> listaInformacion;
    ArrayList<Producto> listaProductos;
    ConexionSQLiteHelper conexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        conexion = new ConexionSQLiteHelper(getApplicationContext(), "androidbd", null,1);
        añadir = (ImageButton) findViewById(R.id.añadir);
        listViewProductos = (ListView) findViewById(R.id.listaProductos);

        consultarListaProductos();

        ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        listViewProductos.setAdapter(adaptador);


        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent login = new Intent(ListaActivity.this, AltaProductoActivity.class);
                startActivity(login);


            }
        });
    }

    private void consultarListaProductos() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Producto producto = null;

        listaProductos = new ArrayList<Producto>();
        Cursor cursor = db.rawQuery(Utilidades.CONSULTAR_TABLA, null);

        while(cursor.moveToNext()){
            producto = new Producto();
            producto.setId(cursor.getInt(0));
            producto.setNombre(cursor.getString(1));
            producto.setDescripcion(cursor.getString(2));
            producto.setPrecio(cursor.getInt(3));
            producto.setMoneda(cursor.getString(4));

            listaProductos.add(producto);
        }
        obtenerLista();
    }
    private void obtenerLista(){
        listaInformacion = new ArrayList<String>();

        for(int i = 0; i < listaProductos.size(); i++){
            listaInformacion.add(listaProductos.get(i).getId()+ " - " + listaProductos.get(i).getNombre());
        }
    }
}
