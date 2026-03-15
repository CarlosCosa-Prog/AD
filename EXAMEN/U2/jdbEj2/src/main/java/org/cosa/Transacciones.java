package org.cosa;

import java.sql.*;

public class Transacciones {
   public static void tranferirPrecio(int idVideojuegoOrigen, int idVideojuegoDestino, double cantidad){
       Connection conn = null;
       try{
          conn = Conexion.getConexion();
          Statement stmt = conn.createStatement();

          conn.setAutoCommit(false);
          String sqlRestar = "UPDATE videojuegos SET precio = precio - " + cantidad + " WHERE id = " + idVideojuegoOrigen;
          stmt.executeUpdate(sqlRestar);
          String sqlSumar = "UPDATE videojuegos SET precio = precio + " + cantidad + " WHERE id = " + idVideojuegoDestino;
          stmt.executeUpdate(sqlSumar);
          conn.commit();
          System.out.println("Transferencia realizada correctamente");

       } catch (SQLException e) {
           if (conn != null){
               try {
                   conn.rollback();
               } catch (SQLException ex) {
                   throw new RuntimeException(ex);
               }
           }
       } finally {
           if (conn != null){
               try {
                   conn.setAutoCommit(true);
                   conn.close();
               } catch (SQLException e) {
                   throw new RuntimeException(e);
               }
           }
       }
   }
}
