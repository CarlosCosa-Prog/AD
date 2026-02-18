/*
	6. Programa que compte les paraules existents en un fitxer de text, fent ús de Scanner per a llegir de fitxer. Utilitza next() i hasNext(), tenint en compte els delimitadors per defecte per a aquests mètodes. */

import java.io.*;
import java.util.*;

class compta
{
	public int comptaParaules(File f) throws IOException
	{
		Scanner ent=new Scanner(f);
		int cont=0;
		
		while(ent.hasNext())
		{
			ent.next(); //
			cont++;
		}
		return cont;
	}
}

public class ex6
{
	public static void main(String args[]) throws IOException
	{
		File f=new File(args[0]);
		
		compta c=new compta();
		System.out.println("El fitxer té "+ c.comptaParaules(f) + " paraules.");
	}
}
	
