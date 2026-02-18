package com.jossanbro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/*
2 (2 puntos). Programa NIO que cree un ByteBuffer para guardar números reales, y guarde en él 10 números aleatorios entre 0 y 10.
Escribe a continuación los 10 valores del buffer a un fichero. Finalmente, abre el fichero
para lectura y muestra su contenido. Para esto último puedes hacer uso de Arrays.toString(array)
 */

public class Ej2 {

    public static void main(String[] args) {

        //File f1 = new File("Ej2.txt");
        ByteBuffer buffer = ByteBuffer.allocate(10* Integer.BYTES);

        while (buffer.hasRemaining()) {
            buffer.put((byte)(int)(Math.random()*10));
        }

        try (RandomAccessFile rafEscritura = new RandomAccessFile("Ej2.txt", "rw");
            FileChannel channel = rafEscritura.getChannel()) {

            buffer.flip();
            channel.write(buffer);

            buffer.flip();


        } catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();

        } catch(IOException e){
            e.printStackTrace();
    // FALTA LA 2ª PARTE
        }
    }

}
