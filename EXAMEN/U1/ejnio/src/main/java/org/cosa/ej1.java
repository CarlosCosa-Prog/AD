package org.cosa;

import java.io.EOFException;
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
            System.out.println("Introduce un DNI sin letra");
            int id = sc.nextInt();
            sc.nextLine();  // limpar el buffer del teclado
            System.out.println("Introduce el nombre del empleado");
            String nombre = sc.nextLine();
            System.out.println("Introduce el salario del empleado");
            double salario = sc.nextDouble();
            sc.nextLine();

            // posicina el raf en la posición del id
            raf.seek((long) id*TAM);
            // comprueba que la posición del id esté libre
            int compruebaId = raf.readInt();
            if(compruebaId == id){  // si está libre
                // se vuelve a posicionar en la posición del id
                raf.seek((long) id*TAM);

                // si el nombre es demasiado largo lo acorta a 26
                nombre = nombre.substring(0,Math.min(nombre.length(),26));

                // escribo los datos en el raf
                raf.writeInt(id);
                raf.writeUTF(nombre);
                raf.writeDouble(salario);
            }else{  // si esta ocupada
                raf.seek(raf.length());

                raf.writeInt(id);
                nombre = nombre.substring(0,Math.min(nombre.length(),26));
                raf.writeUTF(nombre);
                raf.writeDouble(salario);
            }
        }catch (EOFException e) {
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void mostrar(){
        // creo el raf solo de lectura
        try(RandomAccessFile raf = new RandomAccessFile("dniEmpleado.dat", "r")){
            String nombre = ""; double salario = 0;
            System.out.println("Introduce el ID del empleado");
            int id = sc.nextInt();
            raf.seek((long) id*TAM);    // se posiciona en la posición del id

            int valor = raf.readInt();
            /*  3 posibilidades:
            *       1) no está en su posición (hay un heco)
            *       2) si está
            *       3) hay otro (colisión), en tal caso miro al final*/
            if(valor == id){    // 1
                System.out.println("El empleado con id " + id + " no existe");
            }else {
                if (valor == id)
                {
                    nombre = raf.readUTF();
                    salario = raf.readDouble();
                }
                else {
                    raf.seek(40000);
                    int idLeido = raf.readInt();
                    while(idLeido != id){
                        nombre = raf.readUTF();
                        salario = raf.readDouble();
                        idLeido = raf.readInt();
                    }
                    nombre = raf.readUTF();
                    salario = raf.readDouble();
                }
            }
            System.out.println("Id: "+ id + "\nNombre: " + nombre + "\nSalario: " + salario);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
