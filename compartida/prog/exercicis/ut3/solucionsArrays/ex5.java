/*2. Crea un programa de gestió de Discs de música. Per a això, defineix una classe Disc (o reutilitza la creada en la unitat 2), sabent que per a cada disc volem registrar el títol, grup o artista, preu. Afig a la classe tots els constructors i mètodes que consideres útils o necessaris.

 El programa ha de crear un array per a 10 Discs inicialment buit i mostrar el següent menú:

	1. Alta de disc
	2. Mostrar tots els Discs
	3. Modifificar disc existent
	4. Ordenar per preu
	5. Ordenar per títol
	0. Eixir */
import java.util.*;

class Disc 
{
	//ATRIBUTOS
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
	public Disc(String tit,String gr)
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
	
	public void setpreu(double preu)
	{
		this.preu=preu;
	}
	
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
		preu=preu*0.8;	// multiplicar per 0.8 és rebaixar un 20%
	}

	public void mostraDisc()
	{
		System.out.println("\nEl titol del Disc és "+titol+", el nom del grup és "+grup+", i costa "+preu+ " euros.");
	}

	
	public String toString()
	{
		return "\nEl titol del Disc és "+titol+". El grup de musica és "+grup+", i costa "+preu+" euros.";
	}
}

public class ex5 {

	public static void ordpreu(Disc[] x, int p) { // p = número de Discos actuals, no és necessari que l'array esté complet per a ordenar-lo. 
		Disc aux = null;
		// versió no optimitzada
		for (int i=p-1; i>0; i--)
			for (int j=0; j<i; j++) {
				if (x[j+1]==null)
					break;
				if (x[j].getpreu() > x[j+1].getpreu()) {
					aux = x[j];
					x[j] = x[j+1];
					x[j+1] = aux;
				}
			}
	}
	
	public static void ordtitol(Disc[] x, int p) {
		Disc aux = null;
		for (int i=p-1; i>0; i--)	// Versió no optimitzada
			for (int j=0; j<i; j++)
				if (x[j].gettitol().compareTo(x[j+1].gettitol()) > 0) {
					aux = x[j];
					x[j] = x[j+1];
					x[j+1] = aux;
				}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x=0,i=0;	// i és comptador de discos existents a l'array
		final int M = 3;
		Disc g[] = new Disc[M];
		do {
			System.out.println("Discs: "+ i);
			System.out.println("   1. Alta de disc\n   2. Mostrar tots els Discos\n   3. Modifificar disc existent\n   4. Ordenar per preu\n   5. Ordenar per títol\n   0. Eixir");
			x=scan.nextInt();
			System.out.println("");
			
			switch (x) {
				case 1: //Alta de disc
					if (g[M-1]!=null) {	// Si no caben més
						System.out.println("Ja hi han " + M + " Discos, no caben més.");
						break;
					}
					// Quan si caben més
					System.out.println("Introduïr Disc");
					g[i] = new Disc();
					System.out.print("Titol: ");
					scan.nextLine();
					g[i].settitol(scan.nextLine());
					System.out.print("grup o artista: ");
					g[i].setgrup(scan.nextLine());
					System.out.print("preu: ");
					g[i].setpreu(scan.nextInt());
					i++;
					System.out.println("");
					break;
				case 2: //Mostrar tots els Discos
					for (int j=0; j < g.length ; j++) {
						if (g[j] == null)
							break;
						System.out.println("Disc "+(j+1)+": "+g[j]);
					}
					System.out.println("");
					break;
				case 3: //Modifificar disc existent
					int z;
					System.out.print("Disc a modificar (1-"+ M +"): ");
					z=scan.nextInt();
					scan.nextLine();	// per a evitar el problema del buffer de teclat
					z--;
					if (g[z] != null)
					{
						System.out.print("Titol: ");
						g[z].settitol(scan.nextLine());
						System.out.print("grup o artista: ");
						g[z].setgrup(scan.nextLine());
						System.out.print("preu: ");
						g[z].setpreu(scan.nextInt());
						System.out.println("");
					}
					else
						System.out.println("No existeix el disc");
						
						
					break;
				case 4: //Ordenar per preu
					System.out.println("Ordenant ...\n");
					if (g[1]==null) {
						System.out.println("Només hi ha un Disc");
						break;
					}
					ordpreu(g, i);
					break;
				case 5: //Ordenar per títol
					System.out.println("Ordenant ...\n");
					if (g[1]==null) {
						System.out.println("Només hi ha un Disc");
						break;
					}
					ordtitol(g, i);
					break;
				case 0: //Eixir
					System.out.print("Acabant el programa ...");
					System.exit(0);
			}
		} while(true);
	}
}
