package org.example.dao;


import org.example.model.Ordenes;

import java.util.List;

public interface OrdenesDAO {
    void crear(Ordenes ordenes);
    Ordenes leer(int id);
    void actualizar(Ordenes ordenes);
    void eliminar (Ordenes ordenes);
    List<Ordenes> Listar();
}
