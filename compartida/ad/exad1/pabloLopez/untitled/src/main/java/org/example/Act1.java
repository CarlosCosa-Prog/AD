package org.example;

import java.io.FileOutputStream;
import java.util.Properties;

public class Act1{
    public static void main(String[] args) {

        Properties prop = new Properties();

        prop.setProperty("nombre", "Pablo");
        prop.setProperty("apellido", "Lopez");
        prop.setProperty("materia","Acceso A datos");

        try{
            prop.store(new FileOutputStream("examen.conf"), "propiedades.properties");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}