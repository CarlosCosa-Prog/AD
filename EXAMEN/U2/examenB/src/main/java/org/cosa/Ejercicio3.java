package org.cosa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio3 {
    public static void insertarCategoria(String nombre, int categoria_id){
        String sql = "INSERT INTO categorias (nombre, categoria_id) VALUES ('"+nombre+"',"+categoria_id+")";
        try (Connection conn = Conexion.getConexion();
             Statement stmt = conn.createStatement()){
            stmt.executeUpdate(sql);
            System.out.println("Categoria " + nombre + " añadida correctamente");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void listarCategorias(){
        String sql = "SELECT * FROM categorias";
        try(Connection conn = Conexion.getConexion();
        Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while(rs.next()){
                System.out.println("Id: " + rs.getInt("id") +
                        " Nombre: " + rs.getString("nombre") +
                        " CategoriaId: " + rs.getInt("categoria_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void mostrarCategoriaId(int cantidad){
        String sql = "SELECT * FROM categorias WHERE categoria_id < " + cantidad;
        try (Connection conn = Conexion.getConexion();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
            while(rs.next()){
                System.out.println("Id: " + rs.getInt("id") +
                        " Nombre: " + rs.getString("nombre") +
                        " CategoriaId: " + rs.getInt("categoria_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
