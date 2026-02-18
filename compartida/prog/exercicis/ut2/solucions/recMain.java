public class recMain
{
	private static int i=1;
/*	static
	{
		i = 1;
	}*/
		
	public static void main(String[] args)
	{
		System.out.println(i);
		i++;
		if (i < 101) main(args);	
	}
}
