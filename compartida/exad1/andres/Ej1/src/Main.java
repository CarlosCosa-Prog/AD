import java.io.*;
import java.util.Properties;
public class Main {
    public static void main(String[] args) {
        Properties pr = new Properties();

    try{
        pr.load(new FileInputStream("examen.conf"));

        System.out.println(pr.getProperty("nombre"));
        System.out.println(pr.getProperty("grupo"));
        System.out.println(pr.getProperty("centro"));
        System.out.println(pr.getProperty("localidad"));


    } catch (IOException e) {
        System.err.println(e.getMessage());
    }
    }
}

