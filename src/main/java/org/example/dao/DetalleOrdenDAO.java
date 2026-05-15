package org.example.dao;

import org.example.model.DetalleOrden;


import java.util.List;

public interface DetalleOrdenDAO {

    void crear(DetalleOrden detalleOrden);
    DetalleOrden leer(int id);
    void actualizar(DetalleOrden detalleOrden);
    void eliminar (DetalleOrden detalleOrden);
    List<DetalleOrden> Listar();
}

