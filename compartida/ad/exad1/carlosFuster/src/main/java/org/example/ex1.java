package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ex1 {
    public static void main(String[] args) throws IOException {
        // Creamos la variable prop
        Properties prop = new Properties();
        // Añadimos sus propiedades, en este caso, nombre, apellidos y materia
        prop.setProperty("nombre", "carlos");
        prop.setProperty("apellidos", "fuster andreu");
        prop.setProperty("materia", "acceso a datos");
        // Por ultimo lo guardamos en un fichero 'examen.conf' con el comentario
        prop.store(Files.newOutputStream(Paths.get("examen.conf")),"Fichero de configuración del examen b");
    }
}
