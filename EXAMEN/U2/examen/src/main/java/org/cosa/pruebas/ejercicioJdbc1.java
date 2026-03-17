package org.cosa.pruebas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*Programa JDBC que inserta 2 filas en la tabla "categoría" de la BD "pedidos" como transacción*/
public class ejercicioJdbc1 {
    public static void insertarTransaccion(String nombre1, int categoria_id1,String nombre2, int categoria_id2){
        Connection conn = null;
        String sql1 = "INSERT INTO categorias (nombre,categoria_id) VALUES ('"+nombre1+"'," +categoria_id1+ ") ";
        String sql2 = "INSERT INTO categorias (nombre,categoria_id) VALUES ('"+nombre2+"'," +categoria_id2+ ") ";

        try {
            conn = Conexion.getConexion();
            Statement stmt = conn.createStatement();

            conn.setAutoCommit(false);
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
            conn.commit();
            System.out.println("Categoria " + nombre1 + " y categoria " +nombre2+ " insertadas correctamente");
        } catch (SQLException e) {
            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } finally {
            if(conn != null){
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        Conexion.probarConexion();
        ejercicioJdbc1.insertarTransaccion("Carlos",1,"Antonio",2);
    }
}
