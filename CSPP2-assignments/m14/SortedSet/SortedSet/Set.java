import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author :
 */
final class Set {
    private int[] set;
    private int size;
/**
 * Constructs the object.
 */
    public Set() {
        final int ten = 10;
        set = new int[ten];
        size = 0;
    }

/**
 *gives the size of set.
 * @return size
 */
    public int size() {
        return size;
    }
/**
 *
 * @param item  The item
 * @return boolean value.
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
 * @return     String representation of the object.
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

        Set result = new Set();
        for(int i = 0; i < set.length; i++) {
            for(int j = 0; j < anotherSet.size(); j++) {
                if (set[i] == anotherSet.set[j]) {
                    result.add(set[i]);
                }
            }
        }
        return result;


    }
/**
 *when an array is given
 * @param items  The items
 * @return set
 */
    public Set retainAll(final int[] items) {

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
 *method to get combination of elements from to different sets.
 * @param anotherSet  Another set
 * @return resultant set
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
