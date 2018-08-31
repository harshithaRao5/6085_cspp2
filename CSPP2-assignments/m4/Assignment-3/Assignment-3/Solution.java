/**Given an String, Write a java method that returns. 
*the decimal value for the given binary string.
*/
import java.util.Scanner;
public final class Solution {
    /**
    *private constructor.
    */
    private Solution() {

    }
    /**
    *Do not modify this main function.
    *@param args String.
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            int res = binaryToDecimal(s);//Write binaryToDecimal function
            System.out.println(res);
        }
    }
    /**
    *function to convert binary to decimal.
    *@param s String.
    @return res.
    */
    public static int binaryToDecimal(final String s) {
        double res = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                res = res + Math.pow(2, s.length() - 1 - i);
            }
        }
        return (int) res;
    }
}

