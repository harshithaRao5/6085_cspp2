import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author :
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //not used
    }
    /**
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      a     Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns     Number of columns
     *
     * @return     Matrix of the rounded elements
     */
    static int[][] roundHundred(final int[][] a, final int rows,
     final int columns) {

    // write ypur code here
        final int p = 50, q = 100, r = 150, s = 200, t = 250,
        u = 300, v = 350, w = 400, x = 450, y = 500, z = 550;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (a[i][j] < p) {
                    a[i][j] = 0;
                } else if (a[i][j] <= r && a[i][j] >= p) {
                    a[i][j] = q;
                } else if (a[i][j] <= t && a[i][j] > r) {
                    a[i][j] = s;
                } else if (a[i][j] <= v && a[i][j] > t) {
                    a[i][j] = u;
                } else if (a[i][j] <= x && a[i][j] > v) {
                    a[i][j] = w;
                } else if (a[i][j] <= z && a[i][j] > x) {
                    a[i][j] = y;
                }
            }
        }
        return a;
       }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = roundHundred(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
