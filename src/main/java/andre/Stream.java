package andre;

/**
 * Interface for a character string stream
 * 
 * @author Andre
 *
 */
public interface Stream {

	/**
	 * @return The next available character
	 */
	public char getNext();

	/**
	 * @return true if there are more characters available
	 */
	public boolean hasNext();
}
