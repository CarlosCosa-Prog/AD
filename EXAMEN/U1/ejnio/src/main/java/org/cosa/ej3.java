package org.cosa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/*3. Hacer un programa que, utilizando canales y búferes NIO, haga una copia de un fichero de texto en otro fichero
donde las minúsculas sean convertidas a mayúsculas.
Resuélvelo haciendo la transformación de cada caracter avanzando posición a posición en el buffer, leyendo y escribiendo
con get() y put(), y ayudándote de mark() y reset() para retornar a la posición anterior
* */
public class ej3 {
    public static void main(String[] args) throws FileNotFoundException {
        String inputFile = "minusculas.txt";
        String outputFile = "mayusculas.txt";
        try (FileInputStream fis = new FileInputStream(inputFile);  // creo los stream
             FileOutputStream fos = new FileOutputStream(outputFile);
             FileChannel inputChannel = fis.getChannel();
             FileChannel outputChannel = fos.getChannel())
        {
            ByteBuffer buffer = ByteBuffer.allocate(1024);  // creo el buffer con capacity 1024 bytes

            while (inputChannel.read(buffer) > 0) {
                // cambia el buffer a escritura y establece la posición a 0
                buffer.flip();
                // creo un nuevo buffer para almacenar los bytes transformados
                ByteBuffer buffer2 = ByteBuffer.allocate(1024);
                while (buffer.hasRemaining()) { // hasRemaining comprueba si todavía quedan datos por leer
                    buffer.mark();  // marca la posición actual 0
                    // lee el byte, lo convierta a char y avanza una posición
                    char c = (char) buffer.get();

                    // si es minuscula la convierte a mayuscula y añade el caracter al buffer 2
                    if (Character.isLowerCase(c)) {
                        c = Character.toUpperCase(c);
                        buffer2.put((byte) c);
                    } else
                        buffer2.put((byte) c);
                }
                    // cambia de escritura a lectura y establece la posición 0
                    buffer2.flip();
                    // escribe el contenido del buffer en el canal
                    outputChannel.write(buffer2);
                    buffer.clear(); // limpia el buffer para futuras lecturas
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
