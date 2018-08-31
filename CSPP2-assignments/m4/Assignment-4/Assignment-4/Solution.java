import java.util.Scanner;
/**
*Given an String, Write a java method that returns.
*the decimal value for the given binary string.
*/
public final class Solution {
    /**
    *private constructor.
    */
    private Solution() {

    }
    /**
    *Do not modify the main function.
    *@param args String.
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);
    }
    /**Write reverseString function.
    *@param s String.
    *@return rev String.
    */
    public static String reverseString(final String s) {
        String rev = " ";
        for (int i = 0; i < s.length(); i++) {
            rev = s.charAt(i) + rev;
        }
        return rev;
    }
}
