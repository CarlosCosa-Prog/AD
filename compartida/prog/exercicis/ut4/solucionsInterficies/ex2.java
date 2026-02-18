import java.util.*;

class Futbolista {	

    private String nom;	
    private int gols;
    
    public Futbolista () {	
	    nom="AAA";
	    gols=1;
    }
    
    public Futbolista (String nombre, int goles) {	// Constructor general.
	    nom=nombre;
	    gols=goles; 
    }
    
    public void setNom (String nombre) {	
    	nom=nombre;
    }
    
    public void setGols (int goles) {
    	gols=goles;
    }
    
    public String getNom() {		
    	return nom;
    }
    
    public int getGols () {
    return gols;
    }
    
    public String toString() { 
    return "El jugador " + nom + " ha marcat " + gols + " gols.";
    }
}

class EquipFutbol implements Iterable<Futbolista>
{
    private Futbolista fs[];

    public EquipFutbol()
    {
        fs = new Futbolista[4];
    }
    public EquipFutbol(int mida)
    {
        fs = new Futbolista[mida];
    }
    
    public void addFutbolista(Futbolista f, int pos)
    {
    	fs[pos] = f;	
    }
    
    public Futbolista[] getFs()
    {
    	return fs;
    }
    
    class iteradoraFutbolista implements Iterator<Futbolista>
	{
		private int i;	// i=0

		    public boolean hasNext()
		    {
		        if (i < fs.length)
		            return true;
		        else
		            return false;
		    }
		    public Futbolista next()
		    {
		        i++;
		        return fs[i-1];
		    }
	}
    
    public Futbolista getFutbolista(int i) { return fs[i]; }
    
	// implementa l'interfície Iterable usant la classe iteradoraFutbolista que implementa Iterator
	public iteradoraFutbolista iterator()
	{
		return new iteradoraFutbolista();
	}
  
}

public class ex2
{
    public static void main(String args[])
    {
        EquipFutbol  petrerCF = new EquipFutbol();
        String nom="a";
        int length = petrerCF.getFs().length;
        
        for (int i=0 ; i < length ; i++)
        {
        	Futbolista f = new Futbolista(nom,i);
        	petrerCF.addFutbolista(f,i);
        	nom += "a";
        }
	// Una vegada implementada la interfície Iterable, ja puc utilitzar "foreach" per als equips de futbol
        for(Futbolista f: petrerCF)
            System.out.println(f);
    }
}
