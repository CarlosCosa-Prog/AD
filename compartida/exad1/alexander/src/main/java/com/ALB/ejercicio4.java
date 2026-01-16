package com.ALB;

import java.sql.*;

public class ejercicio4 {
    public static void main(String[] args) {
        // Establecemos los parámetros de la conexión
        String URL = "jdbc:postgresql://localhost:5432/pedidos";
        String USER = "root";
        String PASSWORD = "root";

        // Realizamos la conexión en un try-catch (with resources)
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);) {
            String querySQL = "SELECT * FROM categorias WHERE categoriaid < ?";
            // Creamos el prepared statement
            try (PreparedStatement pstmt = conn.prepareStatement(querySQL)) {
                // Establecemos el valor al parámetro
                pstmt.setInt(1, 500);

                // Ejecutamos la consulta y almacenamos en un ResultSet los valores obtenidos
                ResultSet rs = pstmt.executeQuery();

                // Mostramos dichos valores por pantalla
                while (rs.next()) {
                    System.out.println("CategoriaID: " + rs.getInt("categoriaid"));
                    System.out.println("Nombre Categoria: " + rs.getString("nombrecat"));
                    System.out.println();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Error al realizar la consulta en la base de datos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al conectarse con la base de datos");
        }
    }
}
/*
5. ¿Qué problema de seguridad tiene la interfaz Statement que corrija PreparedStatement? Explica brevemente en que consiste este problema.
    El problema que tenia era la inyección por SQL, debido a que las consultas son realizadas sin parametrizar y son más susceptibles a poder ser modificada
al momento de realizar la consulta. En cambio con PreparedStatement al tener los valores como parámteros a pasar, las consultas no pueden ser modificadas
al momento de su ejecución. Por lo tanto solucionamos el problema de las SQL Injection.

7. Explica la diferencia entre los búferes directos y los no directos. Indica cuáles hemos utilizado en clase.
Cuando utilizamos un búfer podemos utilizar los bufferes directos, los cuales nos permiten tener una gran velocidad de E/S pero tiene el contratiempo de que
consumen más recursos y al momento de liberarlos de la memoria son más complicados. En cambio los búferes no directos tienen una velocidad menor al momento
de realizar operaciones de E/S pero ocupan menos recursos y es más fácil liberarlos de la memoria. En clase hemos estado utilizando los
búferes no directos: ByteBuffer.allocate()

Ejemplo: ByteBuffer bb = ByteBuffer.allocate(512);

* */