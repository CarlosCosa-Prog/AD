import java.io.*;
import java.util.Scanner;
//per a cada pelicula tindré titol, director i any
public class ex11file
{
	public static void main(String[] args) 
	{
		Scanner ent = new Scanner(System.in);//creo scaner
		do{
		System.out.println("\n1.Alta\n2.Consultar pelicula\n3.Llistar totes les películas\n4.Esborra película\n0.Salir");
		int n=ent.nextInt();
		switch(n)
		{
			case 1: alta();break;
			case 2: System.out.println("Introduix el codi");
			n=ent.nextInt();
			consultar(n);break;
			case 3: llistar();break;
			case 4:System.out.println("Introduix el codi");
			n=ent.nextInt();
			esborrar(n);break;
			default: System.exit(0);
		}
	}
	while(true);

	}
	public static void alta()
	{
		int ano;
		String titol;
		String director;
		int cod;
		try(FileOutputStream fos = new FileOutputStream("pelicules.dat",true);
			DataOutputStream dos= new DataOutputStream(fos);
			)
		{
			Scanner ent = new Scanner(System.in);//creo scaner
			System.out.println("Escriu el codi de la película: ");
			cod=ent.nextInt();
			ent.nextLine();
			System.out.println("Escriu el nom de la película: ");
			titol= ent.nextLine();
			System.out.println("Escriu el nom del director");
			director=ent.nextLine();
			System.out.println("Escriu l'any de la pelicula");
			ano= ent.nextInt();
			dos.writeInt(cod);dos.writeUTF(titol);dos.writeUTF(director);dos.writeInt(ano);
		}
		catch(IOException e)
		{
			System.err.println(e.getMessage());
		}
	}
		
		public static void consultar(int codi)
		{
			int cod;String titol; String director; int ano;
			try(FileInputStream fis = new FileInputStream("pelicules.dat");
				DataInputStream dis = new DataInputStream(fis);)
			{
				 cod = dis.readInt();
				 titol=dis.readUTF(); director=dis.readUTF();
				 ano=dis.readInt();
				 while( cod != codi)
				 {
				 	cod=dis.readInt();
					 titol=dis.readUTF(); director=dis.readUTF();
					 ano=dis.readInt();
				 }
				 if(cod == codi)
				 	System.out.println("\ntitol: "+titol+"\nDirector "+director+"\ncodi "+cod+"\nany "+ano);

			}
			catch(IOException e)
			{
				System.err.println(e.getMessage());
			}
			
		}
		
		public static void esborrar(int codi)
		{
		int cod;String titol; String director; int any;
		File f1 = new File("pelicules.dat");
		File f2 = new File("pelicules2.dat");
			try(FileInputStream fis = new FileInputStream("pelicules.dat");
				DataInputStream dis = new DataInputStream(fis);
				FileOutputStream fos = new FileOutputStream("pelicules2.dat");
			DataOutputStream dos= new DataOutputStream(fos))
			{
				cod=dis.readInt();
			 	titol=dis.readUTF(); director=dis.readUTF();
			 	any=dis.readInt();
				while(true)			 
				{
				 	if(cod != codi)
				 	{
				 		dos.writeInt(cod);
						 dos.writeUTF(titol);dos.writeUTF(director);
						 dos.writeInt(any);
				 	}
					 cod=dis.readInt();
					 titol=dis.readUTF(); director=dis.readUTF();
					 any=dis.readInt();
				 }
				}
			catch(IOException e)
			{
				System.err.println(e.getMessage());
			}
			f2.renameTo(f1);
		}
		
		public static void llistar()
		{
			int cod;String titol;String director;int any;
			try(FileInputStream fis = new FileInputStream("pelicules.dat");
				DataInputStream dis = new DataInputStream(fis);)
			{
				while(true)
				{
					cod=dis.readInt();titol=dis.readUTF();
					director=dis.readUTF();any=dis.readInt();
			 		System.out.println("Titol: "+titol+"\nDirector "+director+"\ncodi "+cod+"\nany "+any+"\n");
				}
			}
			catch(IOException e)
			{
				System.err.println(e.getMessage());
			}
		}

}
