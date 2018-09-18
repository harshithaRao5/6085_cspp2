public class Example {
	public static void main(String[] args) {
		try {
			String s = "This is an example";
			s.charAt(19);
		}
		catch(NullPointerException n) {
			System.out.println("NullPointerException");
		}
		// catch(Exception ex) {
		// 	System.out.println(ex.toString());
		// }
		}
	}
