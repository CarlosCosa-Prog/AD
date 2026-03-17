package org.cosa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/*Programa Java que pida una serie de pares de valores númericos (el primero entero positivo entre 0 y 99,
* el segundo real) y almacene los reales en un fichero de acceso aleatorio: cada real es la posición
* indicada por el entero. El programa acabará cuando el entero introducido sea cero. Se resolverá
* sin atender colisiones.*/
public class ejercicio3Rec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try(RandomAccessFile raf = new RandomAccessFile("datos.dat","rw")) {
            int posicion;
            do {
                System.out.println("Introduce posicion (0-99, 0 para acabar):");
                posicion = sc.nextInt();
                if(posicion != 0){
                    System.out.println("Introduce numero real: ");
                    double numero = sc.nextDouble();
                    raf.seek(posicion*Double.BYTES);
                    raf.writeDouble(numero);
                }
            }while(posicion != 0);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
