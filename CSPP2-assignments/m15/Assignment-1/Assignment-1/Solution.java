import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedInputStream;
/**
 * List of .
 */
class List extends Exception {
	/**
	 * list array.
	 */
	private int[] list;
	/**
	 * size int.
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
	 * resize method.
	 */
	private void resize() {
        list = Arrays.copyOf(list, list.length * 2);
    }
    /**
     * add element to the list.
     * @param      item  The item
     */
    public void add(final int item) {
    	if (size == list.length) {
    		resize();
    	}
    	list[size++] = item;
    }
    /**
     *gives the size of array.
     * @return size
     */
    public int size() {
    	return size;
    }
    /**
     *gives the index of the item.
     * @param      index  The index
     * @return index
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
     * checks whether the item is present in the array.
     *
     * @param      item  The item
     *
     * @return boolean
     */
    public boolean contains(final int item) {
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
     * @return index
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
     * @param      newArray  The items
     */
    public void addAll(final int[] newArray) {
    	 for (int i = 0; i < newArray.length; i++) {
            add(newArray[i]);
        }
    }
    /**
     * Removes the array elements from original.
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
     *checks whether two arrays are equal.
     * @param list1  The list 1
     * @return boolean
     */
    public boolean equals(final List list1) {
        return this.toString().equals(list1.toString());
    }
    /**
     * clear the entire list.
     */
    public void clear() {
        size = 0;
    }
    /**
     * remove particular index value.
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
     *gives the sublist within the range.
     * @param      start  The start
     * @param      end    The end
     *
     * @return sublist
     */
    public List subList(final int start, final int end)throws Exception {

    	List result = new List();
    	if (start < 0 || end < 0 || start > size
        	|| end > size || start > end || size == 0) {
        	throw new Exception("Index Out of Bounds Exception");
    	} else {
        	for (int i = start; i < end; i++) {
        	result.add(list[i]);
        	}
    	}
    	return result;
    }
    /**
     *gives the count of element.
     * @param  item  The item
     * @return count of variable.
     */
    public int count(final int item) {
         // write the logic
        int count1 = 0;
        for (int i = 0; i < size; i++) {
            if (list[i] == item) {
                count1++;
            }
        }
        if (count1 > 0) {
            return count1;
        } else {
            return 0;
        }
    }
}
/**
 * main class function.
 */
public final class Solution {
    	private Solution() {

    	}
    /**
     * main method.
     * @param args String
     */
	public static void main(final String[] args) {
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
				try {
                    if (tokens.length != 2) {
                        break;
                    }
                    String[] arrstring3 = tokens[1].split(",");
                    List object = obj.subList(Integer.parseInt(arrstring3[0]),
                            Integer.parseInt(arrstring3[1]));
                    if (object != null) {
                        System.out.println(object);
                    }
                }
                    catch(Exception e) {
                	System.out.println(e.getMessage());
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
                case "count":
                System.out.println(obj.count(Integer.parseInt(tokens[1])));
                break;
                default:
                break;
            }
        }
    }
}


