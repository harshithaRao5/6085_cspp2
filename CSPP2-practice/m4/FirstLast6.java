import java.util.Scanner;
public class FirstLast6 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i<n ; i++)
			a[i] = sc.nextInt();
		if(a[0]==6 || a[n-1]==6) System.out.println("True");
		else System.out.println("False");		
	}
}