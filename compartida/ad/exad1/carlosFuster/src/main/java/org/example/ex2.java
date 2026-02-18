package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class ex2{
	public static void main(String[] args) {
        // Creamos el buffer de escritura
        // PEDIA REALES
        // Integer.SIZE DEVUELVE 32 (BITS), no los BYTES
		ByteBuffer bbEscribir = ByteBuffer.allocate(Integer.SIZE*10);
		int numAleatorio;

        // Añadiremos numeros aleatorios entre el 0 y 10 en el buffer
		for (int i = 0; i < 10 ; i++) {
			numAleatorio = ((int)(Math.random()*11));
			bbEscribir.putInt(numAleatorio);
		}

        // Pasamos el buffer a modo escritura y escribimos este en el fichero numeros.txt von FileChannel
        bbEscribir.flip();
        // HAS PASADO A LECTURA, NO A ESCRITURA
        try(FileOutputStream fos = new FileOutputStream("numeros.txt")){
            FileChannel fc = fos.getChannel();
            fc.write(bbEscribir);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        bbEscribir.clear();

        // Creamos el buffer de lectura
        ByteBuffer bbLeer = ByteBuffer.allocate(Integer.SIZE*10);

        // Leemos el fichero anterior y lo añadimos al buffer
        try(FileInputStream fis = new FileInputStream("numeros.txt")){
            FileChannel fc = fis.getChannel();
            fc.read(bbLeer);

            // Posicionamos el buffer en la posicion 0
            bbLeer.position(0); // MEJOR FLIP

            // Añadimos el buffer a un array de int
            int[] num = new int[10];
            for(int i=0;i<10;i++){
                num[i] = bbLeer.getInt();
            }

            // Imprimimos por pantalla el array de numeros aleatorios
            System.out.println(Arrays.toString(num));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}