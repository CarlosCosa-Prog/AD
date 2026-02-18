// 2. Realitzar una funció que reba un nombre real (double) i retorne el nombre enter més pròxim.

public class ex2
{
	public static void main(String[] args) {
		double num; //int n;
		
		System.out.println("Introdueix un número:");
		num = Double.parseDouble(System.console().readLine());
		//n = redondeig(num);
		System.out.println("El valor arredonit és " + arredonir(num));
	
		System.exit(0);
	}
	
	public static int arredonir(double n)
	{
		if (( n - (int) n) > 0.5)
			return (int) n + 1;
		return (int) n;
	}
}
