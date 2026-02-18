// 4. Funció que admeta, com a paràmetres, 2 arrays numèrics i retorne l'array que concatene tots els valors en un únic array.

public class ex4
{

	public static double[] concatenaArrays(double arr1[], double arr2[])
	{
		int i, tam = arr1.length + arr2.length;
		
		// creem l'array que contindrà tots els valors
		double arr[] = new double[tam];
		
		// afegim els valors del primer array
		// observa que el comptador i no ha de ser variable local al for perque ha d'utilitzarse després d'acabat el bucle
		for (i = 0 ; i < arr1.length ; i++)
			arr[i] = arr1[i];
		// ara continuem afegint els valors del segon array, continuant amb el mateix index i
		for (int j = 0 ; j < arr2.length ; j++)
		{
			arr[i] = arr2[j];
			i++;
		}
		return arr;
	}
	public static void main(String[] args) {
		double nums1[] = {1.1,2.2,3.3};
		double nums2[] = {4.4,5.5,6.6,7.7};
		
		double nums[] = concatenaArrays(nums1,nums2);
		// ara mostrem l'array resultant de la concatenació
		for (int i = 0 ; i < nums.length ; i++)
			System.out.println(nums[i]);
			
		System.exit(0);
	}
}
