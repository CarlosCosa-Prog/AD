/*5. Es necessita crear una classe censura amb un mètode aplicaCensura, a la qual se li passe com a paràmetre el nom d'un fitxer, 
i substituïsca cada aparició de "Linux" per "Unix" en aquest fitxer. No et preocupes pels canvis de línia si es perden. 
Recomanacions: 

 - utilitza la classe Scanner, amb els seus mètodes next i hasNext. (mirar clase SubString)
 - crea un segon fitxer en el qual vages escrivint cada paraula, llegida del fitxer original, diferent de "Linux", i escrivint 
 "Unix" quan la paraula llegida siga aquella. Al final, pots eliminar el fitxer original i canviar de nom el nou amb el de 
 l'original.*/

import java.util.*;
import java.io.*;

class Censura
{
    private String paraulaCensurada;	// Linux
    private String paraulaCensura;	// UNix

    public Censura(String paraulaCensurada, String paraulaCensura)
    {
        this.paraulaCensurada = paraulaCensurada;
        this.paraulaCensura = paraulaCensura;
    }

    public void aplicaCensura(String nomarxiu)
    {
        File f = new File(nomarxiu);
        File f2 = new File("arxiuCensura");

            if (f.exists())
            {
                try ( 
                     Scanner sc = new Scanner(f);
                     FileWriter fw = new FileWriter(f2);
                    )
                {
                    while (sc.hasNext())
                    {
                        String s = sc.next();

                        if (s.equalsIgnoreCase(paraulaCensurada))
                            //s = s.replaceAll(s, paraulaCensura);
                            s = paraulaCensura;
                        fw.write(s + " ");
                    }
                    //f.delete();
                    f2.renameTo(f);
                }
                catch(IOException e)
                {
                    System.err.println(e.getMessage());
                }    
            }
            else 
                System.out.println("L'arxiu no existeix.");
    }
}

public class ex5
{
    public static void main(String[] args) 
 	{

		if (args.length > 0)
		{
		    Censura c = new Censura ("Linux", "Unix");
		    c.aplicaCensura(args[0]);
		}
		else 
		    System.out.println("Forma d'ús: java ex5 nomArxiu");

 	}
 }
