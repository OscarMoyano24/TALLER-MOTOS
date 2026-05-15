package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3314/TALLER";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "1212";

    public static Connection obtenerconexionTALLER_MOTOS() throws SQLException{
        return DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
    }
}
