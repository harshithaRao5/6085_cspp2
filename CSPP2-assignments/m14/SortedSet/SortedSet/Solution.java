import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for set.
 * @author :
 */
class SortedSet {
    /**
     * set.
     */
    private int[] set;
    /**
     *size.
     */
    private int size;
    /**
     * magic number case.
     */
    private final int x = 10;
    /**
     * Constructs the object.
     * @param items int
     */
    SortedSet(final int[] items) {
        set = new int[x];
        size = 0;
        addAll(items);
    }
    /** this is a constructor for set.
    *class
    */
    SortedSet() {
        set = new int[x];
        size = 0;

    }
    /**
     * gives the size of set.
     * @return     int size.
     */
    public int size() {
        return size;
    }
    /**
     * returns true or false when item present in
     * the set.
     * @param item  The item.
     * @return true or false.
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
     * @return String representation of the object.
     */
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        String result = "{";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            result = result + set[i] + ", ";
        }
        result = result + set[i] + "}";
        return result;
    }
    /**
     * add a set of new array to existing set.
     * @param newArray  The new array.
     */
    public void addAll(final int[] newArray) {
        for (int element : newArray) {
            add(element);
        }
        set = Arrays.copyOf(set, size);
        Arrays.sort(set);
    }
    /**
     * add method to add items into array.
     * @param item  The item.
     */
    public void add(final int item) {

            if (size == set.length) {
                resize();
            }
            if (!contains(item)) {
                set[size++] = item;
        }
    }
    /**
    * resize method.
    */
    private void resize() {
        int resizefactor = 2;
        int[] temp = new int[resizefactor * size];
        for (int i = 0; i < size; i++) {
            temp[i] = set[i];
        }
        set = temp;
    }
    /**
     * get the index.
     * @param index  The index.
     * @return item.
     */
    public int get(final int index) {
        return set[index];
    }
    /**
     *  Returns​ ​a view​ of​ ​the​ portion​ of​ ​this​
     *  set whose​ ​elements​ ​ range​ ​
     *  from​ fromElement,​ inclusive,​
     *  to​ toElement,​ exclusive.​ ​
     *  If fromElement​ is​ ​greater​ ​than​ toElement,​ ​
     *  then​ print a message​ "Invalid​ ​
     *  Arguments​ to​ Subset​ Exception".
     * @param   fromElement  The from element.
     * @param   toElement    To element.
     * @return result
     */
    public int[] subSet(final int fromElement,
        final  int toElement) {
        int[] result = new int[x];
        int s = 0;
        for (int i = 0; i < size; i++) {
            if (set[i] >= fromElement && set[i] < toElement) {
                result[s++] = set[i];
            }
        }
        //result = Arrays.copyOf(result, s);
        return result;
    }
    /**
     * Returns​ ​ a ​ ​ view​ ​ of​ ​ the​
     * portion​ ​ of​ ​ this​ ​ set​
     * whose​ ​ elements​ ​ are strictly​ ​
     * less​ ​ than​ ​ toElement.
     * @param toElement  To element.
     * @return result
     */
    public int[] headSet(final int toElement) {
        int[] result = new int[x];
        int s = 0;
        for (int i = 0; i < size; i++) {
            if (set[i] < toElement) {
                result[s++] = set[i];
            }
        }
        //result = Arrays.copyOf(result, s);
        return result;
    }
    /**
     * Returns​ ​ the​ ​ last​ (highest)​ element​.
     * currently​ ​ in​ ​ this​ ​ set.​
     * If​ ​ set​ ​ is​ Empty,​ ​ then​ ​ print a
     *  message "Set​ ​ Empty​ ​ Exception"
     * @return last value.
     */
    public int last() {
    if (size != 0) {
        return set[size - 1];
    }
    System.out.println("Set Empty Exception");
    return -1;
    }
}
    /**
     * sorted set.
     */
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
     * @param      s String
     * @return array
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
            // based on the list operation
            // invoke the corresponding method
            switch (tokens[0]) {
            case "size":
                System.out.println(s.size());
                break;
            case "contains":
                System.out.println(s.
                    contains(Integer.parseInt(tokens[1])));
                break;
            case "print":
                System.out.println(s);
                break;
            case "addAll":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.addAll(intArray);
                }
                break;
            case "subSet":
                String[] arrstring = tokens[1].split(",");
                if (Integer.parseInt(arrstring[0])
                      > Integer.parseInt(arrstring[1])) {
                    System.out.println("Invalid Arguments to Subset Exception");
                } else {
                    int[] subarray = s.subSet(Integer.parseInt(arrstring[0]),
                            Integer.parseInt(arrstring[1]));
                    Set subset = new Set();
                    subset.addAll(subarray);
                    if (subset != null) {
                        System.out.println(subset);
                    }
                }
                break;
            case "headSet":
                int[] headarray = s.headSet(Integer.parseInt(tokens[1]));
                Set headset = new Set();
                headset.addAll(headarray);
                if (headset != null) {
                    System.out.println(headset);
                }
                break;
            case "last":
                System.out.println(s.last());
                break;
            default:
                break;
            }
        }
    }
}
