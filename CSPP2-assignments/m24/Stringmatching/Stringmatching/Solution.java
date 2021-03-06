import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
// import java.lang.StringBuffer;
import java.io.File;
import java.io.FileReader;


/**
 * Class for frequency.
 */
class Frequency {

    /**
     * Constructs the object.
     */
    protected Frequency() {

    }
    /**.
     * { var_description }
     */
    private static final double HUNDRED = 100;
    /**
     * Returns a string representation of the object.
     *
     * @param      filename  The filename
     *
     * @return     String representation of the object.
     */
    public static String toString(final File filename) {
        String s = "";
        try {
            Scanner input = new Scanner(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            while (input.hasNext()) {
                sb.append(input.next());
                sb.append(" ");
            }
            input.close();
            s = sb.toString();
        } catch (Exception e) {
            System.out.println("no file");
        }
        return s;
    }
    /**
     * Removes all.
     *
     * @param      text  The text
     *
     * @return     { description_of_the_return_value }
     */
    public static Map removeAll(final String text) {
        String[] wordList =
        text.replaceAll("[^a-zA-Z. ]", "").toLowerCase().split(" ");

        //System.out.println(Arrays.toString(wordList1));
        //return Arrays.toString(wordList1);
        Map<String, Integer> map = new HashMap<>();
        int freq = 0;
        for (int i = 0; i < wordList.length; i++) {
            if (!map.containsKey(wordList[i])) {
                map.put(wordList[i], 1);
            } else {
                map.put(wordList[i], map.get(wordList[i]) + 1);
            }
        }
        //System.out.println(map);
        return map;


    }
    /**.
     * { function_description }
     *
     * @param      s1    The s 1
     * @param      s2    The s 2
     *
     * @return     { description_of_the_return_value }
     */
    public static double similarString(final String s1, final String s2) {
        int rows = s1.length();
        int columns = s2.length();
        double stringLength = rows + columns;
        int[][] maximum = new int[rows + 1][columns + 1];
        int result = 0;
        double similarity = 0;
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= columns; j++) {
                if (i == 0 || j == 0) {
                    maximum[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    maximum[i][j] = maximum[i - 1][j - 1] + 1;
                    //result = max(result, maximum[i][j]);
                } else {
                    maximum[i][j] = 0;
                }
                if (result < maximum[i][j]) {
                    result = maximum[i][j];
                }
            }
        }
        //System.out.println(result);
        similarity = Math.round(((result * 2)
            / stringLength) * HUNDRED) / HUNDRED;
        //System.out.println(stringLength);
        return (similarity * HUNDRED);
        }
}

/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    protected Solution() {

    }
    /**.
     * { var_description }
     */
    private static final double HUNDRED1 = 100;
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        try {
        Frequency f = new Frequency();
        Scanner sc = new Scanner(System.in);
        // String line = sc.next();
        File input = new File(sc.next());
        File[] listoffiles = input.listFiles();
        // for (File name:listoffiles) {
        //  System.out.println(name);
        // }
        double maximum = 0;
        String result1 = "";
        int length = listoffiles.length;
        double[][] result = new double[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    result[i][j] = HUNDRED1;
                } else {
                result[i][j] =
                Frequency.similarString(Frequency.toString(listoffiles[i]),
                    Frequency.toString(listoffiles[j]));
                if (maximum < result[i][j]) {
                    maximum = result[i][j];
                    result1 = "Maximum similarity is in between "
                    + listoffiles[i].getName() + " and "
                    + listoffiles[j].getName();

                }
            }
            }
        }
        System.out.print("\t");
        for (int i = 0; i < length; i++) {
            System.out.print("\t" + listoffiles[i].getName());
        }
        System.out.println();
        for (int i = 0; i < length; i++) {
            System.out.print(listoffiles[i].getName() + "\t");
            for (int j = 0; j < length; j++) {
                System.out.print(result[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println(result1);


    } catch (Exception e) {
        System.out.println("Empty Directory");
    }

        // String stext1 = sc.nextLine().toLowerCase();
        // String stext2 = sc.nextLine().toLowerCase();
        // Frequency feq = new Frequency();
    }
}
