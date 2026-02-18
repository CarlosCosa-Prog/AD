// 11*. Realitza un programa, amb una funció main RECURSIVA, que mostre tots els enters des d'1 fins a 100.

public class ex11
{
	private static int cont ;
/*	static
	{
		cont = 0;
	}*/
	public static void main(String args[])
	{
		//int cont = 0;
		
		if (cont < 100)
		{
			cont++;
			System.out.println(cont);
			main(args);	// crida recursiva
		}		
	}
}
