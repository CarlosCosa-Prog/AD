package com.ALB;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class ejercicio2 {
    public static void main(String[] args) {
        int numRandom;
        // Creamos un ByteBuffer para almacenar los números reales
        // PEDIA REALES, NO ENTEROS
        ByteBuffer bufferReales = ByteBuffer.allocateDirect(10 * Integer.BYTES);

        // Almacenamos 10 numeros aleatorios del 0 al 10;
        for (int i = 0; i < 10; i++) {
            numRandom = (int) (Math.random()*11);
            bufferReales.putInt(numRandom);
        }

        // Escribimos en un fichero el buffer
        bufferReales.flip(); // Cambiamos el buffer de escritura a lectura

        // Creamos un try-catch para la escritura del fichero
        try (FileChannel fc = FileChannel.open(Paths.get("ejercicio2.dat"),
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE)) {
            fc.write(bufferReales); // Usamos write para escribir los valores del buffer en el ficheroç
            System.out.println("Datos almacenados satisfactoriamente.\n");
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero.");
        }

        // Abrimos el fichero y leemos su contenido
        try(FileChannel fc = FileChannel.open(Paths.get("ejercicio2.dat"),
                StandardOpenOption.READ)) {

            bufferReales.flip(); // Cambiamos el buffer a modo lectura

            // NO NECESITAS OTRO BUFFER
            // Creamos un bytebuffer en el cual almacenaremos los datos del fichero
            ByteBuffer bufferRealesLecutra = ByteBuffer.allocateDirect(10 * Integer.BYTES);
            fc.read(bufferRealesLecutra); // Los datos almacenados en ejercicio2.dat se almacenan en el buffer de bufferRealesLectura

            // Creamos un array list de enteros
            int[] arrayReales = new int[10];    // PORQUÉ  NO LEES DEL BUFFER ANTERIOR
            for (int i = 0; i < arrayReales.length; i++) arrayReales[i] = bufferReales.getInt();

            System.out.println("Lectura fichero ejercicio2.dat:\n" + Arrays.toString(arrayReales));

        } catch (IOException e) {
            System.out.println("Error al leer el fichero.");
        }


    }
}
