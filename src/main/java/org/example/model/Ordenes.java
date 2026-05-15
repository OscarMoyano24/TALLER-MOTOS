package org.example.model;

public class Ordenes {
    private int id;
    private int moto_id;
    private String descripcion;
    private double costo_total;

    public Ordenes() {
    }

    public Ordenes(int id, int moto_id, String descripcion, double costo_total) {
        this.id = id;
        this.moto_id = moto_id;
        this.descripcion = descripcion;
        this.costo_total = costo_total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMotoid() {
        return moto_id;
    }

    public void setMotoid(int motoid) {
        this.moto_id = motoid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCostototal() {
        return costo_total;
    }

    public void setCostototal(double costototal) {
        this.costo_total = costototal;
    }

    @Override
    public String toString() {
        return "Ordenes{" +
                "id=" + id +
                ", motoid=" + moto_id +
                ", descripcion='" + descripcion + '\'' +
                ", costototal=" + costo_total +
                '}';
    }
}
