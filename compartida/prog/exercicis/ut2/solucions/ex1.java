//1. Realitzar una funció que reba una variable de tipus caràcter i si és una lletra minúscula la retorne convertida en majúscules.

import java.util.*;

public class ex1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduix una lletra: ");
		char letra=scan.next().charAt(0);
		// char letra = System.console().readLine().charAt(0);
		//letra=mM(letra);
		System.out.println("La lletra és la "+mM(letra));
		System.exit(0);
	}
	public static char mM(char m1) {
		// si és minúscula
		if ((m1 >= 'a') && (m1 <= 'z'))
		//if ((m1 >= 97) && (m1 <= 122))
			return (char) (m1 - 32);
		return m1;
	}
}
