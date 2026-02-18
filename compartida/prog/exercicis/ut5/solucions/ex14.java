/* 14. Programa que permeta generar un sorteig de Loteria primitiva (6 números entre 1 i 49, sense repeticions)
 i registre en un fitxer binari 49 contadors que comptabilitzen quantes vegades ha eixit cada número.
  Per a cada sorteig el programa haurà d'incrementar en una unitat 6 dels contadors.
   El programa ha d'oferir un menú per a triar entre 2 opcions:
    a) generar un sorteig,
    b) mostrar comptadors de tots els números. */
 import java.io.*;
 import java.util.Random;
 import java.util.Scanner;
 
public class ex14 {
    public static void main(String[] args) {
        // Abans d'executar la primera vegada s'ha de crear el fitxer buid amb els 49*4 bytes de grandària
        //  truncate -s 196 primitiva.dat
        int opc;
        Scanner ent = new Scanner(System.in);
        RandomAccessFile raf;
        System.out.println("Trie entre 3 opcions:\n" +
                "\t1) generar un sorteig,\n" +
                "\t2) mostrar comptadors de tots els números,\n" +
                "\t3) acabar");
        opc = ent.nextInt();
        while (opc != 3)
        {
            switch (opc)
            {
                case 1:
                    int valors[] = sorteig();
                    registraValors(valors);
                    mostraArray(valors);
                    break;
                case 2:
                    mostraComptadors();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Opció incorrecta");
            }
            System.out.println("Trie entre 3 opcions:\n" +
                    "\t1) generar un sorteig,\n" +
                    "\t2) mostrar comptadors de tots els números,\n" +
                    "\t3) acabar");
            opc = ent.nextInt();
        }
    }

    public static int[] sorteig()
    {
        int cont=0; boolean repetit;
        int nums[] = new int[6];

        while (cont < 6) {
            // generem les 6 tirades de la primitiva
            // cada valor comprovem si és repetit
            // Si és repetit (ja existent en l'array) no avancem el comptador per a repetir passada pel bucle
            int valor = (int) (1 + 49 * Math.random());
            repetit = false;
            nums[cont] = valor;
            for (int i = 0; i < cont; i++)
                if (nums[i] == valor)
                    repetit = true;
            if (repetit)
                cont--;
            cont++;
        }
        return nums;
    }
    public static void registraValors(int valors[])
    {
        try(RandomAccessFile raf = new RandomAccessFile("primitiva.dat","rw");)
        {
            for (int i=0 ; i < 6 ; i++)
            {
                // Reste 1 al posicionament perque per a la posició N he d'avançar N-1
                raf.seek((valors[i]-1)*Integer.BYTES);
                int valor = raf.readInt();
                valor++;
                // torne a possicionar-me (per haver avançat al llegir)
                raf.seek((valors[i]-1)*Integer.BYTES);
                raf.writeInt(valor);
            }
        }
        catch(IOException e)
        {
            System.err.println(e.getMessage());
        }
    }

    public static void mostraComptadors()
    {
        try(RandomAccessFile raf = new RandomAccessFile("primitiva.dat","r");)
        {
            int i=1;
            // és un fitxer aleatori però el puc accedir sequëncialment
            while (true)
            {
                System.out.println("Aparicions del número " + i + ": "+  raf.readInt());
                i++;
            }
        }
        catch (EOFException e) {  }
        catch(IOException e)
        {
            System.err.println(e.getMessage());
        }
    }

    public static void mostraArray(int valors[])
    {
        for(int i=0 ; i < valors.length ;i++)
            System.out.println(valors[i]);
    }
}
