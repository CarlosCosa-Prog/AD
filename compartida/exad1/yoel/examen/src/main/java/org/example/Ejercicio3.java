package org.example;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class Ejercicio3 {
    public static void main(String[] args) throws SQLException {
        // Pedidos NO EXISTE, pedidos SI
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pedidos","root","root");
        System.out.println("Conectado correctamente");
        try {
            PreparedStatement pst = conn.prepareStatement("INSERT INTO categorias (categoriaid,nombrecat) VALUES (?,?)");
            conn.setAutoCommit(false);
            pst.setInt(1, 1100);
            pst.setString(2, "PATATAS");
            pst.executeUpdate();
            pst.setInt(1, 900);
            pst.setString(2, "CONGELADOS");
            pst.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            conn.rollback();
            throw new RuntimeException(e);
        }
        finally{
            conn.setAutoCommit(true);
            conn.close();
        }
    }
}
/*
5. Explica que es el patron DAO

El patron DAO (Data Acces Object) es una forma de interactuar con una base de datos mediante el uso de interfaces  y de una API que la propia clase implementa, esta manera de operar facilita mucho a la hora de
 escribir codigo  y en la eficiencia del programa.


 7.Explica la diferencia entre los buferes directos y los no directos

El buffer directo es que el que se almacena la información del buffer dentro de la memoria de la propia maquina y se crea mediante un ByteBuffer.allocateDirect(int x).
El buffer indirecto se almacena en la JVM ya que no se lo especificamos y se crea mediante un ByteBuffer.allocate(int x)
El que hemos utilizado en clase tanto en las explicaciones como en los ejercicios propuestos es el indirecto.


 */
