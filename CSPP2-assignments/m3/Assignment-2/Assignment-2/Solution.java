/**
	*importing scanner.
	*/
import java.util.Scanner;
/**
	*Do not modify this main function.
	*/
public final class Solution {
/**
    *default constructor.
    */
    private Solution() {

    }	
/** 
*Fill the main function to print the number of 7's between 1 to n.
*@param args String
*/
    public static void main(final String[] args) {

        Scanner s=new Scanner(System.in);      
        final int n = s.nextInt();
        int count = 0;
        final int a = 7, b = 10;
        for (int i = 1; i <= n; i++) {
        	int temp = i;
        	while(temp != 0) {
        		int j = temp % b;
        		if (j == a) {
        			count++;
        		}
        		temp = temp / b;
        	}
        }
	}
}
