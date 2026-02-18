
abstract class Vehicle
{
	protected int rodes;
	protected double vel;
	protected double velMax;

	public Vehicle() { rodes=4; vel=40; velMax=120; }
	public Vehicle(int r, double v, double vMax) { rodes=r; vel=v; velMax = vMax; }

	public void acelerar(double v)// la velocitat no ha de superar el màxim
	{
		if ((vel+v) >= velMax)
			vel = velMax;
		else
			vel+=v;
	}
	public void detener() { vel=0; }
	public String toString() { return "Vehículo:\n" + "rodes: " + rodes + " Velocitat: " + vel + " Velocitat Màxima: " + velMax; }
}

class Bicicleta extends Vehicle
{
	protected int marxes;

	public Bicicleta() { marxes=6; }
	public Bicicleta(int r, double v, double vMax, int m) { super(r,v,vMax); marxes=m; }
	public String toString() { return "Bicicleta:\n" + "rodes: " + rodes + " Velocitat: " + vel + " Velocitat Màxima: " + velMax + " marxes: " + marxes; }	
}

class Motoritzat extends Vehicle
{
	protected double cabVapor;

	public Motoritzat() { cabVapor=120; }
	public Motoritzat(int r, double v, double vMax, double cabVap) { super(r,v,vMax); cabVapor=cabVap; }

	public double getPotenciaReal()
	{
		return cabVapor;
	}
	
	public String toString() { return "Motoritzat:\n" + "rodes: " + rodes + " Velocitat: " + vel + " Velocitat Màxima: " + velMax + " Caballs de vapor: " + cabVapor; }
}

class Motocicleta extends Motoritzat
{
	protected String tipo;

	public Motocicleta() { tipo = "Motocross"; }
	public Motocicleta(int r, double v, double vMax, double cabVap, String t) { super(r,v,vMax,cabVap); tipo=t; }
	public double getPotenciaReal() { return 1000*cabVapor/1.36; }	
	public String toString() { return "Motocicleta:\n" + "rodes: " + rodes + " Velocitat: " + vel + " Velocitat Màxima: " + velMax + " Caballs de vapor: " + cabVapor + " Tipo: " + tipo; }
}
class Automovil extends Motoritzat
{
	protected int portes;

	public Automovil() { portes = 4; }
	public Automovil(int r, double v, double vMax, double cabVap, int p) { super(r,v,vMax,cabVap); portes=p; }
	// Sobreescriptura (override, overwritte)
	@Override
	public double getPotenciaReal() { return cabVapor/1.36; }
	// sobrecàrrega (overload)
	public double getPotenciaReal(char c) // sobrecàrrega, NO sobreescriptura
	{ 
		if (c == 'c')
			return cabVapor;
		else	// c == 'k'
			return cabVapor/1.36;
	 }
	public int getPortes() { return portes; }
	public String toString() { return "Automóvil:\n" + "rodes: " + rodes + " Velocitat: " + vel + " Velocitat Màxima: " + velMax + " Caballs de vapor: " + cabVapor + " Portes: " + portes; }
}
public class ex2c
{
	public static void main(String[] args)
	{
		Bicicleta b1 = new Bicicleta(2,12,26,3);
		Motocicleta mt = new Motocicleta();
		Automovil aut = new Automovil(6,90,240,130,8);
		
		System.out.println(b1);
		System.out.println(mt);
		System.out.println(aut);
	
		mt.acelerar(8); 
		aut.acelerar(200); 
		b1.detener(); 
		
		System.out.println();
		System.out.println(b1);
		System.out.println(mt);
		System.out.println(aut);

		System.out.println();
		System.out.println("La potencia real de la motocicleta és: " + mt.getPotenciaReal() + " vatios");
		System.out.println("La potencia real del automovil és: " + aut.getPotenciaReal() + " Kw");
		
		
		// Crea una referència a Motoritzat i fes que apunte a un objecte Automòbil.
		Motoritzat mtz = aut;	
		System.out.println("Tiene " + ((Automovil)mtz).getPortes() + "portes");
		System.out.println("La potencia de l'objecte Motoritzat és " + ((Automovil)mtz).getPotenciaReal());
		System.out.println("La potencia de l'objecte Motoritzat és " + mtz.getPotenciaReal());

		
		
		
	}
}
