package org.example;
import java.io.*;
import java.util.Properties;

public class Ej1 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        String line = null;
        try(BufferedReader br = new BufferedReader(new FileReader("examen.conf"))) {
            properties.load(br);
            System.out.println(properties.toString());
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
