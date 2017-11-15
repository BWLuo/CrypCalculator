package ca.ubc.ece.cpen221.mp4.cryptarithm;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SolveCryptarithm {

	static public void main(String[] args) {
		
		List<Map<Character, Integer>> solutions;

		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Enter a cryptarithm:");
			String cryptarithm = scanner.nextLine();
			try {
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
