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
        int rows1 = sc.nextInt();
        int columns1 = sc.nextInt();
        int[][] matrix1 = new int[rows1][columns1];
        int[][] result = new int[rows1][columns1];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns1; j++) {
                matrix1[i][j] = sc.nextInt();
                //System.out.println(a[i][j]);
            }
        }
        int rows2 = sc.nextInt();
        int columns2 = sc.nextInt();
        int[][] matrix2= new int[rows2][columns2];
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < columns2; j++) {
                matrix2[i][j] = sc.nextInt();
                //System.out.println(b[i][j]);
            }
        }
        if (rows1 == rows2 && columns1 == columns2) {
            for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns1 - 1; j++) {
                // if(a[r][c] == b[r][c]){
                //  System.out.println("hello");
                    result[i][j] = matrix1[i][j] + matrix2[i][j];
                    System.out.print(result[i][j] + " ");
                }
            result[i][columns1 - 1] = matrix1[i][columns1 - 1] + matrix2[i][columns2 - 1];
            System.out.println(result[i][columns1 - 1]);
            }
        } else {
         System.out.println("not possible");
        }
    }
}
