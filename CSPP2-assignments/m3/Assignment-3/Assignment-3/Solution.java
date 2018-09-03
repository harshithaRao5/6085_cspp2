
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
    *main class.
    *@param args String
    */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int numberOne = s.nextInt();
        int numberTwo = s.nextInt();
        gcd(numberOne, numberTwo);
        System.out.println(gcd(numberOne, numberTwo));
    }
    /**
    *Need to write the gcd function and print the output.
    *@param numberOne int
    *@param numberTwo int
    *@return gcd
    */
    public static int gcd(final int numberOne, final int numberTwo) {
        int gcd = 1;
        for (int i = 1; i <= numberOne && i <= numberTwo; i++) {
            if (numberOne % i == 0 && numberTwo % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}
