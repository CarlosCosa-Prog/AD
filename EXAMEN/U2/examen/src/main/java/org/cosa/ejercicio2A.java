package org.cosa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Random;

/*Programa NIO que genere 100 números de lotería aleatorios entre 0 y 99999,
* los guarde en un buffer, muestre el contenido y lo escriba a un fichero
* "lotería.dat"*/
public class ejercicio2A {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(100 * Integer.BYTES);
        Random r = new Random();
        for (int i = 0 ; i < 100 ; i++){
            int numero = r.nextInt(100000);
            buffer.putInt(numero);
        }

        try(RandomAccessFile raf = new RandomAccessFile("loteria.dat","rw");
            FileChannel fc = raf.getChannel();) {

            // escribir en el fichero
            buffer.flip();
            fc.write(buffer);

            fc.position(0); // establece la posición del fileChanel a 0

            buffer.clear();
            fc.read(buffer);
            buffer.flip();

            int numeros[] = new int[100];
            for(int i = 0 ; i < 100 ; i++){
                numeros[i] = buffer.getInt();
            }
            System.out.println("Numeros alatorios: " + Arrays.toString(numeros));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
