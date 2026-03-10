package org.cosa;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

/*0. Crea un objeto FileSystem a partir de la clase FileSystems.
 A partir del primero, obtén un objeto Path asociado al fichero a crear con el nombre "textos.txt".
Utilizando algún método estático de la clase Files escribe "Primera línea\n" y "Segunda línea\n" en dicho fichero.
Asegúrate de que se crea al escribir, truncando el contenido del fichero si ya existiera de ejecuciones anteriores.
Acaba mostrando el contenido del fichero haciendo uso también de algún otro método estático de la clase Files.*/
public class ej0 {
    public static void main(String[] args) {
        // obtener el sistema de archivos del sistema operativo
        FileSystem fis = FileSystems.getDefault();
        // ruta del fichero a crear
        Path ruta = fis.getPath("textos.txt");

        String texto = "Primera línea";
        try {
            // CREATE --> crea el archivo si no existe
            // TRNUCATE_EXSTING --> si ya existe, borra su contenido
            Files.writeString(ruta,texto,StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);
            texto = "\nSegunda línea";

            // APPEND --> añade el contenido al final sin borrar lo anterior
            Files.writeString(ruta,texto,StandardOpenOption.APPEND);

            // lee el archivo completo y devuelve una lista de Strings
            List<String> lines = Files.readAllLines(Paths.get("textos.txt"), StandardCharsets.UTF_8);

            // muestra el contenido de la lista
            for (String line : lines)
                System.out.println(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        }
    }