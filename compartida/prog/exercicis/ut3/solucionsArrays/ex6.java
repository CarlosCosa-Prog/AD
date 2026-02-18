/*3. Realitza un programa en Java que faça el següent (solució preferentment modular, tot en una mateixa classe que incloga main i la resta de funcions):

 - genere 100 nombres enters aleatoris, entre 1 i 100, i els carregue en un array de 100 enters
 - mostre el'array per pantalla
 - demane a l'usuari un valor (entre 1 i 100 també) i indique si, o no, es troba en l'array (cerca lineal en vector desordenat)
 - ordene l'array amb el mètode de la bambolla
 - torne a mostrar l'array
 - demane un altre valor, entre 1 i 100, a l'usuari
 - realitze una altra cerca (ara dicotòmica) indicant, igualment, si es troba, o no, en l'array
 - amb el mateix valor de cerca, finalment realitzarà una cerca lineal indicant quantes vegades ha aparegut el valor en l'array*/

import java.util.Scanner;

 public class ex6
 {
 	private final static int TAM = 100;

 	public static void main(String[] args) 
 	{
 		Scanner sc = new Scanner(System.in);
 		int nums[] = new int[TAM];

 		System.out.println("A continuació es crearà un array de 100 posicions amb 100 números generats al atzar:"); System.out.println();
 		carregaArray(nums);
 		mostraArray(nums);
 		System.out.print("\nIntroduix un número entre 1 i 100 per a cercar-lo en l'array: "); int num = sc.nextInt();
 		if (cercaArray(nums, num))
 			System.out.println("El valor "+num+" es troba en l'array.");
 		else
 			System.out.println("No es troba en l'array.");

 		System.out.println("\nA continuació s'ordenarà l'array de menor a major: ");
 		ordenaArray(nums);
 		mostraArray(nums);

 		System.out.print("Introduix altre valor entre 1 i 100: "); 
 		num=sc.nextInt();
 		if (cercaArrayDicotomica(nums, num))
 			System.out.println("El número "+num+" es troba en l'array");
 		else
 			System.out.println("El número no es troba en l'array");
 		System.out.println("El valor " + num + " apareix " + cercaArrayOrdenat(nums, num) + " vegades en l'array");
 		
 		System.exit(0);

 	}

 	public static void carregaArray(int nums[])
 	{
 		for (int i = 0 ; i < TAM ; i++ )
 			nums[i] = (int)(Math.random()*100)+1;
 	}

 	public static void mostraArray(int nums[])
 	{
 		for(int j = 0 ; j < TAM ; j++)
 			System.out.print(nums[j] + " ");
 		System.out.println();
 	}

 	public static boolean cercaArray(int nums[], int num)
 	{
 		for (int k=0; k<TAM; k++)
			if (nums[k] == num)
				return true;
		return false;
 	}

 	public static int cercaArrayOrdenat(int nums[], int num)
 	{
 		int cont=0;

 		for (int k=0; (k < TAM) && (nums[k] <= num) ; k++)
 		{
			if (nums[k] == num)
				cont++;
		}

		 return cont;
 	}

 	public static boolean cercaArrayDicotomica(int nums[], int val)
 	{
 		int esq = 0, der = TAM - 1, centre = (esq + der)/2;

 		while ( (nums[centre]!= val) && (esq <= der))
 		{
			if (nums[centre] < val)
				esq = centre + 1;
			else
				der = centre - 1;
		
			centre = (esq + der) / 2;
		}

		if (nums[centre] == val)
			return true;
		
		return false;
			 
	}

 	public static void ordenaArray(int nums[])
 	{
 		int aux;
 		boolean ordenat=false;

 		for (int l=TAM-1 ; (l>0) && (!ordenat) ; l--)
 		{
 			ordenat = true;
 			for (int m=0; m<l; m++)
 				if (nums[m+1] < nums[m])
 				{
 					aux=nums[m];
 					nums[m]=nums[m+1];
 					nums[m+1]=aux;
 					ordenat=false;
 				}
 		}

 	}


 } 	
