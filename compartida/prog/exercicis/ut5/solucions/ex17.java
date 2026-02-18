/*17. Programa que gestione les Poblacios de cada localitat del Vinalopó Mitjà amb un fitxer seqüencial i binari, per exemple:

	Monòver 9376
	Elda 71879
	Petrer 28236
	Novelda 27158

	
	El programa ha de permetre
	1 - inicialitzar fitxer amb les dades inicials  (demanará nom de cada població i quantitat)
	2 - actualitzar població d'una localitat (demanarà població, naixements i defuncions)
	3 - calcular el total de la població comarcal

	*/

import java.io.*;
import java.util.*;


public class ex17{


	private static final String FITXER = "pobles.dat";

	private static Scanner sc;
	private static File f;
	//inicialitzem l'objecte Scanner
	static{ 
			sc = new Scanner(System.in);
			f = null;
		 }


	public static void main(String[] args) {

		int ent;

		do{

			Menu();
			ent = sc.nextInt(); sc.nextLine();

			switch (ent) { 
				case 1: inicialitzarFITXER(); break;
				case 2: mostrarFITXER(); break;	
				case 3: mostrarPoblePerCodi(); break;	
				case 4: afegirPobles(); break;	
				case 5: actualitzarPoblacio(); break;	
				case 6: obtindreEstadistiques(); break;	
				case 7: exportar(); break;
				default: System.out.println("Opció invàlida.");
			}


		}while ( ent != 0 );
		
	} //fi main


	static void Menu(){
		System.out.println("\n--------- Menu ----------");
		System.out.println("    1 - Inicialitzar fitxer amb les dades inicials  (borra FITXER anterior).");
		System.out.println("    2 - Llistar todo.");
		System.out.println("    3 - Mostrar Poble per  codi .");
		System.out.println("    4 - Añadir Pobles.");
		System.out.println("    5 - Actualitzar població d'una localitat (demanarà població, naixements i defuncions).");
		System.out.println("    6 - obtindre estadístiques.");
		System.out.println("    7 - Exportar a FITXER de text (llegible).");
		System.out.println("    0 - Eixir.");
		System.out.print("\n--------->  Trie opció: ");

	}


	static void exportar(){

		try( DataInputStream dis = new DataInputStream( new FileInputStream(FITXER));
			 FileWriter fw = new FileWriter("pobles.txt")){ 

			String linia;

			while (true){

				Poble p = llegirPoble(dis);
				linia = p.toString()+"\n";
				fw.write(linia);
			}

		}catch(EOFException e){ System.out.println(" * FITXER exportat com pobles.txt");}
		catch(IOException e){System.err.println(e.getMessage());}

	}


	static void obtindreEstadistiques(){
		/* Estadístiques:
		Número total de Pobles registrats
	 	Poble amb major població
	 	Poble amb menor població
	 	Mitjana de població de tots els Pobles*/

	 	f = new File(FITXER);

	 	if (!f.exists()){
	 		System.out.println("No existeix FITXER creat. Inicialitze un.");
	 		return;
	 	}

	 	int tPoble, maxPoblacio, minPoblacio, tPoblacio, pPoblacio;
	 	String maxPoble = "", minPoble= "";
	 	tPoble = 0; 
		maxPoblacio = Integer.MIN_VALUE; // Bones pràctiques per a buscar números máxims
		minPoblacio = Integer.MAX_VALUE; // Bones pràctiques per a buscar números mínims
		tPoblacio = 0;

	 	try( DataInputStream dis = new DataInputStream( new FileInputStream(FITXER))){
	 		 		
	 		while (true){

	 			Poble p = llegirPoble(dis);
	 			tPoble++;  //suma los Pobles
	 			tPoblacio += p.getPoblacio();  //suma la Poblacio

	 			if (p.getPoblacio() > maxPoblacio){
	 				maxPoblacio = p.getPoblacio();  //guarda el Poble amb major Poblacio
	 				maxPoble = p.getNom();
	 			}

	 			if (p.getPoblacio() < minPoblacio){
	 				minPoblacio = p.getPoblacio();  //guarda el Poble amb menor Poblacio
	 				minPoble = p.getNom();
	 			}
	 		}

	 	}catch(EOFException e) {System.out.println("* fi del FITXER");}
	 	catch(IOException e){ System.err.println(e.getMessage()) ;}

	 	System.out.println("---------  Estadístiques  ---------");
	 	System.out.println("\n  Número total de Pobles registrats: "+tPoble);
	 	System.out.println("  Total de la població comarcal: "+tPoblacio);
	 	System.out.println("  Poble amb major població: "+maxPoble+" con "+maxPoblacio);
	 	System.out.println("  Poble amb menor població: "+minPoble+" con "+minPoblacio);
	 	System.out.println("  Mitjana de población de tots els Pobles: "+(int)(tPoblacio/tPoble));

	}

