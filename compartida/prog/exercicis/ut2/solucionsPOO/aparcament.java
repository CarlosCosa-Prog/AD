class rellotge
{
	private int hora;
	private int minut;
	private int segons;
	// constructor per defecte
	public rellotge()
	{
		hora = (int) (Math.random()*24);
		minut = (int)((Math.random()*60));
		segons = (int)((Math.random()*60));
	}
	// constructor general
	public rellotge(int h, int m, int s)
	{
		/* if (h < 0) hora = -h;else hora = h;
		if (m < 0) minut = -m;else minut = m;
		if (s < 0) segons = -s; else segons = s;*/
		hora = (h > 0)? h : -h;
		// hora = Math.abs(h);
		minut = (m > 0)? m : -m;
		segons = (s > 0)? s : -s;
		while (segons >= 60)
			{
				segons -= 60;
				minut++;
			}
		while (minut >= 60)
			{
				minut -= 60;
				hora++;
			}
		while (hora >= 24)
				hora-=24; 
	}
	// CONSTRUCTOR DE CÒPIA
	public rellotge(rellotge r)
	{
		hora = r.hora;
		minut = r.minut;
		segons = r.segons;
	}
	public void setHora(int h)
	{
		hora = (h > 0)? h : -h;
		while (hora >= 24)
				hora-=24; 	
	}
	
	public void setminut(int m)
	{
		minut = ( m > 0)? m : -m;	
		while (minut >= 60)
			{
				minut -= 60;
				hora++;
			}
		while (hora >= 24)
				hora-=24; 		
	}
	
	public void setsegons(int s)
	{
		segons = (s > 0) ? s : -s;	
		while (segons >= 60)
			{
				segons -= 60;
				minut++;
			}
		while (minut >= 60)
			{
				minut -= 60;
				hora++;
			}
		while (hora >= 24)
				hora-=24; 	
	}	
	
	public int getHora()
	{
		return hora;
	}
	
	public int getminut()
	{
		return minut;
	}
	
	public int getsegons()
	{
		return segons;
	}	

	public void sumarsegons(int sec)
	{
		segons += sec;
		// Vigilar si segons < 0
		
		while (segons >= 60)
			{
				segons -= 60;
				minut++;
			}
		while (minut >= 60)
			{
				minut -= 60;
				hora++;
			}
		while (hora >= 24)
				hora-=24; 		
	}
	public void sumarminuts(int min)
	{
		minut += min;
		// Vigilar si minut < 0
		while (minut >= 60)
			{
				minut -= 60;
				hora++;
			}
		while (hora >= 24)
			{
				hora-=24; 
			}		
	}
	public void sumarHores(int hor)
	{
		hora += hor;
		// Vigilar si hora < 0
		while (hora >= 24)
				hora-=24; 	
	}
	
	// MÈTODE ESPECIAL toString()
	public String toString()
	{
		return hora + ":" + minut + ":" + segons;
	}
	
}

class entrada {
	private String matricula;
	private rellotge hora;
	private static int cont;	// opcional: comptador de cotxes en el parking
	
	public entrada() {
		// generem matrícula aleatoria
		int numM = (int)((Math.random()*10000));
		hora = new rellotge();
		char l1 = (char)(65+(Math.random()*26));
		char l2 = (char)(65+(Math.random()*26));
		char l3 = (char)(65+(Math.random()*26));
		matricula = numM + " " + l1+l2+l3;
		cont++;
	}
	
	public rellotge getHora()
	{
		return hora;
	}
	public String getMatricula()
	{
		return matricula;
	}
	public String toString() {
		return "El cotxe "+num+" amb matrícula "+matricula+" ha arribat a les "+hora.toString();
	}
}

public class aparcament {
	public static void main(String[] args) {
		entrada c1 = new entrada();
		entrada c2 = new entrada();
		
		System.out.println(c1);
		System.out.println(c2);
		
		// canviar els minuts en c1
		c1.getHora().setminut(1);
		System.out.println(c1);
	}
}
