package org.example;

import java.io.IOError;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ej2 {
    public static void main(String[] args) {
        Path ruta = Path.of("numerosAleatorios.dat");
        double numAleatorio;

        try (FileChannel fc = FileChannel.open(ruta, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.READ))
        {
            ByteBuffer buffer = ByteBuffer.allocate(10 * Double.BYTES);
            for (int i = 0; i < 10; i++) {
                numAleatorio = (double) (Math.random() * 10);

                buffer.putDouble(numAleatorio);
            }

            buffer.flip();
            fc.write(buffer);
            buffer.flip();  // HA DE SER CLEAR()

            int cont = 1;
            while (buffer.hasRemaining()) {
                double numAleatorio2 = buffer.getDouble();
                System.out.println(cont + ". " + numAleatorio2);
                cont++;
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
