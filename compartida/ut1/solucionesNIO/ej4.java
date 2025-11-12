/*
4. Crear un ByteBuffer para guardar 10 enteros, guardar en él 10 números aleatorios entre 1 y 10.
Escribir los 10 valores del buffer a un fichero. Finalmente, abrir el fichero para lectura y mostrar su contenido.
Puedes hacer uso para ello de Arrays.toString(array).

 */

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Random;

public class ej4 {
    public static void main(String[] args) {
        ByteBuffer bf = ByteBuffer.allocate(10 *Integer.BYTES); //Guardamos 10 * 4 Bytes = 40 Bytes

        //Generamos 10 numero aleatorios
        Random r = new Random();

        for(int i = 0; i < 10; i++){
            int random = r.nextInt(10) + 1;
            //System.out.println("random: " + random);
            bf.putInt(random); //Almacenamos el entero en el buffer
        }

        //Escribimos los valores en un fichero
        try(RandomAccessFile raf = new RandomAccessFile("Aleatorios.dat", "rw");
            FileChannel fc = raf.getChannel()) {
            bf.flip(); //Cambiamos a lectura y volvemos al inicio
            fc.write(bf); // Escribimos los datos en el fichero
        } catch (Exception e) {
            System.out.println("No se ha podido escribir en el fichero");
        }

        //Leemos los valores del fichero
        try(RandomAccessFile raf = new RandomAccessFile("Aleatorios.dat", "r");
            FileChannel fc = raf.getChannel();
        ){
            ByteBuffer bb = ByteBuffer.allocate(10 *Integer.BYTES);
            fc.read(bb); //Leemos y guardamos en el ByteBuffer
            bb.flip(); // Pasamos a lectura

            //Leemos los enteros del buffer
            int numeros[] = new int[10]; //Creamos un Array para almacenar los numeros

            for(int i = 0; i < 10; i++){
                numeros[i] = bb.getInt();
            }

            //Mostramos el contenido
            System.out.println("Los numeros aleatorios son:  " + Arrays.toString(numeros));

        }catch(Exception e){
            System.out.println("No se ha podido leer en el fichero");
        }




    }
}
