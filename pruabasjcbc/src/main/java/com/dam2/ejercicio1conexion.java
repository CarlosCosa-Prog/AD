package com.dam2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ejercicio1conexion {
    private static String URL = "jdbc:postgresql://localhost:5432/empresa2";
    private static String USER = "root";
    private static String PASSWORD = "root";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    public static void probarConexion(){
        try(Connection con = getConnection()){
            System.out.println("Conexion establecida");
        }catch(SQLException e){
            System.out.println("Error al conectar");
        }
    }
}
