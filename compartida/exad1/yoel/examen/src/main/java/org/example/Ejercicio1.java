package org.example;

import java.io.*;
import java.util.Properties;

public class Ejercicio1 {
    public static void main(String[] args) {
        try{
            FileReader in = new FileReader("examen.conf");
            Properties prop =  new Properties();
            prop.getProperty("nombre");
            prop.getProperty("grupo");
            prop.getProperty("centro");
            prop.getProperty("localidad");
            prop.load(in);
// PORQUÉ NO LAS MUESTRAS?
        }
        catch(Exception e){
            e.printStackTrace();
        }



    }
}
