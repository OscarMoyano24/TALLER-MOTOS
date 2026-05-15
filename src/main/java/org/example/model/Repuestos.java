package org.example.model;

public class Repuestos {
    private int id;
    private int proveedor_id;
    private String nombre;
    private  double precio;
    private int stock;

    public Repuestos() {
    }

    public Repuestos(int id, int proveedor_id, String nombre, double precio, int stock) {
        this.id = id;
        this.proveedor_id = proveedor_id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProveedorid() {
        return proveedor_id;
    }

    public void setProveedorid(int proveedorid) {
        this.proveedor_id = proveedorid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Repuestos{" +
                "id=" + id +
                ", proveedorid=" + proveedor_id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}
