class cercle implements Comparable<cercle>
{
	public double radi;

	public cercle() { radi = 1;}
	public cercle(double r) { radi = r; }
	public cercle(cercle c) { radi = c.radi;}

	public void setradi(double r) { radi = r; }
	public double getradi() { return radi; }
	public String toString() { return " radi: " + radi; }
    public double area() { return Math.PI * radi * radi; }
    public double perimetre() { return (2 * Math.PI * radi);}
    // mètode requerit per COMPARABLE
    public int compareTo(cercle c)
    {
    	 		//cercle c2 = (cercle) c;
	    		return (int) (radi - c.radi);
    }
    
/*    public int compareTo(cercle c)
    {
    	if (c != null)  // comprove que la referència no estiga a null ...
    	{
	    	if (c instanceof cercle)   // ... i que siga un cercle
	    	{
	    		//cercle c2 = (cercle) c;
	    		return (int) (radi - c.radi);
	    	}
	    	else    // llance la corresponent excepció
	    		throw new ClassCastException("No és un cercle");
	 }   // llance l'altra excepció
	    else throw new NullPointerException();
    }*/
}

public class comparaCercles
{
	public static void main(String[] args) {
		cercle c1 = new cercle();
		cercle c2 = new cercle(c1);
		c1.setradi(2);
/*		Object o = new Object();
		if (c1.compareTo(o) < 0)*/
		if (c1.compareTo(c2) < 0)
			System.out.println("El primer rectangle és menor");
		else
			System.out.println("El segón rectàngle és menor");
	}
}
