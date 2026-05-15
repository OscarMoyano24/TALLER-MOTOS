package org.example.dao;

import org.example.model.Motos;

import java.util.List;

public interface MotosDAO {

    void crear (Motos motos);
    Motos leer(int id);
    void  actualizar(Motos motos);
    void eliminar (Motos motos);
    List<Motos> Listar();
}
