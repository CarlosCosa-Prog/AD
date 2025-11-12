package com.dam2;
import java.sql.*;
public class Transacciones {

    // Transferencia entre cuentas con transacción
    public void transferirSalario(int idEmpleadoOrigen, int idEmpleadoDestino, double cantidad) {
        Connection conn = null;

        try {
            conn = ConexionBaseDatos.getConexion();
            conn.setAutoCommit(false); // Iniciar transacción

            // Verificar salario suficiente
            String sqlVerificar = "SELECT salario FROM empleados WHERE id = " + idEmpleadoOrigen;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlVerificar);

            if (rs.next()) {
                double salarioActual = rs.getDouble("salario");
                if (salarioActual < cantidad) {
                    throw new SQLException("Salario insuficiente para la transferencia");
                }
            }

            // Restar salario al origen
            String sqlRestar = "UPDATE empleados SET salario = salario - " + cantidad +
                    " WHERE id = " + idEmpleadoOrigen;
            stmt.executeUpdate(sqlRestar);

            // Sumar salario al destino
            String sqlSumar = "UPDATE empleados SET salario = salario + " + cantidad +
                    " WHERE id = " + idEmpleadoDestino;
            stmt.executeUpdate(sqlSumar);

            // Confirmar transacción
            conn.commit();
            System.out.println("Transferencia realizada con éxito");

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback(); // Deshacer transacción en caso de error
                    System.out.println("Transacción cancelada. Rollback realizado.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Operación batch con transacción
    public void actualizacionMasivaSalarios() {
        Connection conn = null;

        try {
            conn = ConexionBaseDatos.getConexion();
            conn.setAutoCommit(false);

            Statement stmt = conn.createStatement();

            // Añadir múltiples updates al batch
            stmt.addBatch("UPDATE empleados SET salario = salario * 1.05 WHERE departamento_id = 1");
            stmt.addBatch("UPDATE empleados SET salario = salario * 1.03 WHERE departamento_id = 2");
            stmt.addBatch("UPDATE empleados SET salario = salario * 1.02 WHERE departamento_id = 3");

            // Ejecutar batch
            int[] resultados = stmt.executeBatch();

            // Verificar resultados
            boolean exito = true;
            for (int resultado : resultados) {
                if (resultado == Statement.EXECUTE_FAILED) {
                    exito = false;
                    break;
                }
            }

            if (exito) {
                conn.commit();
                System.out.println("Batch ejecutado con éxito. Updates realizados: " + resultados.length);
            } else {
                conn.rollback();
                System.out.println("Error en batch. Rollback realizado.");
            }

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}