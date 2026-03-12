package org.cosa;

import java.sql.*;

public class Conexion {
    private static final String URL = "jdbc:postgresql://localhost/pruebasJDBC";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASS);
    }

    public static void probarConexion(){
        try(Connection conn = getConexion();){
            System.out.println("Conexion establecida con la base de datos ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
