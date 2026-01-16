package org.example;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Eje2 {
    public static void main(String[] args) {
        // EL TAMAÑO HABÍA DE SER 100*4
        ByteBuffer buffer = ByteBuffer.allocate(100000*Integer.BYTES);
        Path path = Paths.get("fichero.txt");
        int valor;
        for (int i = 0; i < 1000000; i++) {
            valor = (int)(Math.random()*100000);
            buffer.putInt(valor);   // EXCEDES LA CAPACIDAD DEL BUFFER POR UN CERO DE MAS
        }
        buffer.flip();

        try {
            FileChannel fc = FileChannel.open(path, StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.TRUNCATE_EXISTING);
            fc.write(buffer);
            fc.position(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
