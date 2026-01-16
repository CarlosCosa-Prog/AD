package org.examen;

/*Programa NIO que genere 100 números de lotería aleatorios
(entre 0 y 99999), los guarde en un buffer, muestre el
contenido del buffer y lo escriba en un fichero "loteria.dat".
*/

import java.nio.*;
import java.nio.ByteBuffer;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

public class ej2 {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(4 * 100);
        bb.clear(); // NO HACE FALTA
        Random rand = new Random();

        // Rellenar el buffer y mostrarlo por pantalla
        try {
            for(int i=0; i<100; i++) {
                int num = rand.nextInt(99999);
                bb.mark();
                bb.putInt(num);
                bb.reset();
                System.out.println(bb.getInt());
            }
        } catch(BufferOverflowException boe){
            boe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        bb.flip();

        // no funciona
        try(FileChannel fc = FileChannel.open(Paths.get("loteria.dat"), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)){
            fc.write(bb);
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
