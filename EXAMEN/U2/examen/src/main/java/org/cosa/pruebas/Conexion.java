package org.cosa.pruebas;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:postgresql://localhost/pedidos";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASS);
    }

    public static void probarConexion(){
        try(Connection conn = Conexion.getConexion()) {
            System.out.println("Conexion establecida correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
