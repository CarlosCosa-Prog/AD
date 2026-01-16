package com.dam2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppDelete {
    public static void main(String[] args) {
        int result = 0;
        try ( Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pedidos","root","root");
                         Statement stmt = con.createStatement(); ) {
            String sql = "delete from categorias2 where categoriaid = 1";
            result = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Se ha borrado " + result + " filas");
    }
}
