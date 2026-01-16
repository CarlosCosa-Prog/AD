package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ej4 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try{
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pedidos","root","root");
            String SQL = "INSERT INTO categorias VALUES(?,?)";
            pstmt = conn.prepareCall(SQL);

            // DEBIA SER TRANSACCION

            pstmt.setInt(1,800);
            pstmt.setString(2,"MANZANAS");
            pstmt.executeUpdate();

            pstmt.setInt(1,900);
            pstmt.setString(2,"VERDURAS");
            pstmt.executeUpdate();

        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            try{
                if(conn!=null)
                    conn.close();
                if(pstmt!=null)
                    pstmt.close();
            } catch (SQLException e1){
                System.out.println(e1.getMessage());
            }
        }
    }
}

// NO PEDÍA FUNCIONES, SINO LAS PROPIEDADES DE POSICIÓN, LÍMITE, ETC.
/*Teoría 1 :
Existen:
buffer.flip(): Cuando el buffer está en modo escritura, pone la posicion a 0 y pone el límite donde estuviera la posición antes de hacer el flip.
buffer.clear(): deja la posicioón en 0 y el límite que pusimos al crear
buffer.position(): podemos posicionarmos en el sitio del buffer donde queramos
buffer.last(): envia la posición a al límite
 */
