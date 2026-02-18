//23. Algorisme que permet calcular el factorial d'un nombre sencer. Solució MODULAR i que no admeta valors inferiors a 1

public class e23c
{
	public static void main(String[] args) {
		int num; long result;
		
		System.out.println("Introduix un enter:");
		num = Integer.parseInt(System.console().readLine());
		// ús de la funció
		result = factorial(num);
		if (result == -1)
			System.out.println("Factorial no vàlid");
		else	
			System.out.println("El factorial és " + result);

		System.exit(0);
	}
	
	public static long factorial(int n)
	{
		long fact=1;
		
		if (n > 0 )
		{
			for (int i=2; i <= n ; i++)
				fact = fact*i;	// fact *= i;
			return fact;
		}
		else
			//System.out.println("Només valors majors que 0");
			return -1;
	}
}

