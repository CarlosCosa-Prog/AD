package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    public static void main(String[] args) {
        // Pedidos NO EXISTE, pedidos SI
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Pedidos", "root", "root");){
            System.out.println("Conectando....");

            ej4.listarCategorias();

            System.out.println("Conectado..." + conn.getSchema());

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
