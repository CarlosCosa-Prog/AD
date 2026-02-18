// 8. Realitzar un programa, amb un subprograma recursiu, que donat un nombre enter positiu, done la suma de tots els nombres parells positius menors que ell.

public class ex8
{
	public static void main(String[] args) 
	{
		int n1,suma=0;
		n1=Integer.parseInt(System.console().readLine());
		
		System.out.println("la suma es "+sumaParells(n1-1));
		

	}
	public static int sumaParells(int x)
	{
		if (x > 0)
		{
			if ( x %2 != 0)
				x--;
			return x + sumaParells(x-2);
		}
		return 0;
	}
}
