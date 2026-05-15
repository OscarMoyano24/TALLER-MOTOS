package org.example.model;

public class Motos {
     private int id;
     private int cliente_id;
     private String placa;
     private String modelo;

    public Motos() {
    }

    public Motos(int id, int cliente_id, String placa, String modelo) {
        this.id = id;
        this.cliente_id = cliente_id;
        this.placa = placa;
        this.modelo = modelo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteid() {
        return cliente_id;
    }

    public void setClienteid(int clienteid) {
        this.cliente_id = clienteid;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Motos{" +
                "id=" + id +
                ", clienteid=" + cliente_id +
                ", placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
