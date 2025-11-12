/*
* 3. Hacer un programa que, utilizando canales y búferes NIO, haga una copia de un fichero de texto en otro fichero
* donde las minúsculas sean convertidas a mayúsculas. Resuélvelo haciendo la transformación de cada caracter avanzando
* posición a posición en el buffer, leyendo y escribiendo con get() y put(),
* y ayudándote de mark() y reset() para retornar a la posición anterior.*/

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ex3 {
    public static void main(String[] args) {
        try{
            // creo el randomAccessFile y el channel para la lectura
            RandomAccessFile ficheroEnt = new RandomAccessFile("prueba.txt", "r");
            FileChannel canalEnt = ficheroEnt.getChannel();
            // creo el randomAccessFile y el channel para la escritura
            RandomAccessFile ficheroDest = new RandomAccessFile("copia.txt", "r");
            FileChannel canalDest = ficheroDest.getChannel();
            ByteBuffer bb = ByteBuffer.allocate(1024);
            while (fc.read(bb) > 0)
            {
                bb.flip();

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
