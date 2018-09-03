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
        String input = sc.nextLine();
        String reverse = reverseString(input);
        System.out.println(reverse);
    }
    /**Write reverseString function.
    *@param input String.
    *@return rev String.
    */
    public static String reverseString(final String input) {
        String rev = " ";
        for (int i = 0; i < input.length(); i++) {
            rev = input.charAt(i) + rev;
        }
        return rev;
    }
}
