/* 13. Fent ús de la classe RandomAccessFile realitza un programa que accepte parells
 de números (int i double), de tal forma que el programa escriga en binari a fitxer el
  valor double en la posició indicada per l'enter. El programa demanarà parells de números
   fins a acabar amb un parell en el qual l'enter valga negatiu.

	Exemple:

	2 3.6
	5 11.5
	3 -3.1
	0 9.4

, generarà el següent fitxer:

	--------------------------
	| | 3.6|-3.1| |11.5|
	-------------------------- */
import java.util.Scanner;
import java.io.*;
public class ex13 {
    public static void main(String[] args) {
        int pos; double num;
        Scanner ent = new Scanner(System.in);
        System.out.println("Introduix enter (negatiu per a acabar) i valor real:");
        pos = ent.nextInt();
        try (RandomAccessFile raf = new RandomAccessFile("nums.dat","rw");)
        {
            while (pos >= 0) {
                num = ent.nextDouble();
                raf.seek(pos*Double.BYTES);
                raf.writeDouble(num);
                System.out.println("Introduix enter (negatiu per a acabar) i valor real:");
                pos = ent.nextInt();
            }
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
