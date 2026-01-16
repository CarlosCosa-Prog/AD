package org.example;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EJ4 {

    private static final String DB_URL = "jdbc://localhost:5432/pedidos";   // INCORRECTA
    private static final String DB_USER = "root";
    private static final String DB_PASS = "root";

        public static void main(String[] args) throws SQLException, ClassNotFoundException {

            try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                 PreparedStatement stmt = con.prepareStatement("select * from pedido");) {



            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

}
