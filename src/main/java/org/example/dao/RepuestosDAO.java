package org.example.dao;

import org.example.model.Repuestos;

import java.util.List;

public interface RepuestosDAO {

    void crear(Repuestos repuestos);
    Repuestos leer(int id);
    void actualizar(Repuestos repuestos);
    void eliminar (Repuestos repuestos);
    List<Repuestos> Listar();
}


