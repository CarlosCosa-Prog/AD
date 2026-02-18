package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ej4 {
    public static void main(String[] args) {
       // URL DE CONEXION A MYSQL, NO A POSTGRESQL
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root")){
            try(Statement st = con.createStatement()){

                st.executeQuery();
                st.executeQuery();
            }
        }
    }
}
