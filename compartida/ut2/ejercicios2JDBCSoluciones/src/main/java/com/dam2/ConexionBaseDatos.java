package com.dam2;

import java.sql.*;

// Clase para gestionar la conexión a la base de datos
// Clase para gestionar la conexión a la base de datos PostgreSQL
public class ConexionBaseDatos {
    private static final String URL = "jdbc:postgresql://localhost:5432/empresa2";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "root";

    static {
        try {
            // Cargar el driver de PostgreSQL
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error al cargar el driver de PostgreSQL", e);
        }
    }

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }

    // Método adicional para PostgreSQL - probar la conexión
    public static void probarConexion() {
        try (Connection conn = getConexion()) {
            System.out.println("✅ Conexión a PostgreSQL establecida correctamente");

            // Obtener información de la base de datos
            DatabaseMetaData metaData = conn.getMetaData();
            System.out.println("Base de datos: " + metaData.getDatabaseProductName());
            System.out.println("Versión: " + metaData.getDatabaseProductVersion());

        } catch (SQLException e) {
            System.err.println("❌ Error al conectar con PostgreSQL: " + e.getMessage());
        }
    }
}