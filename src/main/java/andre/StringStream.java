package andre;

/**
 * Class to implement a Stream from a String
 * 
 * @author Andre
 *
 */
public class StringStream implements Stream {

	String str;
	int pos = 0;

	public StringStream(String str) {
		this.str = str;
	}

	/*
	 * Return the next character from  the String Stream
	 * 
	 * @see Stream#getNext()
	 */
	@Override
	public char getNext() {
		char result = 0;
		if (pos < str.length()) {
			result = str.charAt(pos);
			pos++;
		}
		return result;
	}

	/*
	 * Check if there are more characters available from the String Stream
	 * 
	 * @see Stream#hasNext()
	 */
	@Override
	public boolean hasNext() {
		return (pos < str.length());
	}

}
