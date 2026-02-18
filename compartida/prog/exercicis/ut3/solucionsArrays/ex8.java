//8. Es demana construir una classe anomenada UtilArrays, de l'estil de la classe Math de Java, que incloga mètodes estàtics que retornen, respectivament, el màxim, el mínim, el sumatori, la mitjana aritmètica i el valor més repetit d'un array de nombres reals donat com a paràmetre.

import java.util.Scanner;

// SOLUCIÓ2 CLASSES: LA CLASSE DEMANADA I LA DEL PROGRAMA

public class ex8
{
	private static int TAM;
	public static void main(String[] args) //l'exercici està fet amb Int pero es podría canviar a Double si és necessari
	{
		Scanner lector= new Scanner(System.in);
		System.out.println("Introduix la longitud de l'Array que anem a crear: ");
		TAM= lector.nextInt();
		double numero[]= new double[TAM];
		System.out.println("Indica els numeros que vols introduir en  l'array ("+TAM+"):");
		for(int i=0; i<TAM; i++) //introduim els numeros en  l'array
			numero[i]=lector.nextDouble();

		System.out.println("La suma de tots els números introduits és: "+ UtilArray.suma(numero));

		System.out.println("El major numero d l'array és: "+ UtilArray.major(numero));

		System.out.println("El menor numero d l'array és: "+ UtilArray.menor(numero));

		System.out.println("La mitjana d l'array és: "+ UtilArray.mitjana(numero));

		//System.out.println(repeticio(numero));	// toString() de Object
		double array[] = null;
		array = UtilArray.repeticio(numero);
		// double array[] = repeticio(numero);
		System.out.println("El valor més repetit és " + array[0] + " que apareix " + (int)array[1] + " vegades.");
		System.out.println("Programa finalitzat");
		System.exit(0);
	}
}	// Fi del programa

// Classe demanada que inclou tots mètodes STATIC
class UtilArray
{
	public static double suma(double numero[]) //Calcula la suma de tots els numeros d l'array
	{
		double aux=0;
		for(int i=0; i < numero.length; i++)
			aux += numero[i];
			//suma=aux+sum;
		return aux;
	} 
	public static double major(double numero[]) //Retorna el major d l'array
	{
		//double max = Double.MIN_VALUE;
		double max = numero[0];
		for(int i=1 ; i < numero.length ; i++)
			if(numero[i] > max)
				max = numero[i];
		return max;
		
	}
	public static double menor(double numero[]) //Retorna el menor d l'array
	{
		//double min=Double.MAX_VALUE;
		double min = numero[0];
		for(int i=1 ; i < numero.length ; i++)
			if ( numero[i] < min)
				min = numero[i];
		return min;
	}
	public static double mitjana(double numero[]) //Calcula la mitjana aritmetica de tot  l'array
	{
		double aux=0;
		for(int i=0 ; i < numero.length ; i++)
			aux += numero[i]; //copiamos la suma
		aux = aux / numero.length;
		return aux;
	}
	public static double[] repeticio(double numero[]) //Retorna el número que més es repeteix i quantes vegades ho fa
	{
	double busc;
	int cont, contaux;
	double aux, array[] = new double[2];
	cont=contaux=0; aux = 0;
	
		for(int i=0 ; i < numero.length ; i++) //Canvia el numero
		{
		cont=0; //reinciem el contador amb el canvi de numero
		busc=numero[i];
			for(int j=0 ; j<numero.length ; j++) //Recorre  l'array cercant el numero
				{	
				if(busc == numero[j])
						cont++;
				}
				if(cont > contaux) 
					{
						contaux = cont; //Guardem el numero de vegades que apareix un numero
						aux=numero[i];
					}
				/*if(aux!=numero[i])
						cont=0;*/
		
		}
		array[0] = aux; array[1] = contaux;
		return array;
	}
}
