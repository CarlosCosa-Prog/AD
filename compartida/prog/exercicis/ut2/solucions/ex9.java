/* 9*. Realitzar un programa que escriga en pantalla n línies del triangle de PASCAL utilitzant un subprograma recursiu.
	En el triangle de PASCAL els números dels costats valen 1 i els del centre es calculen sumant els dos que té immediatament damunt:

					1
				1		1
			1		2		1
		1		3		3		1
	1		4		6		4		1
..............................................................................

	S'aconsella utilitzar una funció recursiva que calcule el valor de cada terme donada la seua posició (fila i columna). Per exemple, que calcule que l'element de la fila 5 i columna 3 és un 6. */

public class ex9
{
	public static void main(String[] args)
	{
		int num;
		System.out.println("Introdueix el nombre de files del triangle de Pascal a mostrar:");
		num = Integer.parseInt(System.console().readLine());
		System.out.println("El triangle de Pascal és:");
		
		for (int f=1 ; f <= num ; f++)
			liniaPascal(f);				
	}
	
	public static void liniaPascal(int f)
	{
		for (int c=1 ; c <= f ; c++)
			System.out.print(termePascal(f,c) + " ");
		System.out.println();
	}
	
	public static int termePascal(int f,int c)
	{
		if (( c == 1) || (c == f))
			return 1;
		//else
		return termePascal(f-1,c-1) + termePascal(f-1,c);
	}
}
