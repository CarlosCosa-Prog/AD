package org.cosa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Random;

/* Programa NIO que cree un ByteBuffer para guardar 10 numeros reales, y guarde en el 10 numeros
* aletorios entre 0 y 10. Escribe a continuación los 10 valores del buffer a un fichero.
* Finalemente, abre el fichero para lectura y muestra su contenido.
* Para esto último puede hacer uso de Arrays.toString(array)*/
public class ejExamenB {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10 * Double.BYTES);

        for (int i = 0; i < 10; i++) {
            double numAleatorio = new Random().nextDouble(10);
            buffer.putDouble(numAleatorio);
        }
        try (RandomAccessFile raf = new RandomAccessFile("numerosAleatorios.txt","rw");
             FileChannel fc = raf.getChannel();) {
            buffer.clear();
            fc.write(buffer);

            buffer.flip();
            fc.read(buffer);

            double array[] = new double[10];
            for (int i = 0; i < 10; i++) {
                array[i] = buffer.getDouble();
            }
            System.out.println(Arrays.toString(array));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
