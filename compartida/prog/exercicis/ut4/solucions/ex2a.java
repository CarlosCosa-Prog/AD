
 class Vehicle
{
	protected int rodes;
	protected double vel;
	protected final double velMax;

	public Vehicle() { rodes=4; vel=40; velMax=120; }
	public Vehicle(int r, double v, double vMax)
	{ 
		rodes=r;
		velMax = vMax;
		if (v <= velMax)
			vel=v;
		else
			vel=velMax;
		// vel = (v <= velMax)? v: velMax;
	}

	public void accelerar(double v) //per a que la velocitat no supere el màxim
	{
		if ((vel+v) >= velMax)
			vel = velMax;
		else
			vel+=v;
	}
	public void detindre() { vel=0; }
	public String toString() { return "Vehicle:\n" + "rodes: " + rodes + " Velocitat: " + vel + " Velocitat Máxima: " + velMax; }
}

class Bicicleta extends Vehicle
{
	protected int marxes;

	public Bicicleta() { /*super();*/ marxes=6; }
	public Bicicleta(int r, double v, double vMax, int m) { super(r,v,vMax); marxes=m; }
	public String toString() { return "Bicicleta:\n" + "rodes: " + rodes + " Velocitat: " + vel + " Velocitat Máxima: " + velMax + " marxes: " + marxes; }	
}

class Motoritzat extends Vehicle
{
	protected double cabVapor;

	public Motoritzat() { cabVapor=120; }
	public Motoritzat(int r, double v, double vMax, double cabVap) { super(r,v,vMax); cabVapor=cabVap; }

	public String toString() { return "Motoritzat:\n" + "rodes: " + rodes + " Velocitat: " + vel + " Velocitat Máxima: " + velMax + " Caballs de vapor: " + cabVapor; }
}

class Motocicleta extends Motoritzat
{
	protected String tipo;

	public Motocicleta() { tipo = "Motocross"; }
	public Motocicleta(int r, double v, double vMax, double cabVap, String t) { super(r,v,vMax,cabVap); tipo=t; }
	public double getPotenciaReal() { return 1000*cabVapor/1.36; }	
	public String toString() { return "Motocicleta:\n" + "rodes: " + rodes + " Velocitat: " + vel + " Velocitat Máxima: " + velMax + " Caballs de vapor: " + cabVapor + " Tipo: " + tipo; }
}
class Automovil extends Motoritzat
{
	protected int portes;

	public Automovil() { portes = 4; }
	public Automovil(int r, double v, double vMax, double cabVap, int p) { super(r,v,vMax,cabVap); portes=p; }
	public int getPortes() { return portes; }
	public String toString() { return "Automóvil:\n" + "rodes: " + rodes + " Velocitat: " + vel + " Velocitat Máxima: " + velMax + " Caballs de vapor: " + cabVapor + " Portes: " + portes; }
}
public class ex2a
{
	public static void main(String[] args)
	{
		Vehicle v1 = new Vehicle();
		Motoritzat m1 = new Motoritzat();
		Bicicleta b1 = new Bicicleta(2,12,26,3);
		Motocicleta mt = new Motocicleta();
		Automovil aut = new Automovil(6,90,240,130,8);

		System.out.println(v1);
		System.out.println(m1);
		System.out.println(b1);
		System.out.println(mt);
		System.out.println(aut);
	
		mt.accelerar(8); 
		aut.accelerar(200); 
		b1.detindre(); 
		
		System.out.println();
		System.out.println(b1);
		System.out.println(mt);
		System.out.println(aut);

		
	}
}
