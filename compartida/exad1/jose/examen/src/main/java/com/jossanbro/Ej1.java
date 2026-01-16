package com.jossanbro;

/*
1 (2 puntoa). Programa Java que, haciendo uso de la clase java.util.Properties,
y sus metodos setProperty() y store(), guarde ñas propiedades de este examen
(nombre, apellidos y materia) a un fichero examen.conf
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;

//Dejo comentadas partes funcionales del programa pero que no se piden
//en el enunciado.

public class Ej1 {

    public static void main(String[] args) {

        Properties properties = new Properties();
        File f1 = new File("examen.conf");

        properties.setProperty("nombre", "Jose Joaquín");
        properties.setProperty("apellidos", "Sanchez Brotons");
        properties.setProperty("materia", "Acceso a Datos");

        /*
        String nombre = properties.getProperty("nombre");
        String apellidos = properties.getProperty("apellidos");
        String materia = properties.getProperty("materia");
         */

        try {
            properties.store(new FileOutputStream(f1), "nombre, apellidos, materia");

        }catch (IOException e){
            e.printStackTrace();
        }
        /*
        System.out.println(nombre);
        System.out.println(apellidos);
        System.out.println(materia);
        */

    }

}
