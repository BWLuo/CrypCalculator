package ca.ubc.ece.cpen221.mp4.tests;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp4.cryptarithm.Cryptarithm;

public class CryptarithmTest {
	@Test
	public void test0() {
		List<Integer> list = Arrays.asList(1, 2, 3);
		System.out.println(Cryptarithm.permutationGenerator(list));
		
	}
}
