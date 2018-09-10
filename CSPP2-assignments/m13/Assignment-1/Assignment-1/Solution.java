import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author :
 */
final class Set {
    //your code goes here...
    //Good luck :-)
    private int[] set;
    private int size;
/**
 * Constructs the object.
 */
    public Set() {
        final int fifty = 50;
        set = new int[fifty];
        size = 0;
    }

/**
 * { function_description }.
 *
 * @return     { description_of_the_return_value }
 */
    public int size() {
        return size;
    }
/**
 * { function_description }.
 *
 * @param      item  The item
 *
 * @return     { description_of_the_return_value }
 */

    public boolean contains(final int item) {
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                return true;
            }
        }
        return false;
    }
/**
 * Returns a string representation of the object.
 *
 * @return     String representation of the object.
 */
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        String result = "{";
        int i = 0;
        for (i = 0; i < size; i++) {
            result = result + set[i] + ", ";
        }
        result = result + set[i] + "}";
        return result;
    }
/**
 * { function_description }.
 *
 * @param      item  The item
 */
    public void add(final int item) {
        if(!this.contains(item)) {
             set[size++] = item;
        }
    }
/**
 * { function_description }.
 *
 * @param      items  The items
 */
    public void add(final int[] items) {
        // int [] noDuplicate = new int[50];
        // int j = 0;
        for (int element : items) {
            add(element);
            }
    }
/**
 * { function_description }.
 *
 * @param      anotherSet  Another set
 *
 * @return     { description_of_the_return_value }
 */
    public Set intersection(final Set anotherSet) {
        // for (int i = 0; i < set.length; i++) {
        //  if (set[i] == anotherSet[i]) {
        //      return anotherSet[i];
        //  }
        // }
        Set result = new Set();
        for (int element : set) {
            for (int item : anotherSet.set) {
                if (element == item) {
                    result.add(element);
                }
            }
        }
        return result;

    }
/**
 * { function_description }.
 *
 * @param      items  The items
 *
 * @return     { description_of_the_return_value }
 */
    public Set retainAll(final int[] items) {
        // for (int i = 0; i < set.length; i++) {
        //  if (set[i] == items[i]) {
        //      return items[i];
        //  }
        // }
        Set result = new Set();
        for (int element:set) {
            for (int item : items) {
                if (element == item) {
                    result.add(element);
                }
            }
        }
        return result;

    }
    public int get(final int index) {
        return set[index];
    }
/**
 * { function_description }.
 *
 * @param      anotherSet  Another set
 *
 * @return     { description_of_the_return_value }
 */
    public int[][] cartesianProduct(final Set anotherSet) {
        int row = this.size()*anotherSet.size();
        int col = 2;
        int[][] product = new int[row][col];
        int k = 0;
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < anotherSet.size(); j++) {
                product[k][0] = this.get(i);
                product[k][1] = anotherSet.set[j];
                k = k + 1;
            }
        }
        return product;
    }

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "size":
                System.out.println(s.size());
                break;
                case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(s);
                break;
                case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
                case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                if (t.size() == 0 || s.size() == 0) {
                    System.out.println("null");
                } else {
                    System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                }

                break;
                default:
                break;
            }
        }
    }
}
