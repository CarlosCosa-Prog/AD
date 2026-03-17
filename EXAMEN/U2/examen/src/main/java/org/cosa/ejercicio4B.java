package org.cosa;

import java.sql.*;

/*Programa JDBC que acceda a la tabla "categorías", de la BD "pedidos", para mostrar todas las filas
* cuya "categoria_id" sea inferior a 500. La consulta debe hacerse parametrizada, con un único parámetro
* que sea el valor de 500 en la ejecución de la consulta.*/
public class ejercicio4B {
    public static void mostrarCategorias(int cantidad){
        String sql = "SELECT * FROM categorias WHERE categoria_id < " + cantidad;
        try(Connection conn = Conexion.getConexion();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);) {


            while (rs.next()){
                System.out.println("Id:"+rs.getInt("id")+" Nombre: "+rs.getString("nombre")+" Categoria id: "+rs.getInt("categoria_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
