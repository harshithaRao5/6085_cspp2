import java.util.Scanner;
/** the program is to find whether the given input is valid
*or not.
*/
class InputValidator {
    /**
     * Write the atrributes and methods for InputValidator.
     */
    private static String name;
    /** the class variable with private access specifier.
    */
    // private static String i;
    /**the constructor is to initialize the given input.
    *@param text String
    */
    InputValidator(final String text) {
        this.name = text;
    }
    /**
     * method for checking the length is minimum of 6.
     * @return boolean
     */
    public static boolean validateData() {
        int namelength = name.length();
        final int six = 6;
        return namelength >= six;
    }
}
/**
 * program to check the minimum length of
 * given string is six or not.
 */
public final class Solution {
    /**
     * default constructor.
     */
    private Solution() {

    }
    /**
     * a main class to read input and give output.
     * @param args String.
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());

    }

}
