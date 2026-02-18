/*
  Realitza un programa en Java que faça el següent:
• llija un valor numèric des de teclat
• cree un objecte Double per al valor introduït amb el constructor que requereix com a paràmetre un
String
• obtinga el valor double (tipus bàsic) corresponent
• cree un segon objecte Double per al valor introduït amb el constructor que requereix com a
paràmetre el double obtingut anteriorment
• obtinga a partir del Double primer el valor sencer (int) més pròxim (arrodoniment) i el valor truncat
• obtinga el valor hexadecimal, octal i binari corresponent a l'enter truncat.
**/
public class ex9
{

        public static void main (String args[]){
        	// amb pas de paràmetres a main
                if (args.length>0){
                    //cree un Double  per al valor introduït amb el constructor que requereix com a paràmetre un String
                    Double d = Double.valueOf(args[0]); 
                    //obtinga el valor double (tipus bàsic) corresponent
                    double n = d.doubleValue();
                    //cree un segon objecte Double per al valor introduït amb el constructor que requereix com a paràmetre el double obtingut anteriorment
                    Double d2 = Double.valueOf(n);
                    /*
                        obtinga a partir del Double primer el valor sencer (int) més pròxim (arrodoniment) i el valor truncat
                    **/
                    //valor arredonit
                    int red = (int) Math.round(d);
                    System.out.println("Valor arredonit: "+red);
                    //valor truncat
                    int trunc = d.intValue();
                    System.out.println("Valor truncat: "+trunc);
                    /*
                        obtinga el valor hexadecimal, octal i binari corresponent a l'enter truncat.
                    **/
                    Integer i = Integer.valueOf(red);
                    //Hexadecimal
                    System.out.println(i.toHexString(red));
                    //Octal
                    System.out.println(i.toOctalString(red));
                    //Binari
                    System.out.println(i.toBinaryString(red));

                }
                else
                    System.out.println("Forma d'ús: java ex2 valorEnter");
        }
}
