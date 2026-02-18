//3. Implemente un programa que indique si una paraula o frase és un palíndrome . Una paraula és palíndrome si es llig igual d'esquerra a dreta que de dreta a esquerra. 

import java.util.Scanner;
public class ex3
{
	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("escriu una frase per a saber si és palíndrome");
		String text=scan.nextLine();
		StringBuffer text2=new StringBuffer(text);

		if (text.equals(text2.reverse().toString()))
			System.out.println("SI és palíndrome");
		else
			System.out.println("NO és palíndrome");
	}
}
