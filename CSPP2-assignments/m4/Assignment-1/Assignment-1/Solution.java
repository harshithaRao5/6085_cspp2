import java.util.Scanner;
/**
*java program to return the maximum number.
*/
public final class Solution {
    /**
    private constructor.
    */
    private Solution() {

    }
/**
    *Fill this main function to print maximum of given array.
    *@param args String
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }
        int maximum = 0;
        for (int j = 0; j < size; j++) {
            if (array[j] > maximum) {
                maximum = array[j];
            }
        }
        System.out.println(maximum);
    }
}
