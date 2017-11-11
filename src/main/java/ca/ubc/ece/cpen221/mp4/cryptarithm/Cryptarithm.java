package ca.ubc.ece.cpen221.mp4.cryptarithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		List<Map<Character, Integer>> possibleSolutions = new LinkedList<Map<Character,Integer>>();
		Map<Character, Integer> solutionMap = new HashMap<Character, Integer>();
		
		
		
		return possibleSolutions;
	}
	
	private List<Map<Character, Integer>> findPossibleCharacterValues(List<Character> charList) {
		List<Map<Character, Integer>> characterValueList = new LinkedList<Map<Character,Integer>>();
		Map<Character, Integer> valueMap;
		int listSize = charList.size();

		// obtain list of permutations of values between 0 - 9 (there can only be max 10 characters)
		Set<List<Integer>> valueSet 
			= permutationGenerator(new HashSet<List<Integer>>(), new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)), 10);
		
		for (List<Integer> l : valueSet) {
			valueMap = new HashMap<Character, Integer>();
			
			for (int i = 0; i < listSize; i++) {
				valueMap.put(charList.get(i), l.get(i));
			}
			
			characterValueList.add(new HashMap<Character, Integer>(valueMap));
		}
		
		return characterValueList;
	}

	/**
	 * Returns a set of lists of all possible permutations to the list given
	 * 
	 * @param list - a list of any type
	 * @return a set of lists containing all possible permutations of list
	 */
	/**
	 * Returns a set of lists of all possible permutations to the list given
	 * 
	 * @param list - a list of any type
	 * @return a set of lists containing all possible permutations of list
	 */
	public static <T> Set<List<T>> permutationGenerator(Set<List<T>> permSet, List<T> list, int n) {
		if (n == 1)
			permSet.add(new ArrayList<T>(list));
		else {
			for (int i = 0; i < (n - 1); i++) {
				permutationGenerator(permSet, list, n - 1);
				if ((n % 2) == 0) 
					Collections.swap(list, i, n - 1);
				else 
					Collections.swap(list, 0, n - 1);
				
			}
			
			permutationGenerator(permSet, list, n - 1);
		}
		
		return permSet;
	}
}
