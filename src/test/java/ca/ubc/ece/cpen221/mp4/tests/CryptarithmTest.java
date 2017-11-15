package ca.ubc.ece.cpen221.mp4.tests;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp4.cryptarithm.Cryptarithm;
import ca.ubc.ece.cpen221.mp4.cryptarithm.NoSolutionException;

public class CryptarithmTest {
	@Test
	public void test0() throws NoSolutionException {
		String[] s = {"SEND", "+", "MORE", "=", "MO", "-", "MONEY"};
		Cryptarithm test = new Cryptarithm(s);
		
	}
}
