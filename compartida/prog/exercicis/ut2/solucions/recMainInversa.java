public class recMainInversa
{
	private static int i=0;
/*	static
	{
		i = 1;
	}*/
		
	public static void main(String[] args)
	{
		i++;
		if (i < 100) main(args);
		System.out.println(i--);	
	}
}
