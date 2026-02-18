// 2. Escriure un programa que reba com a dades una cadena de caracters i un caracter, i reporta el nombre de vegades que es troba el caracter en la cadena. 

import java.util.Scanner;

public class ex2
{
	public static void main(String[] args) //throws StringIndexOutOfBoundsException
	{
		int cont=0; char caracter =' ';
		
		Scanner ent = new Scanner(System.in);
		System.out.println("Introduix un text:");
		String prova = ent.nextLine();
		System.out.println("Introduix un caracter:");
		try
		{
			caracter = ent.nextLine().charAt(0);
		}
		catch (StringIndexOutOfBoundsException e)
		{
			System.err.println(e.getMessage());
		}
		for(int i=0 ; i < prova.length(); i++)
			if (prova.charAt(i) == caracter)
				cont++;
		
		System.out.println("El caracter apareix en "+ cont +" ocasions");
	}
}
