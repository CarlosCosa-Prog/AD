package com.dam2.ut1.ejemplos.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

public class Genera5000 {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("nums.dat");
             FileChannel fc = fos.getChannel()) {

            // Crear un buffer para 5000 enteros (20000 bytes)
            ByteBuffer byteBuffer = ByteBuffer.allocate(5000 * 4);
            IntBuffer intBuffer = byteBuffer.asIntBuffer();

            for (int i = 1; i <= 5000; i++) {
                intBuffer.put(i);
            }

            // Escribir en fichero
            fc.write(byteBuffer);

            System.out.println("Fichero generado: nums.dat");
            System.out.println("Tamaño: " + (5000 * 4) + " bytes");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}