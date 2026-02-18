//
import java.util.*;
//import java.util.InputMismatchException;

public class tryCatchEx {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x=0;
		System.out.println("Introduix un número");
		try {
			x=scan.nextInt();
			x*=2;
		}
		catch (InputMismatchException w) {
			System.err.println("text no.");
		}
		finally {
			System.exit(0);
		}
	}
}

