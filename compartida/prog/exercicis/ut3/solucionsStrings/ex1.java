//1. Fer un programa que ingresse una cadena de caràcters i determine el nombre de majúscules i el nombre de minúscules.
import java.util.Scanner;

public class ex1{
	public static void main(String args[]){
		Scanner ent = new Scanner(System.in);
		int jM=0, jm=0;
		String car;
		System.out.println("Introdueix caracters amb majúscules i minúscules");
		// car = System.console().readLine();
		car = ent.nextLine();
		System.out.println(car);
		for (int i=0; i<car.length(); i++){
			char c = car.charAt(i);
			// si es majúscula o minúscula
			if (((c > 64) && (c <91)) || ((c > 96) && (c < 123)))
				if ((c > 64) && (c <91))//Maj
					jM++;
				else //min
					jm++;
		}
		System.out.println("Hi han hagut "+jM+" caracters majúscules i "+jm+"  caracters minúscules");

	}
}
