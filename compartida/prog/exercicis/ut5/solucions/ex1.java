/*Programa que mostre unes determinades línies d'un fitxer de text. Tant el fitxer com els números de línia (en ordre creixent) seran passats com a paràmetres en l'execució. Exemple:

	java ex1 /ruta/Al/Fitxer 3 7 10 */

import java.io.*;
public class ex1
{
	public static void main(String[] args)
	{
		if (args.length > 0)
		{
			try
			{
				File f = new File(args[0]);
				//FileInputStream fis= new FileInputStream(f);
				//InputStreamReader isr = new InputStreamReader(fis);
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				String linia="";
				int cont=1;
				int i=1;
				while((linia = br.readLine())!=null && i<args.length)
				{	
					if(cont == Integer.parseInt(args[i]))
					{
						System.out.println(linia);
						i++;
					}
					cont++;
				}
				if (br != null)
				{
					br.close();
					fr.close();
				}
			}
			// IOException inclou també altres excepcions derivades
			catch(IOException e)
			{
				System.err.println(e.getMessage());
			}
		}
		else
			System.out.println("Forma d'ús: java ex1 [RutaFitxer] [NºLinies].");	
	}
}

