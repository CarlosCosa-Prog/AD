package com.dam2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppConnect {
    public static void main(String[] args) {
        try{
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pedidos", "root", "root");
            System.out.println("Connected to database successfully");
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }
    }
}
