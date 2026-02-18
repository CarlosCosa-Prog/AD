/* 5. Defineix la classe Dau amb:

	- un atribut "valor" (que variarà entre 1 i 6)
	- constructor sense paràmetre
	- constructor general amb valor indicat com a paràmetre
	- constructor de còpia
	- setter i getter (setValor i getValor)
	- un mètode "tirada" que canvia el valor del dau a l'atzar
	- altre mètode "mostra" que dibuixe el dau en pantalla amb asteriscos
		
Realitza a continuació un programa que instàncie al almenys 2 objectes Dau, cadascun amb un constructor diferent, i compte quantes tirades s'han de fer per a generar 3 "6" consecutius. */

import java.util.Scanner;

class Dau
{
	//Variables
	private int valor;

	//Constructor per defecte
	/*public Dau()
	{
		valor = 5;
	}*/

	//Constructor amb paràmetre
	public Dau(int v)
	{
		if (v < 0) v = -v;
		valor = v % 6 ;
		if (valor == 0) valor=6;
	}
	
	//Constructor aleatori
	public Dau()
	{
		valor = (int) Math.floor(Math.random()*6)+1;
	}
	// Constructor de còpia
	public Dau(Dau d)
	{
		valor = d.valor;
	}
	//Setters i getters
	public void setValor(int v) {
		if (v < 0) v = -v;
		valor = v % 6 ;
		if (valor == 0) valor=6;
	}
	
	public int getValor(){return valor;}

	//Mètodes 
	public int tirada()
	{
		valor = (int) Math.floor(Math.random()*6)+1;
		return valor;
	}

	public void mostra()
	{
		switch (valor)
		{
			case 1: System.out.println(" ______________\n/_____________/|\n|             ||\n|             ||\n|             ||\n|      *      ||\n|             ||\n|             ||\n|_____________|/"); break;

			case 2: System.out.println(" ______________\n/_____________/|\n|             ||\n|  *          ||\n|             ||\n|             ||\n|             ||\n|          *  ||\n|_____________|/"); break;

			case 3: System.out.println(" ______________\n/_____________/|\n|             ||\n|  *          ||\n|             ||\n|      *      ||\n|             ||\n|          *  ||\n|_____________|/"); break;

			case 4: System.out.println(" ______________\n/_____________/|\n|             ||\n|  *       *  ||\n|             ||\n|             ||\n|             ||\n|  *       *  ||\n|_____________|/"); break;

			case 5: System.out.println(" ______________\n/_____________/|\n|             ||\n|  *       *  ||\n|             ||\n|      *      ||\n|             ||\n|  *       *  ||\n|_____________|/"); break;

			case 6: System.out.println(" ______________\n/_____________/|\n|             ||\n|  *       *  ||\n|             ||\n|  *       *  ||\n|             ||\n|  *       *  ||\n|_____________|/"); 

		}
	}
}

class ex5
{
	public static void main(String[] args) 
	{	
		int menu=0, v;
		Scanner sc = new Scanner(System.in);
		Dau d1 = new Dau(1);
		Dau dau=null;

		while (menu<1||menu>3)
		{
			System.out.println("CREA UN Dau\n----------\n1.- Crea el teu Dau amb un valor inicial\n2.- Crea el teu Dau amb un valor aleatori\n3.- Tancar programa\n");

			menu = sc.nextInt();

			switch (menu)
			{
				case 1: System.out.println("Dis-me el valor inicial del Dau:\n");
				v = sc.nextInt();
				
				dau = new Dau(v);
				System.out.println("\nEl dau ha sigut creat\n\n"); break;

				case 2: dau = new Dau();
				System.out.println("\nEl dau ha sigut creat\n\n"); break;

				case 3: System.exit(0);
			}
		}

		while (menu!=4)
		{
			System.out.println("\n\n\n\nMENU DE Dau\n----------\n1.- Mostrar Dau\n2.- Tirar Dau\n3.- Tirar Dau fins a que ixquen tres 6 \n4.- Tancar programa\n");

			menu = sc.nextInt();

			switch (menu)
			{
				case 1: dau.mostra(); break;

				case 2: dau.tirada(); break;

				case 3: System.out.println("Han fet falta " + tres6(dau) + " tirades per a generar 6 6 6"); break;

				case 4: System.exit(0);
			}
		}
	}
	
	public static int tres6(Dau d)
	{
		int num, cont=1;
		boolean continuar=true;

		while (continuar)
		{
			//System.out.println("\n-------------\n\nIntent "+cont);
			num = d.tirada();
			d.mostra();

			if (num==6)
			{
				num=d.tirada();
				//System.out.println("\n");
				d.mostra();
				cont++;
				if (num==6)
				{
					num=d.tirada();
					//System.out.println("\n");
					d.mostra();
					cont++;
					if (num==6)
						continuar = false;
				}	
			}
			cont++;
		}
		return cont;
	}
}
/*
 ____________
/___________/|
|		    ||
|           ||
|		    ||
|     *     ||
|		    ||
|   	    ||
|___________|/

 ____________
/___________/|
|		    ||
|  *        ||
|		    ||
|           ||
|		    ||
|   	 *  ||
|___________|/

 ____________
/___________/|
|		    ||
|  *        ||
|		    ||
|     *     ||
|		    ||
|   	 *  ||
|___________|/

 ____________
/___________/|
|		    ||
|  *     *  ||
|		    ||
|           ||
|		    ||
|  *	 *  ||
|___________|/

 ____________
/___________/|
|		    ||
|  *     *  ||
|		    ||
|     *     ||
|		    ||
|  *	 *  ||
|___________|/

 ____________
/___________/|
|		    ||
|  *     *  ||
|		    ||
|  *     *  ||
|		    ||
|  *	 *  ||
|___________|/

*/
