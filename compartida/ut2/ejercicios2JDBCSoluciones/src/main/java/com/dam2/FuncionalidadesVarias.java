package com.dam2;
import java.sql.*;

public class FuncionalidadesVarias
{
    // Utilizar la función personalizada de PostgreSQL
    public void obtenerSalarioPromedioDepartamento(int departamentoId) {
        String sql = "SELECT salario_promedio_departamento(?) as promedio_salario";

        try (Connection conn = ConexionBaseDatos.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, departamentoId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    double promedio = rs.getDouble("promedio_salario");
                    System.out.printf("Salario promedio del departamento %d: %.2f€\n",
                            departamentoId, promedio);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Utilizar el procedimiento almacenado
    public void ejecutarAumentoSalarial(int departamentoId, double porcentaje) {
        String sql = "CALL aumentar_salarios_departamento(?, ?)";

        try (Connection conn = ConexionBaseDatos.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, departamentoId);
            pstmt.setDouble(2, porcentaje);

            pstmt.execute();
            System.out.printf("Aumento del %.1f%% aplicado al departamento %d\n",
                    porcentaje, departamentoId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Usar la vista de empleados activos
    public void listarEmpleadosActivos() {
        String sql = "SELECT * FROM vista_empleados_activos ORDER BY salario DESC";

        try (Connection conn = ConexionBaseDatos.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("=== EMPLEADOS ACTIVOS ===");
            while (rs.next()) {
                System.out.printf("ID: %d, Nombre: %s %s, Salario: %.2f€, Departamento: %s, Fecha: %s\n",
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getDouble("salario"),
                        rs.getString("departamento_nombre"),
                        rs.getDate("fecha_contratacion"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Ejemplo con tipos específicos de PostgreSQL
    public void usarTiposPostgreSQL() {
        String sql = "INSERT INTO empleados (nombre, apellido, salario, departamento_id, activo, fecha_contratacion) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBaseDatos.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            Empleado empleado = new Empleado("Nuevo","Empleado",30000.0,1);
            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getApellido());
            pstmt.setDouble(3, empleado.getSalario());
            pstmt.setInt(4, empleado.getDptmtId());
            pstmt.setBoolean(5, true);
            pstmt.setDate(6, new java.sql.Date(System.currentTimeMillis()));

            int filasAfectadas = pstmt.executeUpdate();
            System.out.println("Empleado insertado con tipos PostgreSQL. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}