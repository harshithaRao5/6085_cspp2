import java.util.Scanner;
/**
*code to return the powers.
*/
public class Solution {
    /**
    *Do not modify this main function.
    *@param args string
    */
    public final static void main(final String[] args) {
        /**
        *main method
        */
        Scanner s = new Scanner(System.in);
        long base = s.nextInt();
        long exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /**
    *Need to write the power function and print the output.
    *@param base long
    *@param exponent long
    *@return power
    */
    public static long power(final long base, final long exponent) {
        /**
        *sub method
        */
        if (exponent == 0) {
            return 1;
        } else {
            return base * power(base, exponent - 1);
        }
    }
}
