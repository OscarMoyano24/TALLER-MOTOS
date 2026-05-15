package org.example.dao;

import org.example.model.Clientes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAOImpl  implements  ClientesDAO{
    private final Connection connection;

    public ClientesDAOImpl( Connection connection){this.connection = connection;}

    @Override
    public void crear(Clientes clientes){
        String sql="INSERT INTO Clientes( id, nombre, telefono) VALUES (?,?,?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,clientes.getId());
            statement.setString(2, clientes.getNombre());
            statement.setString(3, clientes.getTelefono());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Clientes leer(int id){
        String sql = "SELECT * FROM Clientes WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return new Clientes(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("telefono")
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizar (Clientes clientes){
        String sql= "UPDATE Clientes SET  nombre=?, telefono=? WHERE id=?";
        try( PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, clientes.getNombre());
            statement.setString(2, clientes.getTelefono());
            statement.setInt(3, clientes.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public void eliminar(Clientes clientes){
        String sql = "DELETE FROM Clientes WHERE id=?";
        try (PreparedStatement statement= connection.prepareStatement(sql)){
            statement.setInt(1,clientes.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Clientes> Listar(){
        List<Clientes> Lista = new ArrayList<>();
        String sql = "SELECT * FROM Clientes";
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)){
             while (rs.next()){
                 Lista.add(new Clientes(
                         rs.getInt("id"),
                         rs.getString("nombre"),
                         rs.getString("telefono")
                 ));
             }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Lista;
    }

}

