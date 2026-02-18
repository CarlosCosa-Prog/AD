package org.example;

import java.sql.*;

public class ej4 {
    public static void listarCategorias(){
        String sql = "SELECT * FROM Pedidos WHERE categoriaid < ?"; // PEDIDOS NO ES TABLA
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pedidos", "root", "root");
             PreparedStatement stmt = conn.prepareStatement(sql)
             ){

            stmt.setInt(1, 500);

            ResultSet rs = stmt.executeQuery();
                while (rs.next()){
                    String nombre = rs.getString("nombrecat");
                    String categoria = rs.getString("categoriaid");
                    System.out.println("Nombre: " + nombre + " Categoria: " + categoria);
                }

        }catch (SQLException e){
            e.printStackTrace();
        }


        /*EJ5
        * Statement tiene un problema deseguridad con el codigo ya que lo ejecuta el sql como String, PreparedStatement lo que haces es que lo precompila y utiliza la ? para luego nosotros pasarle los parametros. Esto lo que hace es que no se permita insertar codigo a los atacantes.
        * */

        /*EJ7
        * La diferencia principal es que los no direcos directos consumen menos recursos y son los que hemos estado utilizando mientrasd que los directos se suelen utiizar para programas mas desarollados y extensos y esto implica mas uso de memoria.
        * */
    }
}
