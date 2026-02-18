/*5. Realitza un exercici en el qual es definisca una interfície Transport amb un mètode consumViatge al qual se li passen els quilòmetres realitzats i retorne l'import del seu cost en euros (2 euros per km).
Defineix una classe Vehicle (potència, consumViatge) que implemente la interfície anterior, i dues classes Cotxe (portes) i Moto (tipus) que hereten de l'anterior. En els constructors de les classes derivadeshas de fer ús de "super" per a cridar al constructor de la classe base passant-li els paràmetres que aquest requerisca.
Fes que Moto i Cotxe sobreescriguen el mètode consumViatge (per a una moto el km costa 1 euro, i per a un cotxe costa 3).
Realitza un programa que prove les classes anteriors. */

interface Transport 
    {
        double consumViatge(double quilometres);
    }

// Classe base Vehicle
class Vehicle implements Transport 
    {
        protected int potencia;
        protected double consum;	// euros cada km

        public Vehicle(int pot) 
            {
                potencia = pot;
                consum = 2;
            }
             public Vehicle(int pot, double c) 
            {
                potencia = pot;
                consum = c;
            }

        public double consumViatge(double quilometres) 
            {
                return quilometres * consum;
            }
    }

// Classe Cotxe que hereta de Vehicle
class Cotxe extends Vehicle 
    {
        private int portes;

        public Cotxe(int potencia, int port) 
            {
                super(potencia, 3);
                portes = port;
            }

        @Override
        public double consumViatge(double quilometres) 
            {
                return quilometres * consum; // Cost per km per a un cotxe
            }
    }

// Classe Moto que hereta de Vehicle
class Moto extends Vehicle 
    {
        private String tipus;

        public Moto(int potencia, String t) 
            {
                super(potencia, 1);
                tipus = t;
            }

        @Override
        public double consumViatge(double quilometres) 
            {
                return quilometres * consum; // Cost per km per a una moto
            }
    }

// Programa principal
public class ex5 
    {
        public static void main(String[] args) 
            {
                Cotxe cotxe = new Cotxe(150, 4);
                Moto moto = new Moto(100, "Esportiva");

                double quilometresCotxe = 100;
                double quilometresMoto = 100;

                double costCotxe = cotxe.consumViatge(quilometresCotxe);
                double costMoto = moto.consumViatge(quilometresMoto);

                System.out.println("Cost del viatge amb cotxe: " + costCotxe + " euros");
                System.out.println("Cost del viatge amb moto: " + costMoto + " euros");
            }
    }
