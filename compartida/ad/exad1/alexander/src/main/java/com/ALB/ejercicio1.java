package com.ALB;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ejercicio1 {
    public static void main(String[] args) {
        // Creamos un objeto Properties
        Properties properties = new Properties();

        // Utilizamos setProperty para poder guardar las propiedades nombre, apellidos y materia en el ficero examen.conf
        properties.setProperty("nombre", "Alexander");
        properties.setProperty("apellidos", "Luzarraga Bautista");
        properties.setProperty("materia", "Acceso a Datos");

        // Realizamos un try-catch para hacer la escritura del fichero
        try {
            // Convertimos las propiedades en un string para poder almacenarlo en el fichero
            properties.store(new FileOutputStream("examen.conf"), properties.toString());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("No se ha podido crear el archivo examen.conf");
        }

    }
}
