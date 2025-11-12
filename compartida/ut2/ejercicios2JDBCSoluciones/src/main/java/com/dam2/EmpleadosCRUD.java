package com.dam2;
import java.sql.*;
public class EmpleadosCRUD {

    // CREATE - Insertar nuevo empleado
    public void insertarEmpleado(String nombre, String apellido, double salario, int departamentoId) {
        Empleado empleado = new Empleado(nombre, apellido, salario, departamentoId);
        String sql = "INSERT INTO empleados (nombre, apellido, salario, departamento_id) " +
                "VALUES ('" + empleado.getNombre() + "', '" + empleado.getApellido() + "', " + empleado.getSalario() + ", " + empleado.getDptmtId() + ")";

        try (Connection conn = ConexionBaseDatos.getConexion();
             Statement stmt = conn.createStatement()) {

            int filasAfectadas = stmt.executeUpdate(sql);
            System.out.println("Empleado insertado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ - Leer todos los empleados
    public void listarEmpleados() {
        String sql = "SELECT * FROM empleados";

        try (Connection conn = ConexionBaseDatos.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Nombre: " + rs.getString("nombre") +
                        ", Apellido: " + rs.getString("apellido") +
                        ", Salario: " + rs.getDouble("salario"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE - Actualizar salario
    public void actualizarSalario(int id, double nuevoSalario) {
        String sql = "UPDATE empleados SET salario = " + nuevoSalario + " WHERE id = " + id;

        try (Connection conn = ConexionBaseDatos.getConexion();
             Statement stmt = conn.createStatement()) {

            int filasAfectadas = stmt.executeUpdate(sql);
            System.out.println("Salario actualizado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE - Eliminar empleado
    public void eliminarEmpleado(int id) {
        String sql = "DELETE FROM empleados WHERE id = " + id;

        try (Connection conn = ConexionBaseDatos.getConexion();
             Statement stmt = conn.createStatement()) {

            int filasAfectadas = stmt.executeUpdate(sql);
            System.out.println("Empleado eliminado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
