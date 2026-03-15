package org.cosa;

import java.sql.*;

public class SentenciasSQL {
    // CREATE - Insertar nuevo empleado
    public static void insertarVideojuego(String nombre, int año, double precio){
        String sql = "INSERT INTO videojuegos (nombre, año, precio) VALUES ('"+nombre+"',"+ año +","+precio+" )";
        try (Connection conn = Conexion.getConexion();
        Statement stmt = conn.createStatement()) {
            int filasAfectadas = stmt.executeUpdate(sql);
            System.out.println("Videojuego " + nombre + " insertado correctamente. Filas Afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // UPDATE
    public static void actualizarPrecio(int id, double precio){
        try (Connection conn = Conexion.getConexion();
            Statement stmt = conn.createStatement()) {
            String sql = "UPDATE videojuegos SET precio = " + precio + " WHERE id = " + id;
            stmt.executeUpdate(sql);
            System.out.println("Salario actualizado");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // DELETE
    public static void borrarVideojuego(int id){
        try (Connection conn = Conexion.getConexion();
        Statement stmt = conn.createStatement()){
            String sql = "DELETE FROM videojuegos WHERE id = " + id;
            int filas = stmt.executeUpdate(sql);
            System.out.println("Videojuego de id "+ id +" borrado correctamente. Filas afectadas " + filas);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // READ
    public static void mostrarVideojuegos(){
        String sql = "SELECT * FROM videojuegos";
        try(Connection conn = Conexion.getConexion();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);){
            while (rs.next()){
                System.out.println("ID: "+ rs.getInt("id") +
                        ", Nombre: "+ rs.getString("nombre") +
                        ", Año: "+ rs.getInt("año") +
                        ", Precio: "+ rs.getDouble("precio"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
