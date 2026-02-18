/* 2. Crea una classe Music que incloga 2 atributs (nom del músic i instrument, tots dos de tipus String). La classe inclourà també, almenys:

 - un constructor que inicialitze el músic amb un nom i un instrument inicial.
 - constructor de còpia.
 - un mètode mostraMusic (o toString()) que mostre les dades del músic per pantalla.
 - els corresponents mètodes "setters" i "getters" (setNom,setInst,getNom,getInstr) que canvien l'instrument o el nom (mètodes setXxx), o retornen aqueixos mateixos valors (mètodes getXxx).

	Realitza un programa que, utilitzant la classe Music, definisca almenys dos objectes d'aquest tipus, mostre les seues dades, modifique alguna dada de cadascun d'ells i acabe mostrant els seus noms, instruments i el total de músics. 
	
	2b. utilitza la classe Music de l'exercici anterior, afegint-li un tercer atribut: nombre de músics (aquest atribut s'incrementarà en una unitat per a cada músic nou que es cree).	
	
	*/


//import java.util.Scanner;

class music{
    private String instrument;
    private String autor;
    private static int musics;

    //CONSTUCTOR
    //default
    public music(){
        instrument="Guitarra";
        autor="Paco de Lucía";
        musics++;
    }
    //general
    public music(String ins, String aut){
        instrument=ins;
        autor=aut;
        musics++;
    }
    //còpia
    public music(music m){
        instrument = m.instrument;
        autor = m.autor;
        musics++;
    }

    //METODES
    //setters
    public void setInstrument(String ins){
        instrument=ins;
    }
    public void setAutor(String aut){
        autor=aut;
    }
    // NO POSEM SETTER AL COMPTADOR DE MÚSICS: NO S'HA DE CANVIAR 
    //getters
    public String getIntrument(){
        return instrument;    
    }
    public String getAutor(){
        return autor;
    }
    // SI POSEM GETTER
    public static int getMusics(){
        return musics;
    }
    //altres funcions
    public String toString(){
        return "El music "+autor+" toca l'instrument "+instrument;
    }
}

public class ex2b{
    public static void main(String args[]){
        //Scanner tec = new Scanner(System.in);
        music m1 = new music();	// constructor per defecte
        music m2 = new music("Piano", "Lady Gaga");	// constr. general
	  music m3 = new music(m1);	// constr. de còpia
	  
        System.out.println(m1);	// toString()
        System.out.println(m2);
        System.out.println(m3);
        
        m1.setInstrument("Guitarra flamenca");
        m2.setAutor("Duke Ellington");
        m3.setAutor("Manolo Sanlúcar");
        
        System.out.println(m1);	// toString()
        System.out.println(m2);
        System.out.println(m3);
        
        System.out.println("Tenim " + music.getMusics() + " musics");
        
        
    }
}
