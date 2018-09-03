import java.util.*;
class InputValidator {
	/**
	 * Write the atrributes and methods for InputValidator.
	 */
	static String name;
	public InputValidator(String name) {
		this.name = name;
	}
	public static boolean validateData() {
		int len = name.length();
		if (len >= 6) {
			return true;
		} else {
			return false;
		}
	}

}
public class Solution {
	/**
	 * { item_description }
	 */
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		InputValidator i = new InputValidator(input);
		System.out.println(i.validateData());

	}

}
