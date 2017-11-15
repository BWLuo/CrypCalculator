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
	
	/* contains the words before the = */
	private List<String> wordArray;
	/* contains the operators before the = */
	private List<String> operatorArray;
	/* contains the words after the = */ 
	private List<String> answerWordArray;
	/* contains the operators after the */
	private List<String> answerOperatorArray;
	/* contains the characters that are the first letter of a word */
	private Set<Character> firstLetter;
	/* contains the list of unique letters */
	private List<Character> letterList;

	/**
	 * Cryptarithm constructor. Throws exceptions if an invalid cryptarithm is given.
	 * 
	 * @param cryptarithm
	 *            where each element is a String that represents part of the
	 *            cryptarithm
	 * @throws NoSolutionException 
	 */
	public Cryptarithm(String[] cryptarithm) throws NoSolutionException {
		boolean answer = false;
		boolean word = true;
		int numEquals = 0;
		int count = 0;
		String s;
		int size = cryptarithm.length;
		wordArray = new LinkedList<String>();
		operatorArray = new LinkedList<String>();
		answerWordArray = new LinkedList<String>();
		answerOperatorArray = new LinkedList<String>();
		firstLetter = new HashSet<Character>();
		letterList= new LinkedList<Character>();
		
		// check to see if cryptarithm doesn't start or end with '='
		if (cryptarithm[0].equals("=") || cryptarithm[cryptarithm.length - 1].equals("="))
			throw new NoSolutionException("ERROR: '=' is found at the start or end of the equation");
		
		for (String chkEquals : cryptarithm) {
			if (chkEquals.equals("=")) {
				numEquals++;
			}
		}
		
		// ensure only 1 "=" sign is found
		if (numEquals != 1)
			throw new NoSolutionException("ERROR: No '=' found or more than one found");
			
		
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
					if (s.indexOf(c) == 0)  // indicate when its the first letter of the word
						firstLetter.add(c);					
					
					if (letterList.contains(c)) // only add unique letters to letter list
						continue;
					
					letterList.add(c);
				}
				
				// if there are more than 10 unique letters, throw exception
				if (letterList.size() > 10)
					throw new NoSolutionException("ERROR: More than 10 unique letters found");
				
				word = false; // next in the array should be an operator
			} else
				throw new NoSolutionException("ERROR: That is not a valid expression");
			
			count++;
		}
		
		if (word) // last before the = should be a word
			throw new NoSolutionException("ERROR: Last item before '=' should be a word");
		
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
					if (s.indexOf(c) == 0)  // indicate when its the first letter of the word
						firstLetter.add(c);					
					
					if (letterList.contains(c)) // only add unique letters to letter list
						continue;
					
					letterList.add(c);
					
				}
				
				// if there are more than 10 unique letters, throw exception
				if (letterList.size() > 10)
					throw new NoSolutionException("ERROR: More than 10 unique letters found");
				
				word = false; // next in the array should be an operator
			}
			else 
				throw new NoSolutionException("ERROR: That is not a valid expression");
			
			count++;
		}
		
		if (word) // last in the array should be a word
			throw new NoSolutionException("ERROR: Last item in the array should be a word");
		
	}

	/**
	 * Find solutions to the cryptarithm
	 * 
	 * @return a list of all possible solutions to the given cryptarithm. A
	 *         solution is a map that provides the value for each alphabet in
	 *         the cryptarithm.
	 */
	public List<Map<Character, Integer>> solve() throws NoSolutionException {
		List<Map<Character, Integer>> solution = new LinkedList<Map<Character,Integer>>();
		Map<Character, Integer> valueMap;
		int listSize = this.letterList.size();

		// obtain list of permutations of values between 0 - 9 (there can only be max 10 characters)
		Set<List<Integer>> valueSet
			= permutationGenerator(new HashSet<List<Integer>>(), new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)), 10);
		
		outerloop:
		for (List<Integer> l : valueSet) {
			valueMap = new HashMap<Character, Integer>();
		
			// assign a value for each character
			for (int i = 0; i < listSize; i++) {
				valueMap.put(this.letterList.get(i), l.get(i));
			}			
			
			for (Character c : this.firstLetter) {
				if (valueMap.get(c).intValue() == 0) {
					continue outerloop; // don't add the valueMap if the first letter of a word has a value of 0
				}
			}
			
			// add valid solutions to the list if the solution doesn't already exist in the list
			if (equationValue(valueMap, wordArray, operatorArray) == equationValue(valueMap, answerWordArray, answerOperatorArray))
				if (!solution.contains(valueMap))
					solution.add(valueMap);
		}
		
		return solution;
	}
	
	/**
	 * 
	 * Takes an equation of words and operators and return the correct answer.
	 * 
	 * @param valueMap - the value of each character
	 * @param wordList - a list of words used in the equation in order. wordList must not be null or empty
	 * @param operandList - a list of operands used in order. Must have size = wordList.size() - 1
	 * @return the solution to the equation as a double
	 */
	private double equationValue(Map<Character, Integer> valueMap, List<String> wordList, List<String> operandList) {
		double answer = wordValue(valueMap, wordList.get(0));
		int size = wordList.size();
		
		// depending on operand, do operation for each word
		for (int i = 1; i < size; i++) {
			if (operandList.get(i - 1).equals("+"))
				answer += wordValue(valueMap, wordList.get(i));
			else if (operandList.get(i - 1).equals("-")) 
				answer -= wordValue(valueMap, wordList.get(i));
			else if (operandList.get(i - 1).equals("*"))
				answer *= wordValue(valueMap, wordList.get(i));
			else
				answer /= wordValue(valueMap, wordList.get(i));
		}
		
		return answer;
		
	}
	
	/**
	 * 
	 * Find the numerical value of a given word. The value is determined by characters
	 * representing a single digit. 
	 * 
	 * @param valueMap - the value of each character
	 * @param s - the word to find the value of. s cannot be null
	 * @return the value of the word as a double
	 */
	private double wordValue(Map<Character, Integer> valueMap, String s) {
		double answer = 0;
		int size = s.length();
		char[] sArray = s.toCharArray();
		
		for (int i = 0; i < size; i++) {
			// each value is multiplied by a power of 10 according to where they are located
			answer += valueMap.get(sArray[size - (i + 1)]).doubleValue() * Math.pow(10, i);
		}
		
		return answer;
	}

	/**
	 * Returns a set of lists of all possible permutations to the list given.
	 * The permutations are generated using heaps algorithm.
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
