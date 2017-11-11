package ca.ubc.ece.cpen221.mp4.tests;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp4.cryptarithm.Cryptarithm;

public class CryptarithmTest {
	@Test
	public void test0() {
		List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		Cryptarithm.permutationGenerator(new HashSet<List<Integer>>(), list, list.size());
		
	}
}
