// clase para crear objeto rellotge
/*
1. Crear una classe Rellotge (hora,minuts,segons) que permeta almenys:

 - crear rellotges amb hora inicial les 12 del migdia
 - crear rellotges amb hora inicial a triar
 - canviar només l'hora, només els minuts o només els segons (setters)
 - obtindre només el valor d'hora, o de minuts o de segons (getters)
 - obtindre els segons transcorreguts des de les 12 de la mitjanit()
 - afegir una quantitat de temps expressada en segons (vigila que els minuts o segons no excedisquen de 59, ni les hores de 23).
 	Exemple:
 	si el rellotge marca les 10.35:24 i se li afigen 1810 segons (mitja hora i 10 segons) quedarà en 11.05:34
 - ... (altres operacions que se t'ocórreguen útils)
 
 Si vulgerem retrocedir en el temps un rellotge, ¿hauriem de fer una nova funció o ho podriem fer amb les anteriors?
 
 Crea un programa que instàncie rellotges posant a prova tota la classe anterior.

*/

import java.util.Scanner;

	// VERSIO BÀSICA O SIMPLE: QUALSEVOL VALOR INCORRECTE ES POSARÀ A ZERO
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
}

public class ex1Menu
{
	private static Scanner ent = new Scanner(System.in);
	public static void main(String args[]) throws InterruptedException
	{
		int opcio,hores,minuts,segons;
		rellotge r=null,r2=null; 
		
		while ((opcio = mostraMenu()) != 0)
		{
			switch (opcio)
			{
				case 1: r = new rellotge(); break;
				
				case 2:	System.out.println("Introduix hora:");
						hores = ent.nextInt();
						System.out.println("Introduix minut:");
						minuts = ent.nextInt();
						System.out.println("Introduix segon:");
						segons = ent.nextInt();
						r = new rellotge(hores,minuts,segons); break;
						
				case 3: r.mostra(); break;
				
				case 4: 	System.out.println("Introduix segons:");
						segons = ent.nextInt();
						r.afegirTemps(segons); 
						System.out.print("El rellotge queda actualitzat a les ");
						r.mostra(); break;
						
				case 5: 	System.out.println("Introduix hores:");
						hores = ent.nextInt();
						System.out.println("Introduix minut:");
						minuts = ent.nextInt();
						System.out.println("Introduix segon:");
						segons = ent.nextInt();
						r.afegirTemps(3600*hores + 60*minuts + segons); 
						System.out.print("El rellotge queda actualitzat a les ");
						r.mostra(); break;
						
				case 6: 	
						System.out.println("Introduix primer els valors del nou rellotge");
						System.out.println("Introduix hora:");
						hores = ent.nextInt();
						System.out.println("Introduix minut:");
						minuts = ent.nextInt();
						System.out.println("Introduix segon:");
						segons = ent.nextInt();
						r2 = new rellotge(hores,minuts,segons);
						if (r.esAnteriorA(r2))
							System.out.println("El rellotge marca un temps anterior al nou");
						else
							System.out.println("El rellotge actual marca un temps posterior al nou");
						 break;
	
				case 7:     int cont = 0;
						while( cont < 10 )
						{
							Thread.sleep(1000);
							r.afegirTemps(1);
							r.mostra();
							cont++;
						};break;
				default: System.out.println("Opció incorrecta");
			}
		}
	}
	
	public static int mostraMenu()
	{
		System.out.println("\n1. Crea rellotge a les 12:00:00");
		System.out.println("2. Crea rellotge a la hora desitjada");
		System.out.println("3. Mostra el rellotge");
		System.out.println("4. Afegir temps ens segons");
		System.out.println("5. Afegir temps ens hores, minuts i segons");
		System.out.println("6. Comparar amb altre rellotge");
		System.out.println("7. Posar en marxa el rellotge durant 10 segons");
		System.out.println("0. Acabar el programa");
		System.out.println("\t\tRECORDA CREAR AL PRINCIPI EL RELLOTGE AMB LES OPCIONS 1 o 2 !!!");
		System.out.println("\tTria la teua opció:");
		return ent.nextInt();
	}
}
