package com.dam2;

import java.sql.*;
//import java.sql.DriverManager;

public class AppConecta
{
    public static void main( String[] args )
    {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/pedidos","root", "root");) {

            System.out.println("Conexión establecida");
            //c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
