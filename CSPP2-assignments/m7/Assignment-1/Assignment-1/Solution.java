import java.util.*;
class InputValidator {
	/**
	 * Write the atrributes and methods for InputValidator.
	 */
	static String name;
	public InputValidator(final String name) {
		this.name = name;
	}
	/**
	 * method for checking the length is minimum of 6.
	 * @return boolean
	 */
	public static boolean validateData() {
		int namelength = name.length();
		final int SIX = 6;
		if (namelength >= SIX) {
			return true;
		} else {
			return false;
		}
	}

}
public final class Solution {
	/**
	 * default constructor.
	 */
	private Solution() {

	}
	/**
	 * a main class to read input and give output.
	 * @param args String.
	 */
	public static void main(final String args[]) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		InputValidator i = new InputValidator(input);
		System.out.println(i.validateData());

	}

}
