import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedInputStream;
/**
 * List of .
 */
class List extends Exception{
	/**
	 * { var_description }
	 */
	private int[] list;
	/**
	 * { var_description }
	 */
	private int size;
	/**
	 * Constructs the object.
	 */
	List() {
		final int ten = 10;
		list = new int[ten];
		size = 0;
	}
	/**
     * Constructs the object.
     *
     * @param capacity int
     */
    public List(final int capacity) {
        size = 0;
        list = new int[capacity];
    }
	/**
	 * { function_description }
	 */
	private void resize() {
        list = Arrays.copyOf(list, list.length * 2);
    }
    /**
     * { function_description }
     *
     * @param      item  The item
     */
    public void add(int item) {
    	if (size == list.length) {
    		resize();
    	}
    	list[size++] = item;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
    	return size;
    }
    /**
     * { function_description }
     *
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    public int get(final int index) {
    	if (size < 0 || index >= size) {
    		return -1;
    	} else {
    		return list[index];
    	}
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
    	if (size == 0) {
    		return "[]";
    	}
    	String result = "[";
    	int i = 0;
    	for (i = 0; i < size - 1; i++) {
    		result = result + list[i] + ",";
    	}
    	result = result + list[i] + "]";
    	return result;
    }
    /**
     * { function_description }
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(int item) {
    	for (int i = 0; i < size; i++) {
    		if (list[i] == item) {
    			return true;
    		}
    	}
    	return false;
    }
    /**
     * Searches for the first match.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int indexOf(int item) {
    	for (int i = 0; i < size; i++) {
    		if (list[i] == item) {
    			return i;
    		}
    	}
    	return -1;
    }
    /**
     * Adds all.
     *
     * @param      items  The items
     *
     * @return     { description_of_the_return_value }
     */
    public void addAll(int[] newArray) {
    	 for (int i = 0; i < newArray.length; i++) {
            add(newArray[i]);
        }
    }
    /**
     * Removes all.
     *
     * @param      newArray  The new array
     */
    public void removeAll(final int[] newArray) {
        for (int each: newArray) {
        for (int i = 0; i < newArray.length; i++) {
            if (contains(newArray[i])) {
                remove(indexOf(newArray[i]));
            	}
        	}
    	}
    }
    /**
     * { function_description }
     *
     * @param      list1  The list 1
     *
     * @return     { description_of_the_return_value }
     */
    public boolean equals(final List list1) {
        return this.toString().equals(list1.toString());
    }
    /**
     * { function_description }
     */
    public void clear() {
        size = 0;
    }
    /**
     * { function_description }
     *
     * @param      index  The index
     */
    public void remove(final int index) {
        try {
        	if (index >= 0 && index <= size) {
            for (int i = index; i <= size - 1; i++) {
                list[i] = list[i + 1];
            }
            size--;
        } else {
            throw new Exception("Invalid Position Exception");
        	}
        }
        catch(Exception e) {
        	System.out.println(e.getMessage());
        }

    }
    /**
     * { function_description }
     *
     * @param      start  The start
     * @param      end    The end
     *
     * @return     { description_of_the_return_value }
     */
    public List subList(final int start, final int end) {

    	List result = new List();
    	if (start < 0 || end < 0 || start > size
        	|| end > size || start > end || size == 0) {
        	System.out.println("Index Out of Bounds Exception");
        	return null;
    	} else {
        	for (int i = start; i < end; i++) {
        	result.add(list[i]);
        	}
    	}
    	return result;
    }
}
    public class Solution {
    	private Solution() {

    	}
    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
	public static void main(String[] args) {
		List obj = new List();
		Scanner scan = new Scanner(new BufferedInputStream(System.in));
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] tokens = line.split(" ");
			switch(tokens[0]) {
				case "add":
				if (tokens.length == 2) {
					String[] t = tokens[1].split(",");
					if (t.length == 1) {
						obj.add(Integer.parseInt(tokens[1]));
					}
				}
				break;
				case "size":
				System.out.println(obj.size());
				break;
				case "print":
				System.out.println(obj);
				break;
				case "remove":
				if (tokens.length == 2) {
					obj.remove(Integer.parseInt(tokens[1]));
				}
				break;
				case "get":
				if (tokens.length == 2) {
					System.out.println(obj.get(Integer.parseInt(tokens[1])));
				}
				break;
				case "indexOf":
				if (tokens.length == 2) {
					System.out.println(obj.indexOf(Integer.parseInt(tokens[1])));
				}
				break;
				case "contains":
				if (tokens.length == 2) {
					System.out.println(obj.contains(Integer.parseInt(tokens[1])));
				}
				break;
				case "addAll":
				if (tokens.length == 2) {
					String[] t1 = tokens[1].split(",");
					int[] temp = new int[t1.length];
                        for (int i = 0; i < temp.length; i++) {
                            temp[i] = Integer.parseInt(t1[i]);
                        }
                        obj.addAll(temp);
				}
				break;
				case "removeAll":
				if (tokens.length == 2) {
					String[] t2 = tokens[1].split(",");
					int[] temp1 = new int[t2.length];
					for (int i = 0; i < temp1.length; i++) {
						temp1[i] = Integer.parseInt(t2[i]);
					}
					obj.removeAll(temp1);
				}
				break;
				case "subList":
                    if (tokens.length != 2) {
                        break;
                    }
                    String[] arrstring3 = tokens[1].split(",");
                    List object = obj.subList(Integer.parseInt(arrstring3[0]),
                            Integer.parseInt(arrstring3[1]));
                    if (object != null) {
                        System.out.println(object);
                    }
                    break;
                case "equals":
                    if (tokens.length == 2) {
                        String[] lt = tokens[1].split(",");
                        List l2 = new List();
                        for (int k = 0; k < lt.length; k++) {
                            l2.add(Integer.parseInt(lt[k]));
                        }
                        System.out.println(obj.equals(l2));
                    }
                break;
                case "clear":
                    obj.clear();
                break;
                default:
                break;
            }
        }
    }
}


