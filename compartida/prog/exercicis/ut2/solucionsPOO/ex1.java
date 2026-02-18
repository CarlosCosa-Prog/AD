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
    
    public rellotge(rellotge r)
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

public class ex1
{
	public static void main(String args[])
	{
		rellotge r1 = new rellotge(); // Creat amb el constructor per defecte
		rellotge r2 = new rellotge(11,62,0);
		rellotge r3 = new rellotge(23,59,59);
		
		System.out.println("Els rellotges inicialment marquen ...");
	        r1.mostra();
		r2.mostra();
		r3.mostra();
	
		// Afegim un temps positiu
		int tempsAfegit = /* 1 setmana + 15 hores + 40 minuts + 39 segons = 604800 + 54000 + 2400 + 39 */ 661239;
	
		r1.afegirTemps(tempsAfegit);
		r2.afegirTemps(tempsAfegit);
		r3.afegirTemps(tempsAfegit);

		System.out.println("Afegint interval de 1 setmana + 15 hores + 40 minuts + 39 segons els rellotges marquen ...");
               r1.mostra();
		r2.mostra();
		r3.mostra();
		
		// ara afegim un temps negatiu
		tempsAfegit = /* 1 setmana + 15 hores + 40 minuts + 39 segons = 604800 + 54000 + 2400 + 39 */ -661239;
	
		r1.afegirTemps(tempsAfegit);
		r2.afegirTemps(tempsAfegit);
		r3.afegirTemps(tempsAfegit);

		System.out.println("Retrocedint en el temps 1 setmana + 15 hores + 40 minuts + 39 segons els rellotges marquen ...");
        r1.mostra();
		r2.mostra();
		r3.mostra();
		
		System.out.println("Compare el primer rellotge amb el tercer:");
		if (r1.esAnteriorA(r3))
			System.out.println("El primer rellotge és anterior al tercer");
		else
			System.out.println("El primer rellotge és posterior al tercer");
	}
}
