package com.dam2;

import java.sql.*;

public class AppResultSet {
    public static void main(String args[]) {
        try ( Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pedidos", "root", "root");
              Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
              ResultSet rs = stmt.executeQuery("select * from categorias");)
        {
            System.out.println("Listado de categorias en orden inverso");

            int id ; String s;
            rs.afterLast();
            while (rs.previous()) {
                id = rs.getInt("categoriaid");  // id = rs.getInt(1); (numero columna)
                s = rs.getString("nombrecat");  // s = rs.getString(2); (numero columna)
                System.out.println("La categoria " + id + " es de tipo " + s);
            }
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
