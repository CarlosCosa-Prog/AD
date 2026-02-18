// 3. Realitzar una funció que reba una quantitat d'hores, minuts i segons i la passe a segons.

public class ex3
{
	public static void main(String[] args) {
		int hores,minuts,seg;
		
		System.out.println("Introdueix les hores:");
		hores = Integer.parseInt(System.console().readLine());
		System.out.println("Introdueix els minuts:");
		minuts = Integer.parseInt(System.console().readLine());
		System.out.println("Introdueix els segons:");
		seg = Integer.parseInt(System.console().readLine());
		System.out.println("Són " + segons(hores,minuts,seg) + " segons.");
	
		System.exit(0);
	}
	
	public static int segons(int h,int m,int s)
	{
		return 3600*h + 60*m + s;
	}
}
