package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Eje1 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("examen.conf"));

            System.out.println("Nombre: "+ prop.getProperty("nombre"));
            System.out.println("Grupo: "+ prop.getProperty("grupo"));
            System.out.println("Centro: "+ prop.getProperty("centro"));
            System.out.println("Localidad: "+ prop.getProperty("localidad"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
