package org.example;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class Ejercicio2 {
    public static void main(String[] args) {
        ByteBuffer bf = ByteBuffer.allocate(100*Integer.BYTES);
        int buffer = 0;
        for (int i = 0; i < 100; i++) {
            buffer = (int)(Math.random() *100000);
            bf.putInt(buffer);
        }
        bf.flip();
        while(bf.hasRemaining()){
            System.out.println(bf.getInt());
        }
        bf.rewind();
        try (FileChannel fc = FileChannel.open(Paths.get("loteria.dat"), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);){
            fc.write(bf);
            System.out.println("Fichero escrito correctamente");
        }
        catch (IOException E){
            E.printStackTrace();
        }
    }
}
