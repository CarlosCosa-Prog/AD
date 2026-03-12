package org.cosa;

import java.sql.*;

public class SentenciasSQL {
    // CREATE - Insertar nuevo empleado
    public static void insertarEmpleado(String nombre, String apellido, double salario, double departamentoId){
        // Se utiliza comillas simples con los string
        String sql = "INSERT INTO empleados (nombre, apellido, salario, departamento_id) VALUES ('"+nombre+"','"+apellido+"',"+salario+","+departamentoId + ")";

        // Utiliza la interfaz Statment para ejecutar la sentencia sql
        try (Connection conn = Conexion.getConexion();
            Statement stmt = conn.createStatement();) {
            int filasAfectadas = stmt.executeUpdate(sql);
            System.out.println("Empleado "+ nombre +" insertado. Filas afectadas: " + filasAfectadas);
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());;
        }
    }

    // UPDATE - Modificar el salario del empleado
    public static void modificarSalario(int id, double nuevoSalario){
        String sql = "UPDATE empleados SET salario = " + nuevoSalario + " WHERE id = " + id;

        try (Connection conn = Conexion.getConexion();
             Statement stmt = conn.createStatement();) {
            int filasAfectadas = stmt.executeUpdate(sql);
            System.out.println("Salario actualizado. Filas afectadas: " + filasAfectadas);
        } catch (SQLException e) {
            System.out.println("Error al modificar: " + e.getMessage());
        }
    }

    // DELETE - Eliminar empleado por id
    public static void eliminarEmpleado(int id){
        String sql = "DELETE FROM empleados WHERE id = " + id;
        try (Connection conn = Conexion.getConexion();
            Statement stmt = conn.createStatement();) {
            int filasAfectadas = stmt.executeUpdate(sql);
            System.out.println("Empleado eliminado. Filas afectadas: " + filasAfectadas);
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }

    // READ - Listar todos los empleados
    public static void listarEmpleado(){
        String sql = "SELECT * FROM empleados";

        // el metodo executeQuery devuelve un resultSet por lo que hay que crearlo en el try
        try (Connection conn = Conexion.getConexion();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);) {

            // recorre todos los registros (filas) de la sentencia sql
            while (rs.next()) {
                System.out.println("ID: "+ rs.getInt("id") +
                        ", Nombre: "+ rs.getString("nombre") +
                        ", Apellido: "+ rs.getString("apellido") +
                        ", Salario: "+ rs.getDouble("salario"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
    }


}
