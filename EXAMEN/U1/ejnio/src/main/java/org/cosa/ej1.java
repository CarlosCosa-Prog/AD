package org.cosa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/*1 NO. Crea una fichero de acceso aleatorio para guardar registros de empleados con

	id (dni sin letra), entero largo
	nombre, String con un máximo de 28 bytes
	salario, double

De esa manera, cada empleado ocupará 8 + 28 + 8 = 44 bytes

Cada empleado se guardará en la posición indicada por las 3 últimas cifras del DNI. El programa ofrecerá un menú con las opciones, como mínimo, alta de un nuevo empleado y consulta de un empleado existente (a partir del DNI). El programa habrá de permitir colisiones, guardando los sinónimos al final del fichero.

El fichero, con contenido vacío, lo puedes crear con el comando "truncate -s tamaño nomFichero".*/
public class ej1 {
    static Scanner sc = new Scanner(System.in);
    final static int TAM = 40;  // 4(int) + 8 (double) + 28(String limitado) 40 bytes

    public static void main(String[] args) {
        do {
            System.out.println("********************");
            System.out.println("Escoge una opción:");
            System.out.println("1. Alta de empleado");
            System.out.println("2. Mostrar");
            System.out.println("0. Salir del programa");
            System.out.println("********************");

            int i = sc.nextInt();
            switch (i){
                case 1: alta(); break;
                case 2: mostrar(); break;
                case 0: System.exit(0);
                default:
                    System.out.println("Error, opción incorrecta\n");
            }
        } while (true);
    }

    public static void alta(){
        try(RandomAccessFile raf = new RandomAccessFile("dniEmpleado.dat", "rw"))
        {

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
