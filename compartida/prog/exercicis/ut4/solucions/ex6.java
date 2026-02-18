/*
 Defineix una classe jugador (amb atribut nom) que definisca un mètode final mostraNom, un mètode
abstracte mostraJugador. Fes una segona classe Futbolista que herete de l'anterior amb l'atribut
gols.
• Realitza un programa que intente instanciar algun objecte de cadascuna de les classes anteriors.
• Intenta redefinir o sobreescriure el mètode mostraNom en la classe Futbolista. És possible? Perquè?
• Crea un segon objecte Futbolista (f2 per exemple, suposant que el primer fóra f1), que siga "final".
Fes que la referència d'aquest segon objecte apunte al primer (f2 = f1). Què succeix? Perquè?
 */

abstract class Jugador
{
    //ATRIBUTOS
    protected String nom;

    //Constructor por defecto
    public Jugador ()
    {
        nom = "Sense nom";
    }

    //Constructor general
    public Jugador (String n)
    {
        nom = n;
    }

    //Mètode final mostrar nom
    public final void mostrarNom()
    {
        System.out.println("Nom del jugador: " + nom);
    }

    //Mètode abstracte mostrar Jugador
    public abstract void mostrarJugador();

}

class Futbolista extends Jugador
{
    //ATRIBUTS
    private int gols;

    //Constructor per defecte
    //Constructor
    public Futbolista()
    {
        super();
        gols = 0;
    }

    //Constructor
    public Futbolista(String n, int g)
    {
        super(n);
        gols = g;
    }

    //Mètode mostrar Jugador
    public void mostrarJugador()
    {
        System.out.println("El jugador " + nom + " ha marcat " + gols + " gols");
    }

    //Intenta redefinir o sobreescriure el mètode mostraNom en la classe Futbolista. És possible? Perquè?
    //No podem sobreescriure el mètode perquè és final
    /*
    @Override
    public void mostrarNom()
    {
        System.out.println("Nom que li va donar sa mare del jugador: " + nom);
    }
    */
}
//Realitza un programa que intente instanciar algun objecte de cadascuna de les classes anteriors.
public class ex6
{
    public static void main(String args[])
    {
        System.out.println("\n");
        System.out.println("Primer Futbolista: ");
        Futbolista f1 = new Futbolista("Bartolo", 33);
        f1.mostrarJugador();
        f1.mostrarNom();

        //Crea un segon objecte Futbolista (f2 per exemple, suposant que el primer fóra f1), que siga "final". Fes que la referència d'aquest segon objecte apunte al primer (f2 = f1). Què succeix? Perquè?
        System.out.println("\n");
        System.out.println("Segon Futbolista: ");
        /*final*/ Futbolista  f2 = new Futbolista("Esternocleidomastoideo Casillas" , 99);
        f2.mostrarJugador();
        f2.mostrarNom();

        System.out.println("\n");
        System.out.println("Modifiquem la referencia del segon per a que apunte a la del primer: ");
        
        //Si intentem canviar les referencies del segon objetcte a la del primer tindrem un error en el compilador ("cannot assign a value to final variable f2")
        f2 = f1;
        f2.mostrarJugador();
        f2.mostrarNom();
    
    }
}
