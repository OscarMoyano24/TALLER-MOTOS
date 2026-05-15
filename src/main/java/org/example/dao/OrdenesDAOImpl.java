package org.example.dao;

import org.example.model.Ordenes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdenesDAOImpl  implements  OrdenesDAO {
    private final Connection connection;

    public OrdenesDAOImpl(Connection connection){this.connection = connection;}

    @Override
    public void crear(Ordenes ordenes){
        String sql ="INSERT INTO Ordenes (id, moto_id, descripcion, costo_total) VALUES (?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, ordenes.getId());
            statement.setInt(2, ordenes.getMotoid());
            statement.setString(3,ordenes.getDescripcion());
            statement.setDouble(4,ordenes.getCostototal());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public Ordenes leer(int id){
        String sql = "SELECT * FROM Ordenes WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return new Ordenes(
                        resultSet.getInt("id"),
                        resultSet.getInt("moto_id"),
                        resultSet.getString("descripcion"),
                        resultSet.getDouble("costo_total")
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizar(Ordenes ordenes){
        String sql= "UPDATE Ordenes SET moto_id=?, descripcion=?, costototal=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, ordenes.getMotoid());
            statement.setString(2, ordenes.getDescripcion());
            statement.setDouble(3, ordenes.getCostototal());
            statement.setInt(4,ordenes.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Ordenes ordenes){
        String sql = "DELETE  FROM Ordenes WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,ordenes.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Ordenes> Listar(){
        List<Ordenes> Lista = new ArrayList<>();
        String sql = "SELECT * FROM Ordenes";
        try (Statement statement = connection.createStatement();
             ResultSet rs= statement.executeQuery(sql)){
            while (rs.next()){
                Lista.add(new Ordenes(
                        rs.getInt("id"),
                        rs.getInt("moto_id"),
                        rs.getString("descripcion"),
                        rs.getDouble("costo_total")
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Lista;
    }
}
