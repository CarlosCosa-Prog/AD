/*3. Codifica la jerarquia de classes Java representada pel diagrama UML adjunt tenint en compte que:
• La classe base és la classe Empleat. Aquesta classe conté:
	• Un atribut protegit nom de tipus String que hereten la resta de classes.
	• Un constructor per defecte.
	• Un constructor amb paràmetres que inicialitza el nom amb el String que rep.
	• Mètode set i get per a l'atribut nom.
	• Un mètode toString() que retorna el String: "Empleat " + nom.

La resta de classes només han de sobreescriure el mètode toString() en cadascuna d'elles i declarar el constructor adeqüat de manera que quan s'executen les següents instruccions:

	Empleat e1 = new Empleat("Rafa");
	Directiu d1 = new Directiu("Mario");
	Operari op1 = new Operari("Alfonso");
	Oficial of1 = new Oficial("Luis");
	Tecnic t1 = new Tecnic("Pablo");
	System.out.println(e1);
	System.out.println(d1);
	System.out.println(op1);
	System.out.println(of1);
	System.out.println(t1);

donen com a resultat:

	Empleat Rafa
	Empleado Mario -> Directiu
	Empleat Alfonso -> Operari
	Empleat Luis -> Operari -> Oficial
	Empleat Pablo -> Operari -> Tècnic*/

class empleat
{
	//Un atribut protegit nom de tipus String que hereten la resta de classes.
	protected String nom;
	//Un constructor per defecte.
	public empleat() { nom = "Alberto Manin"; }
	//Un constructor amb paràmetres que inicialitza el nom amb el String que rep.
	public empleat(String nom) { this.nom = nom; }
	//Mètode set i get per a l'atribut nom.
	public void setNom (String n) { nom = n; }
	public String getNom () { return nom; }
	//Un mètode toString() que retorna el String: "Empleat " + nom.
	public String toString() { return "Empleat " + nom; }
}

//La resta de classes només han de sobreescriure el mètode toString() en cadascuna d'elles i declarar el constructor adeqüat.
class directiu extends empleat
{
	public directiu(){/*super();*/}
	public directiu(String nom)
	{
		super(nom);
	}
	@Override
	public String toString()
	{ 
		return super.toString() + " -> Directiu "; 
	}
}
class operari extends empleat
{
	public operari(){}
	public operari(String nom)
	{
		super(nom);
	}
	public String toString()
	{
		return super.toString() + " -> Operari "; 
	}
}
class oficial extends operari
{
	public oficial(){}
	public oficial(String nom)
	{
		super(nom);
	}
	public String toString()
	{
		return super.toString() + " -> Oficial ";
	}
}
class tecnic extends operari
{
	public tecnic(){}
	public tecnic(String nom)
	{
		super(nom);
	}
	public String toString()
	{
		return super.toString() + " -> Tècnic ";
	}
}

public class ex1
{
	public static void main(String[] args) 
	{
		//declarar el constructor adeqüat de manera que s'executen les següents instruccions:
		empleat e1 = new empleat("Rafa Mora");
		directiu d1 = new directiu("Mario Vaquerizo");
		operari op1 = new operari("Alfonso Kitoko");
		oficial of1 = new oficial("Luis Alfredo");
		tecnic t1 = new tecnic("Pablo Escobar");
		System.out.println(e1);
		System.out.println(d1);
		System.out.println(op1);
		System.out.println(of1);
		System.out.println(t1);
	}
}
