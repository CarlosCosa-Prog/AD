package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class EJ1 {
    public static void main(String[] args) {

        Properties propiedades = new Properties();

        propiedades.setProperty("nombre","Adrian");
        propiedades.setProperty("apellido","Sanchez");
        propiedades.setProperty("materia","Acceso a Datos");

        try (FileOutputStream fos = new FileOutputStream(new File("examen.conf"))){

            fos.write(propiedades.toString().getBytes());   // INNECESARIO
            propiedades.store(fos,"Propiedades del examen");
            System.out.println("Propiedades del examen añadidas");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
