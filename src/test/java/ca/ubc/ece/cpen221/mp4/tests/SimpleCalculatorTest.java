package ca.ubc.ece.cpen221.mp4.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp4.expression.*;
import ca.ubc.ece.cpen221.mp4.operator.*;

public class SimpleCalculatorTest {
	
	@Test
	public void variableExpression() {
		VariableExpression x = new VariableExpression("x");
		
		assertEquals(0,x.eval(),0.1);
		assertTrue("x = 0.0".equals(x.toString()));
		assertEquals("x", x.name());
		
		x.store(1);
		assertEquals(1,x.eval(),0.1);
	}
	
	@Test
	public void numberExpression() {
		NumberExpression one = new NumberExpression(1);
		
		assertEquals(1,one.eval(),0.1);
		assertEquals("1.0",one.toString());
	}
	
	@Test
	public void unaryOperatorExpression(){
		Negation negation = new Negation();
		AbsoluteValue absoluteValue = new AbsoluteValue();
		
		NumberExpression one = new NumberExpression(1);	
		UnaryOperatorExpression negOne = new UnaryOperatorExpression(negation, one);
		UnaryOperatorExpression absOne = new UnaryOperatorExpression(absoluteValue, one);
		
		assertEquals(-1,negOne.eval(),0.01);
		assertTrue("neg1.0".equals(negOne.toString()));
		
		assertEquals(1,absOne.eval(),0.01);
		assertTrue("abs1.0".equals(absOne.toString()));
	}
	
	@Test
	public void binaryOperatorExpression() {
		Addition addition = new Addition();
		Subtraction subtraction = new Subtraction();
		Multiplication multiplication = new Multiplication();
		Division division = new Division();
		Exponentiation exponentiation = new Exponentiation();
		
		NumberExpression two = new NumberExpression(2);
		
		BinaryOperatorExpression twoPlusTwo = new BinaryOperatorExpression(addition,two,two);
		BinaryOperatorExpression twoMinusTwo = new BinaryOperatorExpression(subtraction,two,two);
		BinaryOperatorExpression twoTimesTwo = new BinaryOperatorExpression(multiplication,two,two);
		BinaryOperatorExpression twoDivideTwo = new BinaryOperatorExpression(division,two,two);
		BinaryOperatorExpression twoPowerTwo = new BinaryOperatorExpression(exponentiation,two,two);
		
		assertEquals(4,twoPlusTwo.eval(),0.01);
		assertEquals(0,twoMinusTwo.eval(),0.01);
		assertEquals(4,twoTimesTwo.eval(),0.01);
		assertEquals(1,twoDivideTwo.eval(),0.01);
		assertEquals(4,twoPowerTwo.eval(),0.01);
		
		assertTrue("2.0+2.0".equals(twoPlusTwo.toString()));
		assertTrue("2.0-2.0".equals(twoMinusTwo.toString()));
		assertTrue("2.0*2.0".equals(twoTimesTwo.toString()));
		assertTrue("2.0/2.0".equals(twoDivideTwo.toString()));
		assertTrue("2.0^2.0".equals(twoPowerTwo.toString()));
	}
	
	@Test
	public void derivativeExpression() {
		VariableExpression x = new VariableExpression("x");
		BinaryOperatorExpression xSquared = new BinaryOperatorExpression(new Multiplication(),x,x);
		DerivativeExpression derivativeXSquared = new DerivativeExpression(xSquared, x);
		
		x.store(0.0);
		assertEquals(0,derivativeXSquared.eval(),0.01);
		x.store(2);
		assertEquals(4,derivativeXSquared.eval(),0.01);
	}
	
	@Test
	public void computeZeroes() {
		Addition addition = new Addition();
		Subtraction subtraction = new Subtraction();
		Multiplication multiplication = new Multiplication();
		ComputeZeroes tester = new ComputeZeroes();
		VariableExpression x = new VariableExpression("x");
		BinaryOperatorExpression xSquared = new BinaryOperatorExpression(multiplication,x,x);
		BinaryOperatorExpression threeX = new BinaryOperatorExpression(multiplication,new NumberExpression(3),x);
		NumberExpression two = new NumberExpression(2);
		
		Expression test1 = new BinaryOperatorExpression(subtraction,xSquared,threeX);
		Expression test2 = new BinaryOperatorExpression(addition,test1,two);
		
		assertEquals(1,ComputeZeroes.computeZero(test2,x,-1.0,0.001),0.01);
		assertEquals(2,ComputeZeroes.computeZero(test2,x,5.0,0.001),0.01);
		

	}

}