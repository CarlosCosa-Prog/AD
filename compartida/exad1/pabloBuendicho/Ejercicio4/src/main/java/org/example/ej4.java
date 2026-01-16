package org.example;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ej4 {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void inertarFilas(){
        try(Connection c = DriverManager.getConnection(URL,USER,PASSWORD);){
            System.out.println("Estableciendo conexión");
            System.out.println("Conectado");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Iniciando el programa");
        inertarFilas();
    }
}


/* Ejercicio 6 de teoría
    - Para trabajar con las distintas posiciones en los búferes NIO hay 4 parámetros que son:
        1. mark(), que es como una chincheta y sirve al igual que una chincheta porque guarda la posicion en la que estas ahora mismo para asi poder volver después a esta.
        2. reset(), que sirve para volver al punto que has dejado marcado con el mark() para asi poder volver a la posición por si ibas a cambiar algo.
        3. rewind(), esto hace que vuelvas a la posición 0 del búfer para por ejemplo después de escribirlo con esto vuelvees al inicio para leerlo.
        4. flip(), que se utiliza para cambiar entre la forma de lectura y la forma de escritura. Así por ejemplo cuando vas a mostrar un búfer que acabas de escribir
 */

/* Ejercicio 7 de teoría
    - La diferencia principal entrelos búferes directos y los indirecos es:
    que los directos son búferes que se suelen usar para programas más desarrollados y extensos y esto también hace que usen mas memoria RAM
    en el programa para hacer que funcione mejor, mientras que los indirectos no utilizan tanta ya que suelen ser programas más simples y
    entonces no necesitan de tanta memoria ni tantos procesos para que funcione correctamente, cosa que hace que este sea mas rápido porque necesita usar menos recursos.
    Nosotros en clase hemos estado usando los búferes indirectos ya que nuestros programan suelen ser simples y
    entonces no necesitamos usar los búferes directos porque sería una perdida de recursos y el cambio no se notaría por la simpleza de sus programas.
 */
