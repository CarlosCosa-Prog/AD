/* 10*. Programa que mostra les 10 taules de multiplicar (per 1,2,3, ..., 10).

	SOLUCIÓ MODULAR */
	
public class e10
{
	public static void main(String[] args) {
	
		final int LIMIT = 10;	// CONSTANT
		for (int n=1 ; n <= LIMIT ; n++)
		{
			System.out.println("\nTaula de multiplicar del " + n + "\n");
			taulaMultiplicar(n);	// crida a la funció
		}
		System.exit(0);
	}
	
	// definició de la funció taulaMultiplicar
	public static void taulaMultiplicar(int num)
	{
		for(int i=0; i <= 10 ; i++)
			System.out.println(num + " * " + i + " = " + num*i);

	}
}
