// 7. Realitzar un programa que mostre els nombres primers entre 1 i 1000.
public class ex7
{
	public static void main(String[] args) 
	{
		System.out.println("Els números primers entre 1 i 1000 són:");
		for(int i =1;i<1000;i++)
			if(esPrimer(i))
				System.out.print(i+" ");
		System.out.println();
		//System.exit(0);
	}
	
	public static boolean esPrimer (int n1)
	{
		for(int i=2;i<n1;i++)
			if ((n1%i)==0)
				return false;
		return true;
	}
}
