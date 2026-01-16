package org.example;

import org.postgresql.util.ByteBufferByteStreamWriter;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class Ejercicio02 {
    public static void main(String[] args) {

        //Creamos el bufer con 100 enteros de capacidad.
        ByteBuffer bf = ByteBuffer.allocate(100*Integer.BYTES);

        //Hacemos un for para insertar los numero aleatorios.
        for (int i = 0; i < 100; i++) {
            bf.putInt((int)(Math.random()*99999) +1);
        }

        bf.flip();
        //Escribimos los datos en el archivo de loteria
        try(FileChannel fc = FileChannel.open(Paths.get("loteria.dat"), StandardOpenOption.WRITE, StandardOpenOption.CREATE,  StandardOpenOption.TRUNCATE_EXISTING)) {
            fc.write(bf);
            bf.rewind();

            //Hacemos una array para que nos imprima solo los numeros de loteria y que no nos imprima los bytes por así decirlo
            int[] numeros = new int[100];
            for (int i = 0; i < 100; i++) {
                numeros[i] = bf.getInt();
            }


            //Usamos un metodo de Arrays.toString para que nos imprima los numeros de la loteria.
            System.out.println("Los numeros de loteria son: \n" + Arrays.toString(numeros));



        } catch (Exception e) {


        }


    }
}
