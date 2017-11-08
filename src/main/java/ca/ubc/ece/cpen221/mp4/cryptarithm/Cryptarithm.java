package ca.ubc.ece.cpen221.mp4.cryptarithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Cryptarithm - a datatype that represents a cryptarithm
 *
 */
public class Cryptarithm {
	
	private String[] cryptarithmArray;

	/**
	 * Cryptarithm constructor
	 * 
	 * @param cryptarithm
	 *            where each element is a String that represents part of the
	 *            cryptarithm
	 */
	public Cryptarithm(String[] cryptarithm) {
		// TODO implement this constructor
		this.cryptarithmArray = cryptarithm;
		
	}

	/**
	 * Find solutions to the cryptarithm
	 * 
	 * @return a list of all possible solutions to the given cryptarithm. A
	 *         solution is a map that provides the value for each alphabet in
	 *         the cryptarithm.
	 */
	public List<Map<Character, Integer>> solve() throws NoSolutionException {
		// TODO implement this method
		List<Map<Character, Integer>> possibleSolutions = new ArrayList<Map<Character,Integer>>();
		Map<Character, Integer> solutionMap = new HashMap<Character, Integer>();
		
		
		
		return possibleSolutions; // change this
	}

	// You will need more methods
}
