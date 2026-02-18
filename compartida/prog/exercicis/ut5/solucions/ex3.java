//3. Programa que afegirà una línia de text a un fitxer. Tots dos es passaran com a paràmetres en l'execució.
import java.io.*;

public class ex3{
	public static void main(String[] args){
	
		if (args.length >= 2)
		{
			File f=new File(args[0]);
			try(	//try-with-resources
				FileWriter fw = new FileWriter(args[0],true);
				)
			{
				//String linea=args[1];
				fw.write(args[1] + "\n");
			}
			catch(IOException e){
				System.err.println(e.getMessage());
			}
		}
		else
			System.out.println("Forma d'ús: java ex3 /ruta/al/fitxer \"línia a afegir\"");
			
			
	}
}
