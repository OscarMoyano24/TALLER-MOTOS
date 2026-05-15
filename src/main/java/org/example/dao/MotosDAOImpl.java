package org.example.dao;


import org.example.model.Motos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotosDAOImpl implements MotosDAO{
    private final Connection connection;

    public  MotosDAOImpl(Connection connection){this.connection = connection;}

    @Override
    public void crear(Motos motos){
        String sql= "INSERT INTO Motos (id, cliente_id, placa, modelo) VALUES (?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, motos.getId());
            statement.setInt(2, motos.getClienteid());
            statement.setString(3,motos.getPlaca());
            statement.setString(4,motos.getModelo());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Motos leer(int id){
        String sql = "SELECT * FROM Motos WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);
            ResultSet resultSet= statement.executeQuery();
            if (resultSet.next()){
                return new Motos(
                        resultSet.getInt( "id"),
                        resultSet.getInt("cliente_id"),
                        resultSet.getString("placa"),
                        resultSet.getString("modelo")

                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizar(Motos motos){
        String sql = "UPDATE Motos SET cliente_id=?, placa=?, modelo=? WHERE id=? ";
        try ( PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,motos.getClienteid());
            statement.setString(2, motos.getPlaca());
            statement.setString(3, motos.getModelo());
            statement.setInt(4,motos.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar (Motos motos){
        String sql = "DELETE FROM Motos WHERE id=?";
        try (PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setInt(1, motos.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Motos> Listar(){
        List<Motos> Lista = new ArrayList<>();
        String sql = " SELECT * FROM Motos";
        try (Statement statement= connection.createStatement();
             ResultSet rs= statement.executeQuery(sql)){
            while (rs.next()){
                Lista.add(new Motos(
                        rs.getInt("id"),
                        rs.getInt("cliente_id"),
                        rs.getString("placa"),
                        rs.getString("modelo")
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Lista;
    }

}
