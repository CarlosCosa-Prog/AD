/* 7. Realitza el mateix exercici anterior amb 2 classes: una primera classe per al programa, i una altra classe instanciable que incloga com a atribut l'array i com a mètodes els corresponents a les operacions necessàries (carregar l'array, mostrar per pantalla, ordenar i les diferents cerques ...). */

import java.util.Scanner;

class arrayAleatoris
{
	private final static int TAM = 100;
	private int numeros[];

	public arrayAleatoris()	// CONSTRUCTOR
	{
		numeros = new int[TAM];
		for (int i = 0 ; i < TAM ; i++ )
 			numeros[i] = (int)(Math.random()*100)+1;
	}
	
	public void carregaArray()
 	{
 		for (int i = 0 ; i < TAM ; i++ )
 			numeros[i] = (int)(Math.random()*100)+1;
 	}

 	public void mostraArray()
 	{
 		for( int i = 0 ; i < TAM ; i++)
 			System.out.print(numeros[i] + " ");
 		System.out.println();
 	}

 	public boolean cercaArray(int num)
 	{
 		for (int i=0 ; i < TAM; i++)
			if (numeros[i] == num)
				return true;
		return false;
 	}

 	public int cercaArrayOrdenat(int num)
 	{
 		int cont=0;

 		for (int i=0; (i < TAM) && (numeros[i] <= num) ; i++)
			if (numeros[i] == num)
				cont++;
		return cont;
 	}

 	public boolean cercaArrayDicotomica(int val)
 	{
 		int esq = 0, dr = TAM - 1, centre = (esq + dr)/2;

 		while ( (numeros[centre] != val) && (esq <= dr))
 		{
			if (numeros[centre] < val)
				esq = centre + 1;
			else
				dr = centre - 1;
		
			centre = (esq + dr) / 2;
		}
		if (numeros[centre] == val)
			return true;
		return false;	 
	}

 	public void ordenaArray()
 	{
 		int aux;
 		boolean ordenat=false;

 		for (int l=TAM-1 ; (l>0) && (!ordenat) ; l--)
 		{
 			ordenat = true;
 			for (int m=0; m<l; m++)
 				if (numeros[m+1] < numeros[m])
 				{
 					aux=numeros[m];
 					numeros[m]=numeros[m+1];
 					numeros[m+1]=aux;
 					ordenat=false;
 				}
 		}
	}		// fi classe instanciàble
}

 public class ex7
 {
 	public static void main(String[] args) 
 	{
 		Scanner sc = new Scanner(System.in);
 		arrayAleatoris aa = new arrayAleatoris();

 		System.out.println("A continuació es crearà un array de 100 posicions amb 100 números generats al atzar:\n");
 		aa.carregaArray();
 		aa.mostraArray();
 		System.out.print("\nIntroduix un número entre 1 i 100 per a cercar-lo en l'array: ");
 		int num = sc.nextInt();
 		if (aa.cercaArray(num))
 			System.out.println("El valor "+num+" es troba en l'array.");
 		else
 			System.out.println("No es troba en l'array.");

 		System.out.println("\nA continuació s'ordenarà l'array de menor a major: ");
 		aa.ordenaArray();
 		aa.mostraArray();

 		System.out.print("Introduix altre valor entre 1 i 100: "); 
 		num=sc.nextInt();
 		if (aa.cercaArrayDicotomica(num))
 			System.out.println("El número "+num+" es troba en l'array");
 		else
 			System.out.println("El número no es troba en l'array");
 		System.out.println("El valor " + num + " apareix " + aa.cercaArrayOrdenat(num) + " vegades en l'array");
 		
 		System.exit(0);
 	}
 } 	