	static void actualitzarPoblacio(){

		String nomBuscat = demanaNom();
		Poble PobleEditar = buscarPoble(nomBuscat);
		if ( PobleEditar == null)
			System.out.println("Poble no existeix");

		else{

			Poble PobleLlegit;
			int n, d;
			int Poblacio = PobleEditar.getPoblacio();
			System.out.println("Població actual de "+nomBuscat+": "+Poblacio);
			System.out.print("\nIntroduisca quantitat de naixements: ");
			n = sc.nextInt();
			System.out.print("\nIntroduisca quantitat de defuncions: ");
			d = sc.nextInt();
			PobleEditar.setPoblacio(Poblacio+n-d); //actualiza la Poblacio.


			try( DataInputStream dis = new DataInputStream( new FileInputStream(FITXER)) ){

				
				while (true) {

					PobleLlegit = llegirPoble(dis);

					if( PobleLlegit.getNom().equalsIgnoreCase(nomBuscat))
						grabarPoble(PobleEditar, "poble.new.dat"); //guarda nous valors
					else
						grabarPoble(PobleLlegit, "poble.new.dat"); //guarda tal i com estava
				}

			}catch(EOFException e){System.out.println("Població actualitzada.");}
			catch(IOException e){ System.err.println(e.getMessage()); }

			//eliminar FITXER antic i substituir per l'actual
			File f = new File("poble.new.dat");
			File fOriginal = new File(FITXER);
			//fOriginal.delete();
			f.renameTo(fOriginal); //renomene el nou amb el nom de l'antic
				
		}

	}


	static void mostrarPoblePerCodi(){

		Poble p = buscarPoble(demanaNom());
		if (p==null)
			System.out.println("Poble no existeix.");
		else
			imprimirPoble(p);
	}

	static void mostrarFITXER(){

		try( DataInputStream dis = new DataInputStream( new FileInputStream(FITXER))){

			System.out.println("\n----- Llistat de Pobles -----");
			while (true){
				imprimirPoble(dis.readUTF(), dis.readInt());
			}

		}catch(EOFException e){System.out.println("Fi del FITXER");}
		catch(IOException e){ System.err.println(e.getMessage());}
	}

	static void inicialitzarFITXER(){

		f = new File(FITXER);
		
		if (!f.exists())
			f.delete(); 
		// fi if
		afegirPobles();
	}


	static void afegirPobles(){

		String resp;

		//bucle per a entrar amb els Pobles dessitjats, es guarden en un array
		
		do{
			String nom = demanaNom();
			Poble Poble = buscarPoble(nom);  //retorna null si no encuentra
			
			if ( Poble == null ){
				Poble = new Poble(nom, demanaPoblacio()); 
				sc.nextLine(); //buidar el buffer
				grabarPoble(Poble, FITXER);  //moment de guardar el Poble
			}	
			else
				System.out.println(Poble.getNom()+" ja ha sigut creat anteriorment");
			
			System.out.print("Vols continuar (s/n)? ");
			resp = sc.nextLine();

		}while (resp.compareToIgnoreCase("S") == 0 );

	}


	static Poble buscarPoble(String nomBuscat){

		f = new File(FITXER);
		Poble PobleLlegit = null;
		Poble PobleTrobat = null;
		
		if (f.exists()) 
			
			try( DataInputStream dis = new DataInputStream( new FileInputStream(f))){
				
				while (true){
					
					PobleLlegit = llegirPoble(dis);

					if ( PobleLlegit.getNom().equalsIgnoreCase(nomBuscat) ){
						PobleTrobat = PobleLlegit;
						return PobleTrobat;
					}
				}

			}catch(EOFException e) { return PobleTrobat; } //si arriba al final del FITXER es perque no ha trobat el Poble
			catch(IOException e){ System.err.println(e.getMessage());}
		
		return PobleTrobat; 
	}


	static void grabarPoble(Poble p, String FITXER){

		try( DataOutputStream dos = new DataOutputStream( new FileOutputStream(FITXER, true)) ){

			dos.writeUTF(p.getNom());
			dos.writeInt(p.getPoblacio());

		}catch(IOException e){ System.err.println(e.getMessage());}
	}


	static String demanaNom(){
		System.out.print("\nNom del Poble: ");
		return sc.nextLine();
	}


	static int demanaPoblacio(){
		System.out.print("Població: ");
		return sc.nextInt();
	}

	static void imprimirPoble(String nom, int Poblacio){
		System.out.println(nom +": "+Poblacio);
	}

	static void imprimirPoble(Poble p){
		System.out.println("\n"+p.toString());
	}


	static Poble llegirPoble(DataInputStream dis) throws IOException // el throws es per a que l'excepció siga capturada en el catch del mètode que va cridar a la funció
	{
		Poble p = new Poble(dis.readUTF(), dis.readInt());
		return p;
	}


}// fi classe principal

class Poble{

	//atributos
	private String nom;
	private int poblacio;

	//constructor
	public Poble(String nom, int poblacio){
		this.nom = nom;
		this.poblacio = poblacio; 
	}

	//getters
	public String getNom() { return nom; }
	public int getPoblacio() { return poblacio; }

	//setters
	public void setNom(String nom) { this.nom = nom;} 
	public void setPoblacio(int poblacio) { this.poblacio = poblacio; }

	//metodes
	@Override
	public String toString(){
		return nom +": "+ poblacio;
	}



}
