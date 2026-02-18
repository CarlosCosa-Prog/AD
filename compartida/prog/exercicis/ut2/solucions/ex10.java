// 10*. Fer un programa en Java que imprimisca 100 asteriscos en pantalla utilitzant una funció main recursiva.

public class ex10
{
	private static int cont=0;

	public static void main(String args[])
	{
		//int cont = 0;
		
		if (cont < 100)
		{
			System.out.print('*');
			cont++;
			main(args);	// crida recursiva
		}
		
	}
}
