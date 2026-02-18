/* 15. Programa que admeta les següents formes d'ús:

	java ex15

Sense paràmetres, mostrarà els permisos de lectura, escriptura i execució del directori actual per a l'usuari que execute el programa.

	java ex15 /ruta/al/fitxer/o/directori

Amb un paràmetre, mostrarà els permisos de lectura, escriptura i execució del directori indicat per a l'usuari que execute el programa
(si s'indica un fitxer, es farà per al directori que el conté)

	java ex15 /ruta/al/fitxer/o/directori [c|d|l]

Quan s'afija com a segon paràmetre una c, d o l, aquests tindran el significat de
[c]reate (crear el directori si no existeix),
 [d]elete (esborrar el directori, només si està buit)
 o [l]ist (llistar el contingut del directori). */

import java.io.*;

public class ex15 {
    public static void main(String[] args) {
        if (args.length == 0)
        {
            File f = new File(".");
            System.out.println("Permís de lectura?: " + f.canRead());
            System.out.println("Permís d'escriptura?: " + f.canWrite());
            System.out.println("Permís d'execució?: " + f.canExecute());
        }
        else
            if (args.length == 1)
            {
                File f = new File(args[0]);
                if (f.isDirectory()) {
                    System.out.println("Permís de lectura?: " + f.canRead());
                    System.out.println("Permís d'escriptura?: " + f.canWrite());
                    System.out.println("Permís d'execució?: " + f.canExecute());
                }
                else{
                    f = f.getParentFile();
                    String nom = f.getName();
                    System.out.println("Permís de lectura de " + nom + "?: " + f.canRead());
                    System.out.println("Permís d'escriptura de " + nom +"?: " + f.canWrite());
                    System.out.println("Permís d'execució de " + nom + "?: " + f.canExecute());
                }
            }
            else	// més d'un paràmetre
            {
                char c = args[1].charAt(0);
                File f = new File(args[0]);
                switch (c)
                {
                    case 'l': llista(f);break;
                    case 'd': f.delete();break;
                    case 'c': f.mkdir(); break;
                    default:
                        System.out.println("Opció incorrecta");
                }
            }
    }

    public static void llista(File f)
    {
        File noms[] = f.listFiles();
        for (int i=0 ; i < noms.length ; i++)
            if (noms[i].isDirectory())
                System.out.println(noms[i].getName() + " és un subdirectori");
            else
                System.out.print(noms[i].getName() + "és un fitxer regular");
    }
}
