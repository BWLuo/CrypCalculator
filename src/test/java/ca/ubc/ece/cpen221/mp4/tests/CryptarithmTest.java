package ca.ubc.ece.cpen221.mp4.tests;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp4.cryptarithm.Cryptarithm;

public class CryptarithmTest {
	@Test
	public void test0() {
		String[] s = {"WORD", "+", "TEST", "=", "HI", "-", "PHONE"};
		Cryptarithm test = new Cryptarithm(s);
		
	}
}
