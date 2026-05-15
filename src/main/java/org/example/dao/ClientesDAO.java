package org.example.dao;

import org.example.model.Clientes;

import java.util.List;

public interface ClientesDAO {

    void crear( Clientes cliente);
    Clientes leer(int id);
    void actualizar(Clientes clientes);
    void eliminar (Clientes clientes);
    List<Clientes> Listar();

}
