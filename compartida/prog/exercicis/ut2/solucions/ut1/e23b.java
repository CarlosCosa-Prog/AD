//23. Algorisme que permet calcular el factorial d'un nombre sencer. Solució MODULAR i que obligue a que el valor siga major o igual a 1

public class e23b
{
	public static void main(String[] args) {
		int num;
		
		do
		{
			System.out.println("Introduix un enter :");
			num = Integer.parseInt(System.console().readLine());
		} while ( num < 1);
		// ús de la funció
		System.out.println("El factorial és " + factorial(num));

		System.exit(0);
	}
	
	public static long factorial(int n)
	{
		long fact=1;
		
		for (int i=2; i <= n ; i++)
			fact = fact*i;	// fact *= i;
		return fact;
	}
	
}

