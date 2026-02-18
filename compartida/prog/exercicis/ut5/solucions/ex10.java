/* 10. Programa que accepte valors numèrics fins a acabar amb un zero i els escriga a fitxer.
 El programa acabarà mostrant el contingut del fitxer i la mitjana dels seus valors. */
 
import java.io.*;

public class ex10
{
	public static void main(String[] args)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double num;
		try
		{
			FileOutputStream fos = new FileOutputStream("numeros2.data");
			DataOutputStream dos = new DataOutputStream(fos);
			System.out.println("Introduix un real (0 per a acabar): ");
			num = Double.parseDouble(br.readLine());
			while (num != 0)
			{
				dos.writeDouble(num);
				System.out.println("Introduix un real (0 per a acabar): ");
				num = Double.parseDouble(br.readLine());
			}

			if (dos != null) 
			{
				dos.close();
				fos.close();
			}

			System.out.println();

			File f = new File("numeros2.data");
			if (f.exists())
			{
				FileInputStream fis = new FileInputStream(f);
				DataInputStream dis = new DataInputStream(fis);
				//double num2;
				double promedio = 0;
				int contador = 0;
				try
				{
					while (true) 
					{
						num = dis.readDouble();
						System.out.println(num);
						promedio += num;
						contador++;
					}
				}
				catch (EOFException eof) //Final del fitxer
				{
				    System.out.println(" --------------------------");
				}
				if (dis != null) 
				{
					dis.close();
					fis.close();
				}
				System.out.println("La mitjana és " + promedio/contador);
				System.out.println("Has introduït " + contador);
			}
		}
		catch(IOException e)
		{
				System.out.println("Excepció");
		}
	}
}
