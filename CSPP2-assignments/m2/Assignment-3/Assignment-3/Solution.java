import java.util.Scanner;
public class Solution {
    /*
    Do not modify this main function.
    */
    public final static void main(final String[] args) {
        /*
        *main method
        */
        Scanner s = new Scanner(System.in);
        long base = s.nextInt();
        long exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /*
    Need to write the power function and print the output.
    */
    public static long power(final long base, final long exponent) {
        /*
        *sub method
        */
        if (exponent == 0) {
            return 1;
        }
        else {
            return base * power(base, exponent - 1);
        }
    }
}
