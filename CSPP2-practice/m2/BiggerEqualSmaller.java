import java.util.*;
public class BiggerEqualSmaller
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		if (a>b){
			System.out.println(a+" is bigger than "+b);
		}
		else if (a<b){
			System.out.println(a+" is smaller than "+b);
		}
		else{
			System.out.println(a+" is equal to "+b);

		}
	}
}