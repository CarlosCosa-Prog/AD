package com.dam2;
import java.sql.*;

public class Consultas {

    // Navegación forward-only
    public void navegarResultSetForward() {
        String sql = "SELECT id, nombre, apellido, salario FROM empleados ORDER BY salario DESC";

        try (Connection conn = ConexionBaseDatos.getConexion();
             Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                     ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("=== EMPLEADOS ORDENADOS POR SALARIO (DESC) ===");
            while (rs.next()) {
                System.out.printf("ID: %d, Nombre: %s %s, Salario: %.2f€\n",
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getDouble("salario"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Navegación scrollable pero no actualizable
    public void navegarResultSetScrollable() {
        String sql = "SELECT id, nombre, apellido, salario FROM empleados";

        try (Connection conn = ConexionBaseDatos.getConexion();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery(sql)) {

            // Ir a la última fila
            if (rs.last()) {
                System.out.println("Último empleado: " + rs.getString("nombre") + " " + rs.getString("apellido"));
            }

            // Ir a la primera fila
            if (rs.first()) {
                System.out.println("Primer empleado: " + rs.getString("nombre") + " " + rs.getString("apellido"));
            }

            // Ir a la fila 3
            if (rs.absolute(3)) {
                System.out.println("Tercer empleado: " + rs.getString("nombre") + " " + rs.getString("apellido"));
            }

            // Navegar hacia atrás
            System.out.println("=== NAVEGACIÓN HACIA ATRÁS ===");
            rs.afterLast();
            while (rs.previous()) {
                System.out.println(rs.getString("nombre") + " " + rs.getString("apellido"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}