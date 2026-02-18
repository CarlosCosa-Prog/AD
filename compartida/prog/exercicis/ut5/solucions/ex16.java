/* 16. Programa que afija línies de text codificades a un fitxer de text.
 El programa ha de permetre afegir una línia de text nova codificada o de mostrar tot el contingut del fitxer (codificat o descodificat).
  Pots inventar-te l'algorisme o forma de codificació. */

import java.io.*;
import java.util.Scanner;

public class ex16 {
    public static void main(String[] args) {
        int opc;
        Scanner ent = new Scanner(System.in);
        System.out.println("Trie entre estes opcions:\n" +
                "\t1. Afegir línia de text\n" +
                "\t2. Mostrar el contingut del fitxer codificat\n" +
                "\t3. Mostrar el contingut del fitxer descodificat\n" +
                "\t4. Acabar"

        );
        opc = ent.nextInt();
        // per problema del buffer del teclat
        ent.nextLine();
        while (opc != 4)
        {
            switch (opc)
            {
                case 1:
                    System.out.println("Línia a afegir:");
                    String linia = ent.nextLine();
                    linia = codifica(linia);
                    afigLinia(linia);break;
                case 2: mostra();break;
                case 3: mostraDecod();break;
                case 4: System.exit(0);break;
                default: System.out.println("Opció incorrecta");
            }
            System.out.println("Trie entre estes opcions:\n" +
                    "\t1. Afegir línia de text\n" +
                    "\t2. Mostrar el contingut del fitxer codificat\n" +
                    "\t3. Mostrar el contingut del fitxer descodificat\n" +
                    "\t4. Acabar"

            );
            opc = ent.nextInt();
            // per problema del buffer del teclat
            ent.nextLine();
        }
    }

    public static void mostra()
    {
        String linia;
        try(FileInputStream fis = new FileInputStream("text16.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);)
        {
            while((linia = br.readLine()) != null)
                System.out.println(linia);
        }
        catch(IOException e)
        {
            System.err.println(e.getMessage());
        }
    }

    public static void mostraDecod()
    {
        String linia;
        try(FileInputStream fis = new FileInputStream("text16.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);)
        {
            while((linia = br.readLine()) != null)
            {
                linia = decodifica(linia);
                System.out.println(linia);
            }
        }
        catch(IOException e)
        {
            System.err.println(e.getMessage());
        }
    }
    public static String codifica(String linia)
    {
        char array[] = linia.toCharArray();
        for(int i=0 ; i  < array.length; i++)
            array[i] += 3;
        linia = new String(array);
        return linia;
    }

    public static String decodifica(String linia)
    {
        char array[] = linia.toCharArray();
        for(int i=0 ; i  < array.length; i++)
            array[i] -= 3;
        linia = new String(array);
        return linia;
    }

    public static void afigLinia(String linia)
    {
        try(FileWriter fw = new FileWriter("text16.txt",true);)
        {
            fw.write(linia + "\n");
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
