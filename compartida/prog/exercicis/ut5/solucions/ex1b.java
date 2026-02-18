/*
	1. Programa que mostre unes determinades línies d'un fitxer de text. Tant el fitxer com els números de línia (en ordre creixent) seran passats com a paràmetres en l'execució. Exemple:

	java ex1 /ruta/Al/Fitxer 3 7 10
*/
import java.io.*;
import java.util.Vector;

public class ex1b
{
	public static void main(String args[])
	{
		String line = null;
		// Creamos un Vector para almacenar los números de las líneas
        Vector<Integer> v = new Vector<>();
      	if (args.length > 0)
		{
			// Convertimos los números de línea pasados como argumentos en un Vector
			for (int i = 1; i < args.length; i++) 
			{
				//try 
				//{
				//int numLinea = Integer.parseInt(args[i]);
				v.add(Integer.parseInt(args[i]));  // Añadimos al Vector
				//} 
				/*catch (NumberFormatException e) // try-catch para asegurarse que el usuario pasa como parámetros (despues de la ruta del fichero) un numero entero
				{
				System.out.println("Error: El argumento " + args[i] + " no es un número válido.");
					return;
				}*/
		    }
			try(BufferedReader br = new BufferedReader(new FileReader(args[0]));)	// try-with-resources
			{
				// BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
				// lee el archivo linea por linea y uso un contador para imprimir solo las lineas solicitadas
				
				for (int i = 1; (line = br.readLine()) != null ; i++)
					// se compara el numero actual de línea con los numeros almacenados en el Vector y se imprime la línea si coinciden
					if (v.contains(i))
						System.out.println(line);
			}
			catch (IOException e)
			{
				System.err.println(e.getMessage());
			}
		}
		else
		{
			System.out.println("Forma de uso: java ex1 /ruta/Al/Fitxer 3 7 10");
			System.out.println("Los numeros del final son las lineas que quieres imprimir");
		}
			
		
		
	}
}
