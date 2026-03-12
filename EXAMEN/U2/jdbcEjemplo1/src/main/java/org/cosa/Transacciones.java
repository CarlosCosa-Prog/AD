package org.cosa;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Transacciones {
    public static void tranferirDatos(int idEmpleadoOrigen, int idEmpleadoDestino, double cantidad){
        Connection conn = null;
        try{
            conn = Conexion.getConexion();
            Statement stmt = conn.createStatement();

            // Deshabilitar el autocommit
            conn.setAutoCommit(false);

            // Restar el salario al empleado de origen
            String sqlRestar = "UPDATE empleados SET salario = salario - " + cantidad + " WHERE id = " + idEmpleadoOrigen;
            stmt.executeUpdate(sqlRestar);

            // Sumar salario al empleado de destino
            String sqlSumar = "UPDATE empleados SET salario = salario + " + cantidad + " WHERE id = " + idEmpleadoDestino;
            stmt.executeUpdate(sqlSumar);

            // Confirmar la transacción
            conn.commit();
            System.out.println("Transferencia realizada correctamente");


        } catch (SQLException e) {
            if (conn != null) { // para evitar un NullPointerException
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("La transferencia no pudo ser realizada");
            }
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    // importante cerrar la conexión
                    conn.close();

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
