package org.cosa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Random;

// Programa que genere 100 numeros de loteria aleatorios entre 0 y 999, los guarde en un buffer,
// muestre el contenido del buffer y los guarde en un fichero loteria.dat
public class ejExamenA {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(100 * Integer.BYTES);

        for (int i = 0; i < 100; i++) {
            int numero = new Random().nextInt(100); // genera numeros de 0 a 999
            buffer.putInt(numero);  // añade los numeros al buffer
        }

        try (RandomAccessFile raf = new RandomAccessFile("loteria.dat","rw");
             FileChannel fc = raf.getChannel();) {

            buffer.clear(); // cambia el buffer a escritura
            fc.write(buffer);   // escibe el contenido del buffer
            buffer.flip();  // cambia el buffer a lectura
            fc.read(buffer);    // lee el contenido del buffer

            // creo un array para almacenar los numeros
            int numeros[] = new int[100];
            for (int i = 0; i < 100; i++) {
                numeros[i] = buffer.getInt();
            }

            System.out.println("Los numeros aleatorios son " + Arrays.toString(numeros));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
