package ca.ubc.ece.cpen221.mp4.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp4.cryptarithm.Cryptarithm;
import ca.ubc.ece.cpen221.mp4.cryptarithm.NoSolutionException;

public class CryptarithmTest {
	//One Solution Addition
	@Test
	public void addition() throws NoSolutionException {
		String[] s = {"SEND", "+", "MORE", "=", "MONEY"};
		Cryptarithm test = new Cryptarithm(s);
		assertEquals("[{R=8, S=9, D=7, E=5, Y=2, M=1, N=6, O=0}]",test.solve().toString());
	}
	
	
	//Two Solutions Addition 
	@Test
	public void addition2() throws NoSolutionException {
		String[] s = {"JEDER", "+", "LIEBT", "=", "BERLIN"};
		Cryptarithm test = new Cryptarithm(s);
		assertEquals("[{R=8, B=1, D=4, T=2, E=3, I=5, J=6, L=7, N=0}, {R=8, B=1, D=6, T=2, E=3, I=5, J=4, L=9, N=0}]",
				test.solve().toString());
	}
	
	//Many Solutions Subtraction
	@Test
	public void subtraction() throws NoSolutionException{
		String[] s = {"COUNT", "-", "COIN", "=", "SNUB"};
		Cryptarithm test = new Cryptarithm(s);
		assertEquals("[{B=7, C=1, S=9, T=2, U=6, I=8, N=5, O=0}]",test.solve().toString());
	}
	
	//One Solution Division
	@Test
	public void divison() throws NoSolutionException{
		String[] s = {"NORTH", "/", "SOUTH", "=", "EAST", "/", "WEST"};
		Cryptarithm test = new Cryptarithm(s);
		assertEquals("[{A=2, R=3, S=6, T=0, U=9, E=7, W=8, H=4, N=5, O=1}]",test.solve().toString());
	}
	//One Solution Multiplication
	@Test
	public void multiplcation()throws NoSolutionException{
		String[] s = {"AB", "*", "AB", "=", "ACC"};
		Cryptarithm test = new Cryptarithm(s);
		assertEquals("[{A=1, B=2, C=4}]", test.solve().toString());
	}
	//NoSolution
	@Test
	public void noSolution() throws NoSolutionException{
		String[] s = {"I", "+", "CANT", "+", "GET", "=", "NO", "+", "SATISFACTION"};
		Cryptarithm test = new Cryptarithm(s);
		assertTrue(test.solve().isEmpty());
	}
	
	//NoSolutionsException
	@Test(expected = NoSolutionException.class)
	public void test3() throws NoSolutionException{
		String[] s = {"=", "+", "LIEBT", "=", "BERLIN"};
		Cryptarithm test = new Cryptarithm(s);
	}
	@Test(expected = NoSolutionException.class)
	public void test4() throws NoSolutionException{
		String[] s = {"SSAH", "+", "LIEBT", "=","=", "BERLIN"};
		Cryptarithm test = new Cryptarithm(s);
	}
	
	@Test(expected = NoSolutionException.class)
	public void test5() throws NoSolutionException{
		String[] s = {"SSAH", "+", "LIEBT", "LIEBT","=", "BERLIN"};
		Cryptarithm test = new Cryptarithm(s);
	}
	
	@Test(expected = NoSolutionException.class)
	public void test6() throws NoSolutionException{
		String[] s = {"SSAH", "+", "=", "BERLIN"};
		Cryptarithm test = new Cryptarithm(s);
	}
	
	@Test(expected = NoSolutionException.class)
	public void test7() throws NoSolutionException {
		String[] s = {"JEDERNBMAWPEIDHPIOIHW", "+", "LIEBT", "=", "BERLIN"};
		Cryptarithm test = new Cryptarithm(s);
	}
	
	@Test(expected = NoSolutionException.class)
	public void test8() throws NoSolutionException {
		String[] s = {"JEDER", "+", "LIEBT", "=", "BERLIN", "+"};
		Cryptarithm test = new Cryptarithm(s);
	}
}
