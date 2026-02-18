/* 27*. Modificar l'anterior algorisme perquè demane una llista d'enters acabada amb un 0 i indique quants primers s'han introduït.
	Solució MODULAR */
	
public class ex27
{
    
    public static void main (String args[])
    {
        int num, primers=0;
        
        System.out.println("Introdueix un valor");
        num = Integer.parseInt(System.console().readLine());
		while ( num != 0 )
		{
			if (esPrimer(num))	// true
				primers++;
			System.out.println("Introdueix un valor");
        	num = Integer.parseInt(System.console().readLine());
		}
		System.out.println("Han sigut " + primers + " números primers");
    }
    
    public static boolean esPrimer(int num)
    {
    	int fi = num/2;

    	 	for(int com = 2 ; com <= fi ; com++)
        		if( num % com == 0) 	// divisió exacta
	        		//System.out.println("El número introduït "+num+" no és primer");
	        		//break;
	        		return false;
	        return true;
    }
}
