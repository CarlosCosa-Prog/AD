/*Programa NIO que genere 100 números de lotería aleatorios entre 0 y 99999, los guarde en un buffer muestre el contenido del buffer
* y los escriba a un fichero loteria.dat*/

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.*;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

public class ejer2 {
    public static void main(String[] args) {
    IntBuffer bf = IntBuffer.allocate(100);

    Random rand = new Random();

    for(int i = 0; i < 100; i++){
        int random = rand.nextInt(100000);
        bf.put(random);
    }

    bf.flip();


    try(FileChannel fc2 = FileChannel.open(Paths.get("loteria.dat"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        FileChannel fc = FileChannel.open(Paths.get("loteria.dat"), StandardOpenOption.READ)){
        ByteBuffer bb = ByteBuffer.allocate(bf.remaining() * Integer.BYTES);
        bb.asIntBuffer().put(bf);

        // NO PUEDES LEER DE UN FICHERO EN EL QUE TODAVÍA NO HAS ESCRITO
        fc.read(bb);

        bb.flip();

        System.out.println("Mostrar Buffer: ");
        while(bb.hasRemaining()){
            System.out.println(bb.get());
        }

        while(bb.hasRemaining()){
            bb.get();
            fc2.write(bb);
        }


        System.out.println();

        System.out.println("Buffer escrito en el documento" );


    } catch (IOException e) {
        e.getMessage();
    }


    }
}
