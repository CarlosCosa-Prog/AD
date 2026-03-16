package org.cosa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Random;

/* Programa NIO que genere 100 números de lotería aleatorios (entre 0 y 9999), los guarde en un buffer,
* muestre el contenido del buffer y lo escriba a un fichero "loteria.dat"*/
public class ejercicio2A {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(100*Integer.BYTES);

        for(int i = 0; i < 100; i++){
            int numero = new Random().nextInt(1000);
            buffer.putInt(numero);
        }

        try(RandomAccessFile raf = new RandomAccessFile("loteria.dat","rw");
            FileChannel fc = raf.getChannel();) {
            buffer.clear();
            fc.write(buffer);
            buffer.flip();
            fc.read(buffer);

            int numeros[] = new int[100];
            for(int i = 0; i < 100; i++){
                numeros[i] = buffer.getInt();
            }
            System.out.println("Numeros de loteria: " + Arrays.toString(numeros));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
