package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    private static String URL = "jdbc:postgresql://localhost:5432/pedidos";
    private static String usuario = "root";
    private static String password = "root";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,usuario,password);
    }
    public static void probarConexion(){
        try(Connection con = getConnection()){
            System.out.println("Conexion establecida");
        }catch(SQLException e){
            System.out.println("Error al conectar con la base de datos");
        }
    }
}
