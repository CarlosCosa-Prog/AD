/*5. Realitza un programa tal que:
• defineix la classe Ocell amb un atribut longitudBec, un constructor amb un paràmetre, setter,
getter, mètode pia() (que mostre en pantalla "PIO") i mètode abstracte vola().
• defineix la classe Colibri que herete de l'anterior i incloga un atribut color de tipus String, amb el seu corresponent setter i getter, un constructor amb 2 paràmetres des del qual es cride al constructor de la seua classe base, un constructor de còpia, i redefinisca o sobreescriga (overriding) el mètode pia (un colibrí no fa "PIO", sinó "PIO, PIO", i ho fa cridant dues vegades al mètode pia() de la seua classe base). A més, un colibrí vola a 30 Km/h (ho mostrarà per pantalla en volar), i cova els seus ous (mostra per pantalla que està covant els seus ous).
• crea un objecte Colibri i fes-ho piular, volar i covar.
• crea un segon objecte Colibri, còpia de l'anterior.
¿Què canviaria si els objectes colibrí es crearen amb una referència a Ocell? Explica-ho en el propi codi font del programa.*/

//defineix la classe Ocell
abstract class Ocell
	{ 
		//amb un atribut longitudBec
		protected int longitudBec; 
		//un constructor amb un paràmetre
		public Ocell(int longitudBec)
			{
				this.longitudBec = longitudBec;
			}
		//setter
		public void setLongitudBec(int longitudBec)
			{
				this.longitudBec = longitudBec;
			}
		//getter
		public int getLongitudBec()
		{
			return longitudBec;
		}
		//mètode pia() (que mostre en pantalla "PIO")
		public void pia()
		{
			System.out.print("PIO");
		}
		//i mètode abstracte vola().
		public abstract void volar();
	}

//defineix la classe Colibri que herete de l'anterior
class Colibri extends Ocell
	{ 
		//incloga un atribut color de tipus String
		private String color;
		//amb el seu corresponent setter
		public void setColor(String color)
			{
				this.color = color;
			}
		//i getter
		public String getColor()
			{
				return color;
			}
		//un constructor amb 2 paràmetres des del qual es cride al constructor de la seua classe base
		public Colibri(int longitudBec, String color)
			{
				super(longitudBec);
				this.color = color;
			}
		//un constructor de còpia
		public Colibri(Colibri colcop)
			{
				//this(colcop.longitudBec,colcop.color);
				super(colcop.longitudBec);//recorda Ricardo comentar aquest super.
				color = colcop.color;
			}
		//i redefinisca o sobreescriga (overriding) el mètode pia (un colibrí no fa "PIO", sinó "PIO, PIO"
		@Override 
		public void pia()
			{
				//i ho fa cridant dues vegades al mètode pia() de la seua classe base)
				super.pia();
				System.out.print(", ");
				super.pia();
				System.out.println();
			}
		//A més, un colibrí vola a 30 Km/h
		// private static final int vel=30;
		//(ho mostrarà per pantalla en volar)
		public void volar()
			{
				System.out.println("El colibri vola a 30 km/h.");
			}
		//i cova els seus ous (mostra per pantalla que està covant els seus ous).
		public void cova()
			{
				System.out.println("El colibri està covant els seus ous.");
			}
		public String toString()
		{
			return "Colibrí de color " + color + " i bec de " + longitudBec + "mms";
		}
	}

public class ex3
	{
		public static void main(String[] args)
			{
			/* Si la referència és a la classe base 
			no puc accedir als membres de la classe derivada */
				//crea un objecte Colibri
				//Colibri col = new Colibri(5,"blanc");
				Ocell col = new Colibri(5,"blanc");
				//i fes-ho piular
				col.pia();
				//volar
				col.volar();
				//i covar.
				// Per a accedir a cova he de moldejar la referència
				((Colibri)col).cova();
				//crea un segon objecte Colibri, còpia de l'anterior.
				//Colibri col2 = new Colibri(col);
				// Per a accedir al constructor de còpia he de moldejar la referència
				Ocell col2 = new Colibri((Colibri)col);
				System.out.println(col);
				System.out.println(col2);
				
			}
	}
