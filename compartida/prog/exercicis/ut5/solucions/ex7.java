// 7. Realitza un programa que elimine tots els espais en blanc repetits en un fitxer de text.

import java.io.*;

public class ex7
{
	public static void main(String[] args) {
		if (args.length > 0)
		{
			String linia;
			// generem el fluxe d'entrada
			File f = new File(args[0]);
			File f2=null;
			try
			{
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				// generem el fluxe d'eixida o escriptura
				f2 = new File(args[0]+".new");
				FileWriter fw = new FileWriter(f2);
				// llegim línia a línia des d'el fluxe d'entrada
				while((linia = br.readLine()) != null )
				{
					char l[] = linia.toCharArray();
					boolean esp=false;
					for ( int i=0 ; i < l.length ; i++)
					{					
						if ( l[i] != ' ')	// no és un espai
						{
							esp = false;
							fw.write(l[i]);
						}
						else	// és un espai en blanc
							if (esp == false)
							{
								fw.write(l[i]);
								esp = true;
							}
							//else // és espai repetit
					}
					fw.write('\n');
				}
				if (fw != null) fw.close();
				if (br != null) { br.close(); fr.close();}
			}
			catch (FileNotFoundException e)
			{
				System.err.println("Fitxer no trobat");
			}
			catch (IOException e)
			{
				System.err.println(e.getMessage());
			}
			//f.delete();
			f2.renameTo(f);
		}
		else	// Si no s'indica el nom del fitxer
			System.out.println("Forma d'ús: ex7 nomFitxer");
	}
}
