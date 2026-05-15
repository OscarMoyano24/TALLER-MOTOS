package org.example.model;

public class DetalleOrden {
    private int id;
    private int orden_id;
    private int repuesto_id;
    private int cantidad;
    private double subtotal;

    public DetalleOrden() {
    }

    public DetalleOrden(int id, int orden_id, int repuesto_id, int cantidad, double subtotal) {
        this.id = id;
        this.orden_id = orden_id;
        this.repuesto_id = repuesto_id;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrdenid() {
        return orden_id;
    }

    public void setOrdenid(int ordenid) {
        this.orden_id = ordenid;
    }

    public int getRepuestoid() {
        return repuesto_id;
    }

    public void setRepuestoid(int repuestoid) {
        this.repuesto_id = repuestoid;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "DetalleOrden{" +
                "id=" + id +
                ", ordenid=" + orden_id +
                ", repuestoid=" + repuesto_id +
                ", cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                '}';
    }
}
