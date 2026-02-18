/*4. Realitzar un programa que demane un número a l'usuari i done la llista dels factorials dels números des del valor introduït fins al 1, indicant quins dels factorials trobats tenen algun dígit igual a 2.
	S'utilitzarà una funció per al càlcul del factorial de cada número i una altra per a saber si el factorial calculat té o no algun dígit igual a 2.
	Exemple per al 5:

	5: factorial = 120	SI té 2
	4: factorial = 24	SI té 2
	3: factorial = 6	 NO té 2
	2: factorial = 2	SI té 2
	1: factorial = 1	NO té 2*/
import java.util.Scanner;
	
public class ex4
{
	public static void main(String args[])
	{
		Scanner teclado = new Scanner(System.in);
		int num;
		System.out.println("Escriu un número");
		num = teclado.nextInt();
		imprimir(num);
	}
	public static long factorial(int n)
	{
		int f = 1;
		for(int i=2; i<=n; i++)
		{
			f = f*i;
		}
		return f;
	}
	public static boolean teDos(long f)
	{
		while(f > 1)
		{
			//System.out.println("fac "+f);
			if (f%10 == 2)
				return true;
			f /= 10;	// f = f/10
		}
		return false;
	}
	public static void imprimir(int num)
	{
		boolean cierto;
		int fac=1
		for (int i=num ; i > 0; i-- )
		{
			long result = factorial(i);
			System.out.print(i+": factorial = "+ result);
			if (teDos(result))
				System.out.println(" SI té 2");
			else 
				System.out.println(" NO té 2");
		}
	}
}
