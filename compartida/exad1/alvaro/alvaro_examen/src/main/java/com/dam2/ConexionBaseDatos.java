package com.dam2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static java.lang.Class.forName;

// 4) Programa JDBC

public class ConexionBaseDatos {

    private static final String URL = "jdbc:postgresql://localhost:5432/pedidos";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    static {
        try {
            // ES CLASS.FORNAME PERO NO ERA NECESARIO
            Class = forName(org.postgresql.Driver);
        } catch (ClassNotFoundException c) {
            throw new RuntimeException(c.getMessage());
        }
    }

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

    /*

    5) El patron DAO es un modelo de programacion que sirve para obtener un codigo mas ordenado, estructura, legible y escalable.
    Consiste en independizar el acceso a bases de datos o repositorios de datos mediante la encapsulacion en clases de objetos (Data Access Object),
    que permiten que si se deses cambiar de API de acceso a datos (JDBC a Hibernate) o de una base de datos a un repositorio, el proceso sea más sencillo,
    porque solo hay que modificar las propias clases DAO, sin alterar código externo. Asimismo, favorece la implementación de seguridad al poder proteger e
    l acceso a los objetos DAO, en lugar de disponer código de fácil acceso fuera de ellos. El funcionamiento de este patrón consiste, primero en la creación
    de una interfaz con el nombre del objeto instanciable (por ejemplo ProductoDAO), y la implementación de tal interfaz a través de una clase (ProductoDAOImp).

    7) Los búferes directos (allocateDirect) son aquellos que emplean la memoria nativa del ordenador que utilizas. En cambio, los no directos (allocate)
    ocupan memoria de la máquina virtual. Si bien los directos son más rápidos en las operacines de entrada y salida, requieren más memoria RAM, ya que
    deben almacenarse en el dispositivo. Los no directos son más veloces en la máquina virtual, pero no en operaciones de I/O. Es más recomendable emplear
    los no directos y reservar el uso de los directos para tareas que precisen grandes volúmenes de datos de entrada y salida, y se necesite maximizar la
    velocidad. Por ello, durante la clase empleamos búferes no directos.

     */



