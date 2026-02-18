/* 26*. Algorisme que indique si un nombre introduït per teclat és primer.

	Solució MODULAR */
	
public class ex26
{
    
    public static void main (String args[])
    {
        int num;
        
        System.out.println("Introdueix un valor");
        num = Integer.parseInt(System.console().readLine());
		if (esPrimer(num) )    
        	System.out.println("El número introduït "+num+" si és primer");	
        else
        	System.out.println("El número introduït "+num+" NO és primer");			
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
