/* 1. Crear un array d'objectes Futbolista(nom,gols) i ordena l'array (amb el mètode de la bambolla, bubble-sort) perquè aquest siga la taula de màxims golejadors, ordenats de major a menor nombre de gols. El programa acabarà mostrant la classificació. */

import java.util.Scanner;

class futbolista 
{

    private String nom;	
    private int gols;
    
    public futbolista () {	// Constructor per defecte.
	    nom="AAA";
	    gols=1;
    }
    
    public futbolista (String nombre, int goles) 
    {	// Constructor general.
	    nom=nombre;
	    gols=goles; 
    }
    
    public void setNom(String nombre)
    {	// Un setter per cada atribut.
    	nom=nombre;
    }
    
    public void setGols (int goles) {
    	gols=goles;
    }
    
    public String getNom () {		// Un getter per cada atribut.
    	return nom;
    }
    
    public int getGols() {
    	return gols;
    }
    
    public String toString() { 
    	return "El jugador " + nom + " ha marcat " + gols + " gols.";
    }
}


public class ex1 {

public static void main (String args[]) {
	
	String nom;	
	int gols;
	futbolista futbolistes[] = new futbolista[4];		//Creem l'array de 4 objectes futbolista
	Scanner entrada = new Scanner(System.in);	//  objceto Scanner per a introduïr des de teclat
	
	System.out.println("REGISTRE DELS 4 MILLORS GOLEJADORS");
	System.out.println("Introduix alternativament nom i quantit de gols marcats....");
	
	for (int i=0; i<4; i++)
	{	
		nom = entrada.nextLine();
		gols = entrada.nextInt();
					
		while (gols<=0)
		{		
			System.out.println("Per favor, introduix un número vàlid...");
			gols = entrada.nextInt();
		}		
					
		futbolistes[i] = new futbolista (nom, gols);
		System.out.println("¡Registre " + (i+1) + "º correcte!.\n");    
		
		entrada.nextLine();		// per a netejar el buffer (s'ha de fer quan llegim text després de llegir números)
	}
		
	System.out.println("RESUMEN DE GOLEJADORS INTRODUITS:");	
	for (int i=0; i < futbolistes.length; i++) 
		System.out.println(futbolistes[i]);
		
	System.out.println();
	
	System.out.println("\tCLASIFICACIO ORDENADA DE GOLEJADORS:");
	// ordenació no optimitzada
	for (int limit = futbolistes.length - 2; limit > 0; limit--)
		for (int j=0; j <= limit ; j++)				
			if (futbolistes[j+1].getGols() > futbolistes[j].getGols())
			{
				futbolista aux = futbolistes[j];		//la variable aux ha de ser del mateix tipus de l'obcjete
				futbolistes[j] = futbolistes[j+1];
				futbolistes[j+1] = aux;
			}

	for (int i=0; i < futbolistes.length ; i++) 		// tornem a imprimir després de l'ordenació
		System.out.println("\t"+futbolistes[i]);
		
	}
}


