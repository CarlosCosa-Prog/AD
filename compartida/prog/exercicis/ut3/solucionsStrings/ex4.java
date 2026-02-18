/*4. Implemente un programa que reba una cadena S i una lletra X, i col·loque 
en majúscules cada ocurrència de X en S.
(la funció ha de modificar la variable S).*/

public class ex4{
	public static void main(String args[]){
		if (args.length > 1)
		{
			char x = args[1].toLowerCase().charAt(0);
			
			if ((x >= 'a') && (x <= 'z'))
				//System.out.println("Introdueix un text:");
				System.out.println(args[0].replace(x,(char)(x-32)));
		}
		else
				System.out.println("Forma d'ús: java ex4 text caracter");
	}
}

