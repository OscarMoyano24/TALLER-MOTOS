package org.example.dao;

import org.example.model.Repuestos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepuestosDAOImpl implements RepuestosDAO{
    private final Connection connection;

    public RepuestosDAOImpl(Connection connection){this.connection = connection;}

    @Override
    public void crear(Repuestos repuestos){
        String sql ="INSERT INTO Repuestos (id, proveedor_id, nombre, precio, stock) VALUES (?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,repuestos.getId());
            statement.setInt(2,repuestos.getProveedorid());
            statement.setString(3,repuestos.getNombre());
            statement.setDouble(4,repuestos.getPrecio());
            statement.setInt(5,repuestos.getStock());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Repuestos leer(int id){
        String sql = "SELECT * FROM  Repuestos WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return new Repuestos(
                        resultSet.getInt("id"),
                        resultSet.getInt("proveedor_id"),
                        resultSet.getString("nombre"),
                        resultSet.getDouble("precio"),
                        resultSet.getInt("stock")
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizar (Repuestos repuestos){
        String sql= "UPDATE Repuestos SET proovedor_id=?, nombre=?, precio=?, stock=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,repuestos.getProveedorid());
            statement.setString(2,repuestos.getNombre());
            statement.setDouble(3,repuestos.getPrecio());
            statement.setInt(4,repuestos.getStock());
            statement.setInt(5,repuestos.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Repuestos repuestos){
        String sql = "DELETE FROM Repuestos WHERE id=?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,repuestos.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Repuestos> Listar() {
        List<Repuestos> lista = new ArrayList<>();
        String sql= "SELECT * FROM Repuestos";
        try(Statement statement = connection.createStatement();
            ResultSet rs= statement.executeQuery(sql)) {
            while (rs.next()){
                lista.add(new Repuestos(
                        rs.getInt("id"),
                        rs.getInt("proveedor_id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
}
