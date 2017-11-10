package andre;

public class Program {
	public static void main(String[] args) {
		String line = null;
		if (args.length>0) {
			line = args[0];
			System.out.println("args:"+line);
		}

		if (line != null) {
			TestStream testStream = new TestStream(line);
			char c = TestStream.firstChar(testStream);
			System.out.println("c=" + c + " "+(int)c);
		} else {
			System.out.println("Missing arguments");
		}
	}
}
