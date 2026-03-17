package org.cosa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Random;

/*Programa NIO que cree un ByteBuffer para guardar 10 numeros reales, y guarde en el 10 números aleatorios
* entre 0 y 10. Escribe a continuación los 10 valores del buffer a un fichero. Finalmente, abre el fichero
* para lectura y muestra su contenido. Para esto último puedes hacer uso de Arrays.toString(array)*/
public class ejercicio2B {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10*Double.BYTES);
        Random r = new Random();
        for(int i = 0 ; i < 10 ; i++){
            double numero = r.nextDouble()*10;
            buffer.putDouble(numero);
        }

        try(RandomAccessFile raf = new RandomAccessFile("numerosAleatorios.dat","rw");
            FileChannel fc = raf.getChannel();) {
            buffer.flip();
            fc.write(buffer);

            fc.position(0);

            buffer.clear();
            fc.read(buffer);
            buffer.flip();

            double numeros[] = new double[10];
            for(int i = 0 ; i < 10 ; i++){
                numeros[i] = buffer.getDouble();
            }
            System.out.println(Arrays.toString(numeros));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
