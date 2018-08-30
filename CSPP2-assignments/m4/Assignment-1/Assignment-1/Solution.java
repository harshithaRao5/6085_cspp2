import java.util.Scanner;
import java.util.Arrays;
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
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        System.out.println(a[n - 1]);
    }
}


