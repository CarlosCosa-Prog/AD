/* 3. Funció que faça la mateixa funcionalitat del toCharArray() de String utilitzant els mètodes length() i charAt() de la classe String. */

public class ex3
{
	public static char[] toCharArray(String s)
	{
		int tam = s.length();
		
		char array[] = new char[tam];
			
		for (int i = 0 ; i < tam ; i++)
			array[i] = s.charAt(i);
			
		return array;
	}
	
	public static void main(String[] args)
	{
		String s;
		char text[];
		
		System.out.println("Introduix un text:");
		s = System.console().readLine();
		text = toCharArray(s);
		System.out.println("El text contingut en l'array és " + text);
	}
	

}
