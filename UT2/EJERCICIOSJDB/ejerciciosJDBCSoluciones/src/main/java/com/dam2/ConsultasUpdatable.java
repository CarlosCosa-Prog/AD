package com.dam2;
import java.sql.*;
public class ConsultasUpdatable {

    // Actualizar datos directamente desde el ResultSet
    public void actualizarSalariosViaResultSet() {
        String sql = "SELECT id, nombre, apellido, salario FROM empleados WHERE salario < 30000";

        try (Connection conn = ConexionBaseDatos.getConexion();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                     ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("=== ACTUALIZANDO SALARIOS BAJOS ===");
            while (rs.next()) {
                double salarioActual = rs.getDouble("salario");
                double nuevoSalario = salarioActual * 1.10; // Aumento del 10%

                rs.updateDouble("salario", nuevoSalario);
                rs.updateRow();

                System.out.printf("Actualizado: %s %s - %.2f€ -> %.2f€\n",
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        salarioActual,
                        nuevoSalario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Insertar nueva fila via ResultSet
    public void insertarEmpleadoViaResultSet() {
        String sql = "SELECT id, nombre, apellido, salario, departamento_id FROM empleados";

        try (Connection conn = ConexionBaseDatos.getConexion();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                     ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {

            // Mover al row de inserción
            rs.moveToInsertRow();

            // Establecer valores
            rs.updateString("nombre", "Nuevo");
            rs.updateString("apellido", "Empleado");
            rs.updateDouble("salario", 35000.0);
            rs.updateInt("departamento_id", 1);

            // Insertar la fila
            rs.insertRow();

            // Volver a la posición actual
            rs.moveToCurrentRow();

            System.out.println("Nuevo empleado insertado via ResultSet");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar fila via ResultSet
    public void eliminarEmpleadoViaResultSet(int id) {
        String sql = "SELECT id, nombre, apellido FROM empleados WHERE id = " + id;

        try (Connection conn = ConexionBaseDatos.getConexion();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                     ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                System.out.println("Eliminando: " + rs.getString("nombre") + " " + rs.getString("apellido"));
                rs.deleteRow();
                System.out.println("Empleado eliminado via ResultSet");
            } else {
                System.out.println("No se encontró el empleado con ID: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}