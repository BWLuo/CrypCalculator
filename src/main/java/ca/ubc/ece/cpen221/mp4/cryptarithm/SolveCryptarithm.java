package ca.ubc.ece.cpen221.mp4.cryptarithm;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * SolveCryptarithm - Main program class to continually take in cryptarithm inputs from the user.
 * 					  The program then solves the cryptarithm and prints the solution.
 *
 */
public class SolveCryptarithm {

	static public void main(String[] args) {
		
		List<Map<Character, Integer>> solutions;

		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Enter a cryptarithm:");
			String cryptarithm = scanner.nextLine();
			try {
				// split the string by whitespace into an array and create a new cryptarithm with it
				Cryptarithm crypt = new Cryptarithm(cryptarithm.split("\\s+"));
				solutions = crypt.solve();
				System.out.println(solutions.size() + " solution(s):");
				for (Map<Character, Integer> m : solutions)
					System.out.println(m);
			} catch (Exception e) {
				System.out.println("Please try again.");
			}
		} while (true);

	}
	
}
