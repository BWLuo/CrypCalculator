package ca.ubc.ece.cpen221.mp4.cryptarithm;

/**
 * NoSolutionException - Exception class for cryptarithm.
 *
 */
public class NoSolutionException extends Exception {
	
	/**
	 * Constructor for NoSolutionException. Prints the error message given.
	 * 
	 * @param s - the error message to print
	 */
	public NoSolutionException(String s) {
		System.out.println(s);
	}
	
}
