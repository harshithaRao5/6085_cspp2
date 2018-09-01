import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author :
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }
    /**
     * Prints the odd composite numbers between 2 and n.
     *
     * @param      n     n value
     */
    static void oddComposites(final int n) {
    // write your code here
        int temp = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    temp = 0;
                    break;
                } else {
                    temp = 1;
                }
            }
            if (temp == 0) {
                if (i % 2 != 0 && i != 1) {
                    System.out.println(i);
                }
            }
       }
    }
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        oddComposites(n);
    }

}

