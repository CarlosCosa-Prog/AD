package org.example;

/*Programa jdbc que inserta 2 filas en la tbala categorias de la BBDD pedidos como una transaccion*/

import java.sql.*;


public class ejer4 {

    public static void insertFilas() {

        Connection conn = null;

        try{
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pedidos", "root", "root");
            Statement stmt = conn.createStatement();

            conn.setAutoCommit(false);

            stmt.executeUpdate("INSERT INTO categorias VALUES (800, 'DESAYUNO')");

            stmt.executeUpdate("INSERT INTO categorias VALUEs (900, 'COMIDA PERRO')");
            conn.commit();


        }catch(SQLException se){
            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException e) {
                    se.printStackTrace();;
                }
            }
            se.printStackTrace();
        }
        finally {
            if(conn != null){
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

/* 7. Los buffers directos e indirectos, los buffers directos son los que que llevan el Direct(), y almacenan el buffer de manera directa, nosotros usamos los no directos ya que son más funcionales y no dan tanto problemas como el directo. */

/* 6. Los 4 parámetros útiles para las distintas posiciones en los búffers son first que va al principio del buffer, last que se va al final del buffer, absolute que puedes elegir cualquier posición del buffer*/
