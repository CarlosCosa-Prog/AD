// 13. Funció comptaDigits que accepte un enter i retorne el seu número de digits.

public class ex13
{
	public static void main (String args[])
	{
		int n1;
		
		System.out.println("Introduix un enter positiu");
		n1 = Integer.parseInt(System.console().readLine());
		
/*		if (n1 == 0)
			System.out.println("Conté 1 dígit.");
		else */
		System.out.println("Contiene: " + comptaDigits(n1) + " dígits.");
	}
	
	public static int comptaDigits(int n1)
	{
		int digits = 0;
		
		if (n1 == 0)
			return 1;
		else	// qualsevol valor diferent de 0
		{	
			if (n1 < 0)
				n1 *= -1;
			
			while (n1 > 0)
			{
				digits++;
				n1 = n1 / 10;
			}
			return digits;
		}
	}
}
