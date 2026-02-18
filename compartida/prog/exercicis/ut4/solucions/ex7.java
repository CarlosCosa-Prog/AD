/* 7. Fes un programa que demane valors enters i, per a cadascun d'ells, mostre el seu màxim divisor.
Per exemple, per a 52 serà 26 o per a 81 serà 27. Hauràs d'utilitzar un objecte Vector que guarde
tots els valors introduïts des de teclat i utilitzar el seu mètode forEach. */

import java.util.*;

public class ex7
{
	public static void main(String args[])
	{
		Scanner ent = new Scanner(System.in);
		Vector<Integer> vector = new Vector<Integer>();
		System.out.println("Introduix un enter positiu ( 0 o negatiu per a acabar):");
		int num = ent.nextInt();
		while (num > 0)
		{
			vector.add(num);
			System.out.println("Introduix un enter positiu ( 0 o negatiu per a acabar):");
			num = ent.nextInt();
		}
		vector.forEach(n -> { int i=1; int max =1;
					 while(i < n)
					 {
					  	if ((n % i) == 0)
					  		max = i;
					  	i++;
					  }
					  System.out.println(max);
				}); 
	}

}
