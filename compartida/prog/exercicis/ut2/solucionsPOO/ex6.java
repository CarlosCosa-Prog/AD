/* 6. En un aparcament volen registrar les entrades de cotxes al llarg de cada dia. Per a això, has de fer un programa que treballe amb una classe Entrada que continga 2 atributs:
	- matrícula del cotxe (String)
	- instant de l'entrada (Rellotge)
Reutilitza la classe Rellotge de l'exercici 1.

Per a poder guardar diferents entrades pots fer ús d'un array estàtic */

import java.util.Scanner;

public class ex6
{
	// EL parking compta amb plaçes d'aparcament limitades
	private static final int TAM = 4;
	private static Entrada es[];
	private static Scanner ent = new Scanner(System.in);
	
	static
	{
		es = new Entrada[TAM];
	}
	
	public static void main(String[] args) 
	{
		int entrades = 0, opcio;
		int hores, minuts, segons;
		String matricula;
		rellotge r;
		Entrada e;
		
		
		
		while ((opcio = mostraMenu()) != 0)
		{
			switch (opcio)
			{		
				case 1:
					if (entrades < TAM)
					{
						System.out.println("Introduix hora:");
						hores = ent.nextInt();
						System.out.println("Introduix minut:");
						minuts = ent.nextInt();
						System.out.println("Introduix segon:");
						segons = ent.nextInt();
						// per a evitar el problema del buffer del teclat
						ent.nextLine();
						System.out.println("Introduix matrícula:");
						matricula = ent.nextLine();
						r = new rellotge(hores,minuts,segons); 
						es[entrades] = new Entrada(matricula,r);
						entrades++;
					}
					else
						System.out.println("L'aparcament està complet");
						break;
						
				case 2: for (int i = 0; i < entrades ; i++)
						System.out.println(es[i]); break;

				default: System.out.println("Opció incorrecta");
			}
		}	
	}
	
	public static int mostraMenu()
	{
		System.out.println("\n1. Introduix entrada");
		System.out.println("2. Llista totes les entrades");
		System.out.println("0. Acabar el programa");
		System.out.println("\tTria la teua opció:");
		return ent.nextInt();
	}
}

class Entrada
{
	private String matr;
	private rellotge rel;
	
	public Entrada()
	{
		matr = "1111MMM";
		rel = new rellotge();
	}
	
	public Entrada(String m, rellotge r)
	{
		matr = m;
		rel = r;
	}
	
	public Entrada(Entrada e)
	{
		matr = e.matr;
		rel = e.rel;
	}
	
	public void setMatr(String m)
	{
		matr = m;
	}

	public void setRel(rellotge r)
	{
		rel = r;
	}
	
	public String getMatr()
	{
		return matr;
	}

	public rellotge getRel()
	{
		return rel;
	}
	// PER A PODER LLISTAR CADA ENTRADA FÀCILMENT
	public String toString()
	{
		return "Matrícula: " + matr + ", entrada a les " + rel;	// FALTA INCLOURE TOSTRING() EN RELLOTGE
	}
	
}	// fi classe Entrada

class rellotge
{
	private int hora;
	private int minuts;
	private int segons;

	// constructors
	public rellotge()	// per defecte
	{
		hora = 12;
		//minuts = segons = 0
	}

	public rellotge(int h, int m, int s)	// general
	{
		// Qualsevol valor incorrecte es deixarà a 0
		if ((h >= 0) && (h < 24))
			hora = h;
		if ((m >= 0) && (m < 60))
			minuts = m;
		if ((s >= 0) && (s < 60))
			segons = s;
		// no fan falta el "else": quedaran a 0
	}
    
    public rellotge(rellotge r)	// de còpia
    {
    	hora = r.hora;
    	minuts = r.minuts;
    	segons = r.segons;
    }

    // Setters
	public void setHora(int h)
	{
		if ((h >= 0) && (h < 24))
			hora = h;
	}

	public void setMinuts(int m)
	{
		if ((m >= 0) && (m < 60))
			minuts = m;
	}

	public void setSegons(int s)
	{
		if ((s >= 0) && (s < 60))
			hora = s;    
	}

	/* Getters: donat que els mètodes que canvien hores, minuts i segons sempre deixen valors entre
	els marges correctes poden retornar el valor sense fer cap comprovació */
	public int getHora()
	{
		return hora;
	}

	public int getMinuts()
	{
		return minuts;
	}

	public int getSegons()
	{
		return segons;
	}

	public void mostra()
	{
		System.out.println(hora + " : " + minuts + " : " + segons);
	}
    
	public int segonsTotals()	// transcorreguts des de la mitjanit
	{
		return hora * 3600 + minuts * 60 + segons;
	}

	public void afegirTemps(int s)
	{
		// s pot ser negatiu o superior a 60
		int totalSegons = s + segonsTotals();
	
		hora = (totalSegons / 3600) % 24;
		minuts = (totalSegons / 60) % 60; 
		segons = totalSegons % 60;
		corregixNegatius();
	}
	
	public void corregixNegatius()
	{
		if (segons < 0)
		{
			segons += 60;
			minuts--;
		}
		if (minuts < 0)
		{
			minuts += 60;
			hora--;
		}
		if (hora < 0)
			hora += 24;
	}
	
/*	public boolean esAnteriorA(rellotge r)
	{
		if (this.hora < r.hora)
			return true;
		else 
			if (this.hora == r.hora) && (this.minuts < r.minuts)
				return true;
				// ... FALTARIA COMPROVAR SI COINCIDIXEN HORES I MINUTS I, ALESHORES, COMPARAR ELS SEGONS ...
				// ... MOLT COMPLICAT --> SOLUCIÓ ÒPTIMA: UTILITZAR LA FUNCIÓ segonsTotals 
	}*/
	
	public boolean esAnteriorA(rellotge r)
	{
		if (segonsTotals() < r.segonsTotals())
			return true;
			// no fa falta ELSE 
		return false;
	}
	
	public String toString()
	{
		return hora +":"+minuts+":"+segons;
	}
}
