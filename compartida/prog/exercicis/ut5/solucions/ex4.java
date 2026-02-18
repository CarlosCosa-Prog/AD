//4. Realitza un programa que compte les línies, paraules i caràcters existents en un fitxer de text passat com a paràmetre (semblant al comandament "wc").
import java.io.*;

public class ex4
{
	public static void main(String[] args) 
	{
		// faltaria comprovar el pas de paràmetres a main
		try(BufferedReader br = new BufferedReader(new FileReader(args[0]));)
		{
			String s;
			int contCaracters = 0, cont = 0, contParaules = 0;
			while ((s = br.readLine()) != null)
			{
				contCaracters += s.length();
				cont++;
				String paraules[] = s.split("\\s+");
				contParaules += paraules.length;
			}
			System.out.println("Número de Línies: " + cont + "\nNúmero de Caracters: " + contCaracters + "\nNúmero de paraules: " + contParaules);
		}
		catch(IOException e){
			System.err.println(e.getMessage());
		}
	}
}
