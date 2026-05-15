package org.example.dao;

import org.example.model.Proveedores;


import java.util.List;

public interface ProveedoresDAO {

    void crear(Proveedores proveedores);
    Proveedores leer(int id);
    void actualizar(Proveedores proveedores);
    void eliminar (Proveedores proveedores);
    List<Proveedores> Listar();
}

