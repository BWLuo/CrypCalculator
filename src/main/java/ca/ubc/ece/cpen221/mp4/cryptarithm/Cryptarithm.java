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
	
	private List<String> wordArray;
	private List<String> operatorArray;
	private List<String> answerWordArray;
	private List<String> answerOperatorArray;
	private Map<Character, Boolean> letterMap;

	/**
	 * Cryptarithm constructor
	 * 
	 * @param cryptarithm
	 *            where each element is a String that represents part of the
	 *            cryptarithm
	 * @throws NoSolutionException 
	 */
	public Cryptarithm(String[] cryptarithm) throws NoSolutionException {
		boolean answer = false;
		boolean word = true;
		int count = 0;
		String s;
		int size = cryptarithm.length;
		wordArray = new LinkedList<String>();
		operatorArray = new LinkedList<String>();
		answerWordArray = new LinkedList<String>();
		answerOperatorArray = new LinkedList<String>();
		letterMap = new HashMap<Character, Boolean>();
		
		// put in all words and operators into its own array before the =
		while (!answer) {
			s = cryptarithm[count];
			
			if (s.equals("="))
				answer = true; // leave this loop but still increment counter by 1 to read past =
			else if ((s.equals("+") | s.equals("-") | s.equals("*") | s.equals("/")) && !word) {
				operatorArray.add(s);
				
				word = true; // next in the array should be a word
			}
			else if (word) {
				wordArray.add(s);
				for (Character c : s.toCharArray()) {
					if (s.indexOf(c) == 0) // indicate when its the first letter of the word
						letterMap.put(c, Boolean.TRUE);
					else if (!letterMap.containsKey(c)) // ensures first letter status doesn't get overwritten
						letterMap.put(c, Boolean.FALSE);
					
				}
				
				// if there are more than 10 unique letters, throw exception
				if (letterMap.size() > 10)
					throw new NoSolutionException();
				
				word = false; // next in the array should be an operator
			} else
				throw new NoSolutionException();
			
			count++;
		}
		
		if (word) // last before the = should be a word
			throw new NoSolutionException();
		
		word = true; // next should be a word
		
		// put in all words and operators into its own array after the =
		while (count < size) {
			s = cryptarithm[count];
			
			if ((s.equals("+") | s.equals("-") | s.equals("*") | s.equals("/")) && !word) {
				answerOperatorArray.add(s);
				
				word = true; // next in the array should be a word
			}
			else if (word) {
				answerWordArray.add(s);
				for (Character c : s.toCharArray()) {
					if (s.indexOf(c) == 0) // indicate when its the first letter of the word
						letterMap.put(c, Boolean.TRUE);
					else if (!letterMap.containsKey(c)) // ensures first letter status doesn't get overwritten
						letterMap.put(c, Boolean.FALSE);
					
				}
				
				// if there are more than 10 unique letters, throw exception
				if (letterMap.size() > 10)
					throw new NoSolutionException();
				
				word = false; // next in the array should be an operator
			}
			else 
				throw new NoSolutionException();
			
			count++;
		}
		
		if (word) // last in the array should be a word
			throw new NoSolutionException();
		
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
