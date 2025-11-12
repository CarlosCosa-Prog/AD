package com.dam2;

import java.sql.*;

public class ListaCategoriasInversa {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pedidos","root","root");
             Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery("select * from categorias");){
            System.out.println("Listado de CATEGORIAS en orden inverso:");

            int id; String s;
            rs.afterLast();
            while (rs.previous())
            {
                id = rs.getInt("categoriaid");
                s = rs.getString(2);
                System.out.println("La categoría " + id + " es de tipo " + s);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
