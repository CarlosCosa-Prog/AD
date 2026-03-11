package org.cosa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Random;

/* 4. Crear un ByteBuffer para guardar 10 enteros, y guardar en él 10 números aleatorios entre 1 y 10.
    Escribe los 10 valores del buffer a un fichero.
    Finalmente, abre el fichero para lectura y mostra su contenido.
    Para esto último puedes hacer uso para ello de Arrays.toString(array).
 */
public class ej4 {
    public static void main(String[] args) {
        // creo un buffer de 40 bytes (10 int de 4 bytes)
        ByteBuffer buffer = ByteBuffer.allocate(10*Integer.BYTES);

        for (int i = 0; i < 10; i++) {
            // creo numeros aletorios de 1 a 10
            int random = new Random().nextInt(10) + 1;
            // añado el entero aleatorio al buffer
            buffer.putInt(random);
        }

        try (RandomAccessFile raf = new RandomAccessFile("fichero.dat", "rw");
             FileChannel fc = raf.getChannel();) {
            buffer.clear();  // cambio el buffer a escritura
            fc.write(buffer);   // escribo los datos en el fichero

            buffer.flip(); // cambio el buffer a lectura

            fc.read(buffer);    // lee el fichero

            int numeros[] = new int[10]; // creo un array para almacenar los numeros
            for (int i = 0; i < 10; i++) {
                numeros[i] = buffer.getInt();   // añado cada número del buffer al array
            }
            // muestro por pantalla el contenido del array
            System.out.println("Los numeros aleatorios son " + Arrays.toString(numeros));


        } catch (Exception e) {
            System.out.println("No se puede escribir en el archivo");
        }
    }
}
