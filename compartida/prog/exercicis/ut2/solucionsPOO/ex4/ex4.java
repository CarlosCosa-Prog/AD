/*El programa ha de crear 3 discs, amb valors de títols i grups introduïts des de teclat per l'usuari. 
A més el programa posarà en oferta un únic disc, triat a l'atzar amb Math.random(). 
Finalment, mostrarà tots els discs amb els seus preus.*/

import java.util.Scanner;

public class ex4
{
	public static void main(String args[])
	{
	
		//CONSTRUCCIO D'OBJECTES
		Scanner ent = new Scanner (System.in);
		Disc d1 = new Disc();
		Disc d2 = new Disc("Thriller",new Music("vocals","Michael Jackson"));
		Disc d3 = new Disc("The dark side of the moon",new Music("banda","Pink Floyd"));
		
		//CANVI DE PARAMETRES AMB INTRODUCCIO DE DADES DE L'USUARI
		System.out.print("\nIntroduix titol del primer disc: ");
		d1.setTitol(ent.nextLine());
		System.out.print("Introduix un nom per al grup de musica del primer disc: ");
		d1.getGrup().setAutor(ent.nextLine());
		
		System.out.print("\nIntroduix un titol per al segon disc: ");
		d2.setTitol(ent.nextLine());
		System.out.print("Introduix un nom per al grup de musica del segon disc: ");
		//d2.setGrup(ent.nextLine());
		d2.getGrup().setAutor(ent.nextLine());
		
		System.out.print("\nIntroduix un titol per al tercer disc: ");
		d3.setTitol(ent.nextLine());
		System.out.print("Introduix un nom per al grup de musica del tercer disc: ");
		d3.getGrup().setAutor(ent.nextLine());
	
		//GENERACIO A L'AtZAR
		int aleatori=(int) (Math.random()*3);
		switch(aleatori)
		{
			case 0: d1.oferta();break;
			case 1: d2.oferta();break;
			case 2: d3.oferta();
		}

		//MOSTRA L'INFORMACIO DELS Discs
		d1.mostraDisc();
		d2.mostraDisc();
		System.out.println(d3); // toString
	}
}	
