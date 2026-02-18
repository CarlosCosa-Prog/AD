package com.dam2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

// 4) Programa JDBC

public class CRUD {

    public void insertar(int categoriaid, String nombrecat){

        String sql = "INSERT INTO categorias (categoriaid, nombrecat)";
        String sql2 = "INSERT INTO categorias (categoriaid, nombrecat)";

        try(Connection con = ConexionBaseDatos.getConexion();
            Statement stmt = con.createStatement()){
// FALTA EL AUTOCOMMIT A FALSE, EL COMMIT, EL ROLLBACK ...
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);
    // UN PROCESO POR LOTES ES PARECIDO PERO NO ES UNA TRANSACCION
            stmt.addBatch(sql);
            stmt.addBatch(sql2);

            int[] filasnuevas = stmt.executeBatch();
            System.out.printf("Filas nuevas: " + Arrays.toString(filasnuevas));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }








    }
}
