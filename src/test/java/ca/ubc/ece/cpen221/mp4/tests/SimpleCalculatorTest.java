package ca.ubc.ece.cpen221.mp4.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


import org.junit.Test;

import ca.ubc.ece.cpen221.mp4.expression.DerivativeExpression;
import ca.ubc.ece.cpen221.mp4.expression.Expression;
import ca.ubc.ece.cpen221.mp4.expression.NumberExpression;
import ca.ubc.ece.cpen221.mp4.expression.VariableExpression;
import ca.ubc.ece.cpen221.mp4.operator.*;
import ca.ubc.ece.cpen221.mp4.parser.ExpressionMaker;

// TODO you will need to import other packages that has code to test

public class SimpleCalculatorTest {

	// TODO Add more tests
	public static void main(String[] args) {
		VariableExpression variable = new VariableExpression("x");
		System.out.println(variable.name());
		System.out.println(variable.eval());
		ExpressionMaker maker = new ExpressionMaker();
		
		Expression function = maker.createBinaryOperationExpression(new Multiplication(),variable,variable);
		variable.store(10);
		System.out.println(variable.name());
		System.out.println(variable.eval());
		System.out.println(function.eval());
		
		Expression function1 = maker.createBinaryOperationExpression(new Subtraction(), function, new NumberExpression(2));
		System.out.println(function1.eval());
		
		DerivativeExpression derivative = new DerivativeExpression(function1,variable);
		variable.store(0);
		System.out.println(derivative.eval());
		variable.store(1);
		System.out.println(derivative.eval());
		

	}

	@Test
	public void test0() {
		fail("Not implemented");
	}

}