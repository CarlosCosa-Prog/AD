/* 3. Crea un programa que genere un array dinàmic de tipus Vector<Integer>. El programa acceptarà valors, positius i negatius, fins a acabar amb un 0. Mostrará tots els valors guardats i acabarà esborrant tots els negatius del Vector. Per a esborrar-los has d'usar Collection.removeIf.

L'hauràs de resoldre de 3 formes diferents:
    - instanciant un objecte d'una classe que implemente la interfície Predicate
    - instanciant una classe anònima que implemente la interfície Predicate
    - amb una expressió lambda */

 
import java.util.*;
import java.util.function.*;

public class ex3
{
	public static void main(String args[])
	{
		// NO FAIG COMPROVACIÓ DEL PAS DE PARÀMETRES
		Vector<Integer> v = new Vector<Integer>();
		for (String s: args)
			v.add(Integer.valueOf(s));
			
		// mostrar el contingut del vector
		System.out.println("Contingut inicial del vector:");
		for (Integer i: v)
			System.out.println(i);
			
		// ara esborre ELS negatius
		// utilitze una expressió LAMBDA
		Predicate<Integer> p = i-> (i < 0);
		v.removeIf(p);
		
		// torne a mostrar el contingut del vector
		System.out.println("Després d'esborrar negatius");
		for (Integer i: v)
			System.out.println(i);
	}
}
