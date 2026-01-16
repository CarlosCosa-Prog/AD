package com.dam2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ej1_ConexionBaseDatos {
    //atributos url, usuario y contraseña
    private static final String url = "jdbc:postgresql://localhost:5432/empresa2";
    private static final String usuario = "root";
    private static final String contraseña = "root";

    // metodo estático getConexion()
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,usuario,contraseña);
    }

    // main para conectarse a la base de datos
    public static void main(String args[]){
        try (Connection connection = getConnection()){
            System.out.println("Conexión establecida correctamente");
        } catch (SQLException ex) {
            System.out.println("Error al obtener el driver de la base de datos");
        }
    }
}
