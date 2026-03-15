package org.cosa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio3 {
    public static void mostrarCategorias(){
        String sql = "SELECT * FROM categorias";
        try(Connection conn = Conexion.getConexion();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while(rs.next()){
                System.out.println("Id: " + rs.getInt("id") + " Nombre: " + rs.getString("nombre") + " Categoria id: "+ rs.getInt("categoria_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void insertarTransaccion(String nombre1, int categoria_id1, String nombre2, int categoria_id2){
        Connection conn = null;
            try {
                conn = Conexion.getConexion();
                Statement stmt = conn.createStatement();
                conn.setAutoCommit(false);
                String sql1 = "INSERT INTO categorias (nombre,categoria_id) VALUES ('"+nombre1+"',"+categoria_id1 +")";
                stmt.executeUpdate(sql1);
                String sql2 = "INSERT INTO categorias (nombre,categoria_id) VALUES ('"+nombre2+"',"+categoria_id2 +")";
                stmt.executeUpdate(sql2);
                conn.commit();
                System.out.println("Categoria " + nombre1 + " y categoria " + nombre2 + " insertadas correctamente");
            } catch (SQLException e) {
                if (conn != null){
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
