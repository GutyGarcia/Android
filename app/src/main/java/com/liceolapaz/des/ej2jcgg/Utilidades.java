package com.liceolapaz.des.ej2jcgg;

public class Utilidades {

    public static final String TABLA_PRODUCTO = "productos";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_DESCRIPCION = "descripcion";
    public static final String CAMPO_PRECIO = "precio";
    public static final String CAMPO_MONEDA = "moneda";

    public static final String CREAR_TABLA_PRODUCTOS = "CREATE TABLE IF NOT EXISTS " + TABLA_PRODUCTO +
            " ("+ CAMPO_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
            " " + CAMPO_NOMBRE  + "  VARCHAR(45) NOT NULL,"  +
            " " + CAMPO_DESCRIPCION + " VARCHAR(45) NOT NULL," +
            " " + CAMPO_PRECIO + " DECIMAL(5.0) NOT NULL, " +
            " " +CAMPO_MONEDA +" VARCHAR(45) NOT NULL)";

    public static final String REGISTRAR_PRODUCTO = "INSERT INTO " + TABLA_PRODUCTO + "(nombre, descripcion, precio, moneda)" +
            "values(" + CAMPO_NOMBRE +" ," +CAMPO_DESCRIPCION + "," + CAMPO_PRECIO + "," + CAMPO_MONEDA+ ")";

    public static final String ELIMINAR_PRODUCTO = "DELETE FROM " + TABLA_PRODUCTO + "WHERE id = " + CAMPO_ID ;
    public static final String MODIFICAR_PRODUCTO = "UPDATE " + TABLA_PRODUCTO + "(nombre, descripcion, precio, moneda)" +
            "values(" + CAMPO_NOMBRE +" ," +CAMPO_DESCRIPCION + "," + CAMPO_PRECIO + "," + CAMPO_MONEDA+ ")";

    public static final String CONSULTAR_TABLA = "SELECT * FROM " + TABLA_PRODUCTO + "ORDER BY id";

}
