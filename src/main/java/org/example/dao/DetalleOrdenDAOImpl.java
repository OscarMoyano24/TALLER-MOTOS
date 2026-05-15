package org.example.dao;

import org.example.model.DetalleOrden;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DetalleOrdenDAOImpl  implements DetalleOrdenDAO{
    private final Connection connection;

    public DetalleOrdenDAOImpl(Connection connection){this.connection = connection;}

    @Override
    public void crear(DetalleOrden detalleOrden){
        String sql = "INSERT INTO detalle_orden (id, orden_id, repuesto_id, cantidad, subtotal) VALUES (?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, detalleOrden.getId());
            statement.setInt(2, detalleOrden.getOrdenid());
            statement.setInt(3,detalleOrden.getRepuestoid());
            statement.setInt(4,detalleOrden.getCantidad());
            statement.setDouble(5,detalleOrden.getSubtotal());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public DetalleOrden leer(int id){
        String sql = "SELECT * FROM detalle_orden WHERE id=?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return new DetalleOrden(
                        resultSet.getInt("id"),
                        resultSet.getInt("orden_id"),
                        resultSet.getInt("repuesto_id"),
                        resultSet.getInt("cantidad"),
                        resultSet.getDouble("subtotal")
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizar(DetalleOrden detalleOrden){
        String sql = " UPDATE detalle_orden set  orden_id=?, repuesto_id=?, cantidad=?, subtotal=? WHERE id=?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,detalleOrden.getOrdenid());
            statement.setInt(2,detalleOrden.getRepuestoid());
            statement.setInt(3,detalleOrden.getCantidad());
            statement.setDouble(4,detalleOrden.getSubtotal());
            statement.setInt(5,detalleOrden.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(DetalleOrden detalleOrden){
        String sql = "DELETE FROM detalle_orden WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, detalleOrden.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<DetalleOrden> Listar(){
        List<DetalleOrden> lista =new ArrayList<>();
        String sql = "SELECT * FROM  detalle_orden";
        try(Statement statement = connection.createStatement();
        ResultSet rs= statement.executeQuery(sql)) {
            while (rs.next()){
                lista.add(new DetalleOrden(
                        rs.getInt("id"),
                        rs.getInt("orden_id"),
                        rs.getInt("repuesto_id"),
                        rs.getInt("cantidad"),
                        rs.getDouble("subtotal")
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }




}
