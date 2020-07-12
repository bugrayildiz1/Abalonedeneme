package finalProject.Exceptions;

public class NotValidMoveException extends Exception{
	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */


	public NotValidMoveException(String msg) {
		System.err.println(msg);
	}
}
