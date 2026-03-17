package org.cosa;

import java.sql.*;

/*Programa JDBC que inserta 2 filas en la tabla "categoría" de la BD "pedidos" como transacción*/
public class ejercicio4A {
    public static void insertarTransaccion(String nombre1, int categoria_id1,String nombre2, int categoria_id2){
        Connection conn = null;
        try {
            conn = Conexion.getConexion();
            Statement stmt = conn.createStatement();

            conn.setAutoCommit(false);
            String sql1 = "INSERT INTO categorias (nombre, categoria_id) VALUES ('"+nombre1+"' , "+categoria_id1 + ")";
            stmt.executeUpdate(sql1);
            String sql2 = "INSERT INTO categorias (nombre, categoria_id) VALUES ('"+nombre2+"' , "+categoria_id2 + ")";
            stmt.executeUpdate(sql2);
            conn.commit();
            System.out.println("Categoria " + nombre1 + " y categoria " + nombre2 + " añadidas correctamente");

        } catch (SQLException e) {
            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } finally {
            if (conn != null){
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

}
