import java.util.*;

class rectangle implements Comparable<rectangle>
{
	public double ample,alt;
	public rectangle() { ample=alt=1;}
	public rectangle(double an,double al) { ample=an ; alt=al; }
	public rectangle(rectangle r) { ample=r.ample; alt=r.alt;}
	public void setample(double an) { ample=an; }
	public double getample() { return ample; }
	public void setalt(double al) { ample=al; }
	public double getalt() { return alt; }
	public String toString() { return " ample: " + ample +", alt: " + alt; }
    public double area() { return ample * alt; }
    public double perimetre() { return 2*(ample + alt);}
    // mètode requerit per COMPARABLE
    public int compareTo(rectangle r)
    {
    	if (r != null)
    		// El multiplicar per 1000 és per a evitar el problema de que diferències inferiors a la unitat entre àrees molt semblants dónen respostes incorrectes
	    return (int) (1000*(area() - r.area()));
	else throw new NullPointerException();
    }
}

public class ex1
{
	public static void main(String[] args) {
		double amp,alt;
		Scanner ent = new Scanner(System.in);
		System.out.println("Introduix ample:");
		amp = ent.nextDouble();
		System.out.println("Introduix alt:");
		alt = ent.nextDouble();
		rectangle r1 = new rectangle(amp,alt);
		System.out.println("Introduix ample:");
		amp = ent.nextDouble();
		System.out.println("Introduix alt:");
		alt = ent.nextDouble();
		rectangle r2 = new rectangle(amp,alt);

		if (r1.compareTo(r2) < 0)
			System.out.println("El primer rectangle és menor");
		else
			System.out.println("El segón rectangle és menor");
	}
}
