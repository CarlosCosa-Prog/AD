/* 2. Programa modular, amb pas de paràmetres a main, que s'execute com a:

	java ex2 enterInicial enterFinal
	
Amb una funció que accepte els 2 valors enters (inicial i final) retorne un array amb tots els valors enters compressos entre els indicats. */

public class ex2
{
	public static void main(String[] args)
	{
		int aux;
		if ( args.length > 1)
		{
			int vi = Integer.parseInt(args[0]);
			int vf = Integer.parseInt(args[1]);
			
			// si el final és menor que l'inicial s'han d'intercanviar
			if ( vf < vi )
			{
				aux = vi;
				vi = vf;
				vf = aux;
			}
			int valors[] = 	crearArray(vi,vf);
			mostrarArray(valors);
		}
		else
			System.out.println("Forma d'ús: java ex7 valorInicial valorFinal");			
	}

	public static int[] crearArray(int vi, int vf)
	{
		// genere l'array
		int nums[] = new int[vf - vi + 1];
		// done valors a cada posició de l'array
		for ( int i=0 ; i < nums.length ; i++)
			nums[i] = vi + i;
		return nums;
	}
	
	public static void mostrarArray(int nums[])
	{
		for ( int i=0 ; i < nums.length ; i++)
			System.out.print(nums[i] + "\t");
		System.out.println("");	
	}
}
