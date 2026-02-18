package com.dam2;
import java.sql.*;
import java.util.List;

public class EmpleadosPreparedStatement {

    // CREATE con PreparedStatement
    public void insertarEmpleadoPrepared(Empleado empleado) {
        String sql = "INSERT INTO empleados (nombre, apellido, salario, departamento_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionBaseDatos.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getApellido());
            pstmt.setDouble(3, empleado.getSalario());
            pstmt.setInt(4, empleado.getDptmtId());

            int filasAfectadas = pstmt.executeUpdate();
            System.out.println("Empleado insertado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ con PreparedStatement y parámetros
    public void buscarEmpleadosPorDepartamento(int departamentoId) {
        String sql = "SELECT id, nombre, apellido, salario FROM empleados WHERE departamento_id = ?";

        try (Connection conn = ConexionBaseDatos.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, departamentoId);

            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("=== EMPLEADOS DEL DEPARTAMENTO " + departamentoId + " ===");
                while (rs.next()) {
                    System.out.printf("ID: %d, Nombre: %s %s, Salario: %.2f€\n",
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getDouble("salario"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE con PreparedStatement
    public void actualizarSalarioPrepared(int id, double nuevoSalario) {
        String sql = "UPDATE empleados SET salario = ? WHERE id = ?";

        try (Connection conn = ConexionBaseDatos.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, nuevoSalario);
            pstmt.setInt(2, id);

            int filasAfectadas = pstmt.executeUpdate();
            System.out.println("Salario actualizado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Batch insert con PreparedStatement
    public void insercionMasivaEmpleados(List<Empleado> empleados) {
        String sql = "INSERT INTO empleados (nombre, apellido, salario, departamento_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionBaseDatos.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);

            for (Empleado empleado : empleados) {
                pstmt.setString(1, empleado.getNombre());
                pstmt.setString(2, empleado.getApellido());
                pstmt.setDouble(3, empleado.getSalario());
                pstmt.setInt(4, empleado.getDptmtId());
                pstmt.addBatch();
            }

            int[] resultados = pstmt.executeBatch();
            conn.commit();

            System.out.println("Inserción masiva completada. Filas insertadas: " + resultados.length);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}