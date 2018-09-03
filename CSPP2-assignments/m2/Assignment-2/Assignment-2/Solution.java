import java.util.Scanner;
// import java.lang.Math;
/**
*java code to print the quadractic values.
*/
public final class Solution {
    /**
    *default constructor.
    */
    private Solution() {

    }
    /**
    *Do not modify this main function.
    *@param args string
    */
    public static void main(final String[] args) {
        /**
        *main method
        */
        Scanner scan = new Scanner(System.in);
        int numberOne = scan.nextInt();
        int numberTwo = scan.nextInt();
        int numberThree = scan.nextInt();
        roots(numberOne, numberTwo, numberThree);
    }
    /**
    *Need to write the rootsOfQuadraticEquation.
    *function and print the output.
    *@param numberOne int
    *@param numberTwo int
    *@param numberThree int
    */
    public static void roots(final int numberOne,
     final int numberTwo, final int numberThree) {
        /**
        *function to get the results.
        */
        double descriminant = Math.sqrt(numberTwo * numberTwo
        - 2 * 2 * numberOne * numberThree);
        double result1 = (-numberTwo + descriminant) / (2 * numberOne);
        double result2 = (-numberTwo - descriminant) / (2 * numberOne);
        System.out.println(result1 + " " + result2);
    }
}

