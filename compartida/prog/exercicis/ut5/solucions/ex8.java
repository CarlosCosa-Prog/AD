/* 8. Programa que, utilitzant la classe PushbackReader, faça substitucions sobre un fitxer de text de manera que, sempre que trobe una majúscula al principi d'una frase (després del punt .) i que no vaja precedida per un espai, inserisca el corresponent espai en blanc.

	Exemple:
	
		Hola.Soc David. T'escric per a ...
		
			serà substituït per
			
		Hola. Soc David. T'escric per a ... */

import java.io.*;
		
public class ex8
{
	public static void main(String[] args)
	{
		if (args.length > 0)
		{
			File f = new File(args[0]);
			File f2 = new File("temp");
			
			if (f.exists())
			{
				try(FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr);
					FileWriter fw = new FileWriter(f2); )
				{
					String linia;
					// bucle per a lectura línia a línia
					while ((linia = br.readLine()) != null)
					{
						String novaLinia="";
						StringReader sr = new StringReader(linia);
						PushbackReader pbr = new PushbackReader(sr);
						// bucle caracter a caracter dintre d'una mateixa línia
						int ultim,penultim;
						while ( (ultim = pbr.read()) != -1)
						{
							if (ultim != (int) '.')
								novaLinia += (char) ultim;
							else // si és un punt (.)
							{
								penultim = ultim;	// penultim = '.'
								ultim = pbr.read();
								// comprove si és majúscula
								if (( ultim >= 65) && (ultim <= 90))
								{
									novaLinia += ". ";
									pbr.unread(ultim);
								}
								else // no es majúscula
								{
									novaLinia += ".";
									// Si la línia acabara amb punt evite escriure com a caracter -1 (valor retornat per read() quan arriba al final)
									if (ultim != -1)
										pbr.unread(ultim);
								}
							}
							penultim = ultim;
						}
						fw.write(novaLinia + '\n');
					}
				}
				catch(IOException e)
				{
					System.err.println(e.getMessage());;
				}
				f2.renameTo(f);				
			}
			else
				System.out.println("El fitxer no existeix");
		}
		else
			System.out.println("Forma d'ús: java ex8 /ruta/al/fitxer");
	}
}
