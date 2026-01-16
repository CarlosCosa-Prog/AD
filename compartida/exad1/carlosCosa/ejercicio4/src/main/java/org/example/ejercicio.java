package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*Programa que:
* - inserte 2 filas en catagorías (pedidos) como transacción*/
public class ejercicio {
    public static void transferencia(){
        String sql = "select * from pedidos ";  // PARA QUÉ??
        Connection con = null;
        try{
            con = conexion.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(sql);
            con.setAutoCommit(false);
            String sqlInsert = "insert into categorias (categoriaid, nombrecat) values ('1000', 'prueba')";
            stmt.executeQuery(sqlInsert);   // HA DE SER EXECUTEUPDATE
            rs.insertRow();
            // NO REPITAS CLAVE PRINCIPAL
            String sqlInsert2 = "insert into categorias (categoriaid, nombrecat) values ('1000', 'prueba')";
            stmt.executeQuery(sqlInsert2);  // IGUAL
            rs.insertRow();
            // FALTA EL COMMIT
        }catch(SQLException e){
            if(con!=null){
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }finally {
            if(con!=null){
                try {
                    con.setAutoCommit(true);
                    con.close();
                } catch (SQLException ex) {}
            }
        }
    }
}
