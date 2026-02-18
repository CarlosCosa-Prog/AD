/*3. Crea un programa de gestió de discs de música. Per a això, defineix una classe Disc, sabent que per a cada 
disc volem registrar el títol (String), grup o music (String), preu (per defecte, 15 euros però algun disc pot 
estar en oferta, rebaixant-lo un 20%). Afig a la classe els constructors i mètodes que consideres útils o necessaris.

4. Modifica la classe Disc per a canviar l'atribut music (prèviament de tipus String) per un atribut de tipus Music (classe definida per a l'exercici 2). En mostrar els discos, has d'utilitzar el mètode mostraMusic() o toString.

*/

public class Disc
{
	//ATRIBUTS
	private String titol;
	// Ara l'atribut grup no és String, sino d'altra classe: music
	private Music grup;
	private double preu=15;
	
	//CONSTRUCTORS
	public Disc() //Constructor PER DEFECTE
	{
		titol="Sólo quiero caminar";
		grup = new Music();
		preu=15;
	}
	// Constructor general
	public Disc(String tit,Music gr)
	{
		titol=tit;
		grup=gr;
		preu=15;
	}
	//SETTERS i GETTERS
	public void setTitol(String titol)
	{
		this.titol=titol;
	}
	
	public void setGrup(Music grup)
	{
		this.grup=grup;
	}
	
/*	public void setPreu(double preu)
	{
		this.preu=preu;
	} */
	
	public String getTitol()
	{
		return titol;
	}
	
	public Music getGrup()
	{
		return grup;
	}
	
	public double getPreu()
	{
		return preu;
	}
	
	//METODES
	public void oferta()
	{
		double descompte=preu*0.2;
		preu=preu-descompte;
	}

	public void mostraDisc()
	{
		System.out.println("\nEl titol del disc és "+titol+", el nom del grup és "+grup.getAutor() +", i costa "+preu+ " euros.");
	}

	
	public String toString()
	{
		return "\nEl titol del disc és "+titol+". el grup de musica és "+grup.getAutor() +", i costa "+preu+" euros.";
	}
}
		
		
	
