/*3. Crea un programa de gestió de Discs de música. Per a això, defineix una classe Disc, sabent que per a cada 
disc volem registrar el títol (String), grup o music (String), preu (per defecte, 15 euros però algun disc pot 
estar en oferta, rebaixant-lo un 20%). Afig a la classe els constructors i mètodes que consideres útils o necessaris.*/

class Disc
{
	//ATRIBUTS
	private String titol;
	private String grup;
	private double preu=15;
	
	//CONSTRUCTORS
	public Disc() //Constructor PER DEFECTE
	{
		titol="Revolver";
		grup="The Beatles";
		preu=15;
	}
	// Constructor general
	public Disc(String tit,String gr) //Constructor PER DEFECTE
	{
		titol=tit;
		grup=gr;
		preu=15;
	}
	//SETTERS I GETTERS
	public void settitol(String titol)
	{
		this.titol=titol;
	}
	
	public void setgrup(String grup)
	{
		this.grup=grup;
	}
	
/*	public void setpreu(double preu)
	{
		this.preu=preu;
	} */
	
	public String gettitol()
	{
		return titol;
	}
	
	public String getgrup()
	{
		return grup;
	}
	
	public double getpreu()
	{
		return preu;
	}
	
	//METODES
	public void oferta()
	{
		preu=preu*0.8;	// multiplicar per 0,8 és rebaixar el preu un 20%
	}

	public void mostraDisc()
	{
		System.out.println("\nEl titol del Disc és "+titol+", el nom del grup és "+grup+", i costa "+preu+ " euros.");
	}

	
	public String toString()
	{
		return "\nEl titol del Disc és "+titol+". el grup de música és "+grup+", i costa "+preu+" euros.";
	}
}
		
		
	

/*El programa ha de crear 3 discs, amb valors de títols i grups introduïts des de teclat per l'usuari. 
A més el programa posarà en oferta un únic disc, triat a l'atzar amb Math.random(). 
Finalment, mostrarà tots els discs amb els seus preus.*/

import java.util.Scanner;

public class ex3
{
	public static void main(String args[])
	{
	
		//CONSTRUCCIO D'OBJECTES
		Scanner teclado = new Scanner(System.in);
		disc d1 = new disc();
		disc d2 = new disc("Thriller","Michael Jackson");
		disc d3 = new disc("The dark side of the moon","Pink Floyd");
		
		// CANVI DE VALORS
		System.out.print("\nIntroduix títol del primer disc: ");
		d1.settítol(teclado.nextLine());
		System.out.print("Introduix un nom per al grup de musica del primer disc: ");
		d1.setgrup(teclado.nextLine());
		
		System.out.print("\nIntroduix un títol per al segon disc: ");
		d2.settítol(teclado.nextLine());
		System.out.print("Introduix un nom per al grup de musica del segon disc: ");
		d2.setgrup(teclado.nextLine());
		
		System.out.print("\nIntroduix un títol per al tercer disc: ");
		d3.settítol(teclado.nextLine());
		System.out.print("Introduix un nom per al grup de musica del tercer disc: ");
		d3.setgrup(teclado.nextLine());
	
		//GENERACIO A L'ATZAR
		int numAzar=(int) (Math.random()*3);
		switch(numAzar)
		{
			case 0: d1.oferta();break;
			case 1: d2.oferta();break;
			case 2: d3.oferta();
		}

		// MOSTRA L'INFORMACIO DELS DISCS
		d1.mostradisc();
		d2.mostradisc();
		System.out.println(d3); //mostre informació del disc 3 usant el mètode toString
	}
}	
