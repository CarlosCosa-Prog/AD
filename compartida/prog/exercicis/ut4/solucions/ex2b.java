
abstract class Vehicle
{
	protected int rodes;
	protected double vel;
	protected double velMax;

	public Vehicle() { rodes=4; vel=40; velMax=120; }
	public Vehicle(int r, double v, double vMax) { rodes=r; vel=v; velMax = vMax; }

	public void acelerar(double v)//para que la velocitat no supere el maximo
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

	public Bicicleta() { marxes=6; }
	public Bicicleta(int r, double v, double vMax, int m) { super(r,v,vMax); marxes=m; }
	public String toString() { return "Bicicleta:\n" + "rodes: " + rodes + " Velocitat: " + vel + " Velocitat Máxima: " + velMax + " marxes: " + marxes; }	
}

abstract class Motoritzat extends Vehicle
{
	protected double cabVapor;

	public Motoritzat() { cabVapor=120; }
	public Motoritzat(int r, double v, double vMax, double cabVap) { super(r,v,vMax); cabVapor=cabVap; }

	public abstract double getPotenciaReal();
	
	public String toString() { return "Motoritzat:\n" + "rodes: " + rodes + " Velocitat: " + vel + " Velocitat Máxima: " + velMax + " Caballs de vapor: " + cabVapor; }
}

class Motocicleta extends Motoritzat
{
	protected String tipo;

	public Motocicleta() { tipo = "Motocross"; }
	public Motocicleta(int r, double v, double vMax, double cabVap, String t) { super(r,v,vMax,cabVap); tipo=t; }
	public double getPotenciaReal() { return 1000*cabVapor/1.36; }	// EN W
	public String toString() { return "Motocicleta:\n" + "rodes: " + rodes + " Velocitat: " + vel + " Velocitat Máxima: " + velMax + " Caballs de vapor: " + cabVapor + " Tipo: " + tipo; }
}
class Automovil extends Motoritzat
{
	protected int portes;

	public Automovil() { portes = 4; }
	public Automovil(int r, double v, double vMax, double cabVap, int p) { super(r,v,vMax,cabVap); portes=p; }
	public double getPotenciaReal() { return cabVapor/1.36; }	// en KW

	public int getPortes() { return portes; }
	public String toString() { return "Automóvil:\n" + "rodes: " + rodes + " Velocitat: " + vel + " Velocitat Máxima: " + velMax + " Caballs de vapor: " + cabVapor + " Portes: " + portes; }
}
public class ex2b
{
	public static void main(String[] args)
	{
		/*Vehicle v1 = new Vehicle();
		Motoritzat m1 = new Motoritzat();*/
		Bicicleta b1 = new Bicicleta(2,12,26,3);
		Motocicleta mt = new Motocicleta();
		Automovil aut = new Automovil(6,90,240,130,8);

		/*System.out.println(v1);
		System.out.println(m1);*/
		System.out.println(b1);
		System.out.println(mt);
		System.out.println(aut);
	
		mt.acelerar(8); 
		aut.acelerar(200); 
		b1.detindre(); 
		
		System.out.println();
		System.out.println(b1);
		System.out.println(mt);
		System.out.println(aut);

		System.out.println();
		System.out.println("La potencia real de la motocicleta es: " + mt.getPotenciaReal() + " vatios");
		System.out.println("La potencia real del automovil es: " + aut.getPotenciaReal() + " Kw");
		
		/*Motoritzat mtz = new Motoritzat(3,20,60,10);
		System.out.println("La potencia del objeto motoritzat es " + mtz.getPotenciaReal());

		mtz = aut;	
		System.out.println("Tiene " + ((Automovil)mtz).getPortes() + "portes");
		System.out.println("La potencia es " + mtz.getPotenciaReal());*/
		
		
		
	}
}
