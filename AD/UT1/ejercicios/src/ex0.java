/*
 * 0. Crea un objeto FileSystem a partir de la clase FileSystems. A partir del primero, obtén un objeto Path asociado al
 * fichero a crear con el nombre "textos.txt".
 * Utilizando algún método estático de la clase Files escribe "Primera línea\n" y "Segunda línea\n" en dicho fichero.
 * Asegúrate de que se crea al escribir, truncando el contenido del fichero si ya existiera de ejecuciones anteriores.
 * Acaba mostrando el contenido del fichero haciendo uso también de algún otro método estático de la clase Files.
 * */
import java.nio.charset.*;
import java.nio.file.*;
import java.io.*;
public  class ex0{
    public static void main(String args[]){
        try {
            FileSystem fs = FileSystems.getDefault();
            Path p = fs.getPath("textos.txt");

            // Escribir en el fichero (crear o truncar si ya existía)
            Files.writeString(p,
                    "Primera línea\nSegunda línea\n",
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);

            // Leer y mostrar el contenido
            String contenido = Files.readString(p, StandardCharsets.UTF_8);
            System.out.println("Contenido del fichero:\n" + contenido);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}