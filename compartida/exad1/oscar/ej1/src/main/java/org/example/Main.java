package org.example;

import java.io.*;
import java.util.Properties;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //declaranows la clase propiedades para usar el metodo setProperites
        Properties propiedades = new Properties();
            // poenoms el nombre de la proiedada(key) y su valor(keyvalue)
        propiedades.setProperty( "nombre", "Oscar" );
        propiedades.setProperty( "apellidos", "Carrillo Guaño" );
        propiedades.setProperty( "materia", "Acesso a Datos" );
        //creamos fichero de configuracion con un file Writer
        try {
            propiedades.store(new FileWriter("examen.conf"), null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}