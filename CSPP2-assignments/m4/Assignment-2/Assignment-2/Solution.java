import java.util.Scanner;
/**
*program to add two matrices.
*/
public final class Solution {
    /**
    *private constructor.
    */
    private Solution() {

    }
    /**
    *Fill the main function to print resultant of addition of matrices.
    @param args String
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] a = new int[r][c];
        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] = sc.nextInt();
                //System.out.println(a[i][j]);
            }
        }
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int[][] b = new int[r1][c1];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                b[i][j] = sc.nextInt();
                //System.out.println(b[i][j]);
            }
        }
        if (r == r1 && c == c1) {
            for (int i = 0; i < r; i++) {
            for (int j = 0; j < c - 1; j++) {
                // if(a[r][c] == b[r][c]){
                //  System.out.println("hello");
                    result[i][j] = a[i][j] + b[i][j];
                    System.out.print(result[i][j] + " ");
                }
            result[i][c - 1] = a[i][c - 1] + b[i][c1 - 1];
            System.out.println(result[i][c - 1]);
            }
        } else {
         System.out.println("not possible");
        }
    }
}
