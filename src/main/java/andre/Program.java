package andre;

/**
 * Sample program to test the method to find characters in a string stream.
 * 
 * @author Andre
 *
 */
public class Program {
	public static final boolean DEBUG_MODE = false;

	public static void main(String[] args) {
		String line = null;
		if (args.length > 0) {
			line = args[0];
			if (DEBUG_MODE) {
				System.out.println("args:" + line);
			}
		}

		if (line != null) {
			TestStream testStream = new TestStream(line);
			char c = TestStream.findFirstVowel(testStream);
			if (DEBUG_MODE) {
				System.out.println("c=" + c + " " + (int) c);
			}
			if (c > 0) {
				System.out.println(c);
			} else {
				System.out.println("X - Not Found");
			}
		} else {
			System.out.println("Missing arguments");
		}
	}
}
