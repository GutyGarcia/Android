package com.liceolapaz.des.ej2jcgg;

public class Producto {

    private  int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private String moneda;

    public Producto(int id, String nombre, String descripcion, double precio, String moneda){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.moneda = moneda;
    }
    public Producto(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public String getMoneda(){
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
}
