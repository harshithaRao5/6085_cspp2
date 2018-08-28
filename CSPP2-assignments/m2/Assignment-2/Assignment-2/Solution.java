import java.util.Scanner;
// import java.lang.Math;
/*
*java code to print the quadractic values
*/
public class Solution {
	/*
	Do not modify this main function.  
	*/
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		roots(a, b, c);
	}
	/*
	Need to write the rootsOfQuadraticEquation function and print the output.
	*/
	public static void roots(final int a, final int b, final int c)
	{
		/*
		*function to get the results
		*/
		double descriminant = Math.sqrt(b * b - 2 * 2 * a * c);
		double result1 = (-b + descriminant ) / (2 * a);
		double result2 = (-b - descriminant ) / (2 * a);
		System.out.println(result1 + " " + result2);

	}
}
