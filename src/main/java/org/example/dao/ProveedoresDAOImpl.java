package org.example.dao;

import org.example.model.Proveedores;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedoresDAOImpl implements  ProveedoresDAO{
    private final  Connection connection;

    public  ProveedoresDAOImpl(Connection connection){this.connection = connection;}

    @Override
    public void crear(Proveedores proveedores){
        String sql = "INSERT INTO Proveedores (id,nombre,telefono,direccion) VALUES (?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,proveedores.getId());
            statement.setString(2,proveedores.getNombre());
            statement.setString(3,proveedores.getTelefono());
            statement.setString(4,proveedores.getDireccion());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Proveedores leer(int id){
        String sql = "SELECT * FROM Proveedores WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,id);
            ResultSet resultSet= statement.executeQuery();
            if (resultSet.next()){
                return new Proveedores(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("telefono"),
                        resultSet.getString("direccion")
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void actualizar (Proveedores proveedores){
        String sql = "UPDATE Proveedores SET nombre=?, telefono=?, direccion=? WHERE id=?";
        try(PreparedStatement statement=connection.prepareStatement(sql)) {
            statement.setString(1,proveedores.getNombre());
            statement.setString(2, proveedores.getTelefono());
            statement.setString(3,proveedores.getDireccion());
            statement.setInt(4,proveedores.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public  void eliminar(Proveedores proveedores){
        String sql = "DELETE FROM Proveedores WHERE id=?";
        try (PreparedStatement statement= connection.prepareStatement(sql)){
            statement.setInt(1,proveedores.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Proveedores> Listar(){
        List<Proveedores> lista = new ArrayList<>();
        String sql ="SELECT * FROM Proveedores";
        try(Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()){
                lista.add(new Proveedores(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("direccion")
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

}
