package ej4;

import java.nio.file.StandardOpenOption;
import java.sql.*;

public class ej4 {

    private String url = "jdbc:postgresql://localhost:5432/pedidos/categorias";
    private String usuario = "admin@admin.com"; // NO: LA DE POSTGRES, NO DE PGADMIN
    private String contraseña = "root";

    public static void main(String[] args) {
        System.out.println("Vamos a observar datos de una tabla...");
        //consultarDatos();
    }

    public static void consultarDatos(int valor){
        valor = 500;
        String sql = "select categoriaId from categoria where idCategoria = ?";

        try(Connection connection = null; Statement statement = null; ResultSet resultSet = null;){
            if(valor < 500){
                System.out.println("Estas son las categorias con un id inferior a 500:");
                resultSet.first(); // No hace falta, pero nos posicionamos en el primer valor
                System.out.println(resultSet.getString("categoriaId"));
            }else
                System.out.println("El resto de las categorias de esta tebla son mayores a 500");
        } catch (SQLException ex) {
            System.err.println("No se ha podido acceder a la base de datos" + ex.getMessage());
        }
    }
}

/*                                                      -- Teoría --
Pregunta 5-
El problema que soluciona PreparedStatement frente Statement, es la inyección de datos. PreparedStatement evita este problema de seguridad y
proporciona más seguridad a nuestra base de datos. Además de ser más segura, también es más eficiente que Statement.


Pregunta 7-
Las dos clases de búferes que hemos utilizados en clase han sido Gathering y Scattering. La diferencia entre
estos búferes, es que el primero (Gathering), se utiliza para escribir los archivos y Scattering, se utiliza para la visualización del
contenido de estos ficheros.
*/