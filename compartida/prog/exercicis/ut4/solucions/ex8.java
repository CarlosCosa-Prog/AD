/* Per a resoldre el següent exercici utilitza la documentació de l'API de Java.
Realitza un programa que s'execute de la forma:
java programa dia mes any Unitat
i, fent ús de les classes LocalDate, LocalTime, LocalDateTime, etc. mostre el temps transcorregut entre la
data indicada en els paràmetres d'execució i l'instant de l'execució en la unitat indicada (Segons, Dies o
Anys). El programa haurà de comprovar que la data indicada no pertanga al futur.
Exemples d'execució:
java programa 26 5 2050 Segons
, generarà l'eixida
Data futura (no vàlida)
java programa 13 8 1975 Anys
, generarà l'eixida
Han transcorregut xx anys */

import java.util.*;

public class ex8{
	public static void main(String[] args) {
		if (args.length < 4)
			System.out.println("Forma d'ús: java programa dia mes any Unidad (segons, Dias, Anos)\"");
		else 
		{
			Integer any = Integer.valueOf(args[2]);
			Integer mes = Integer.valueOf(args[1])-1;
			Integer dia = Integer.valueOf(args[0]);
			String variable = args[3].toLowerCase();
			Calendar calendar = new GregorianCalendar();
			//Date actual = new Date();
			//calendar.setTime(actual);
			Calendar calendariUsuari = new GregorianCalendar(any,mes,dia);
			if (calendar.compareTo(calendariUsuari) > 0)
			{	
				long diferenciaEnTemps = calendar.getTimeInMillis() - calendariUsuari.getTimeInMillis();
				switch (variable)
				{
					case "segons":
						{
							diferenciaEnTemps = diferenciaEnTemps / 1000;
							System.out.println("Han passat "+diferenciaEnTemps+" segons.");
							break;
						}
					case "dias":
						{
							diferenciaEnTemps = diferenciaEnTemps / (1000 * 60 * 60 * 24);
							System.out.println("Han passat "+diferenciaEnTemps+ " dies.");
							break;
						}
					case "anys":
						{
							Calendar c = Calendar.getInstance();
							c.setTimeInMillis(diferenciaEnTemps);
							int anys = c.get(Calendar.YEAR)-1970;
							System.out.println("Han passat "+anys+" anys.");
							break;
						}
				}
			}		
			else
				System.out.println("Data futura (no vàlida)");
		}
	}
}
