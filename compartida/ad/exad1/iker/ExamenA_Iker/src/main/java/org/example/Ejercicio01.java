package org.example;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

public class Ejercicio01 {
    public static void main(String args[])  {
        try {
            Path pt = Paths.get("examen.conf");


            InputStream in = Files.newInputStream(pt);
            Properties prop = new Properties();
            prop.load(in);


            for (String key : prop.stringPropertyNames()) {
                System.out.println(key + ": " + prop.getProperty(key));

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
