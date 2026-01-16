package org.example;

import java.sql.*;

public class conexion {
    public static void main(String[] args){
        // CONEXIÓN INNECESARIA: LA CONEXIÓN Y TODO LO HACES ALLÍ
        try(Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pedidos", "root", "root")){

            ejer4.insertFilas();


        }catch(SQLException se){
            se.printStackTrace();
        }
    }
}
