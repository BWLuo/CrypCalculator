package ca.ubc.ece.cpen221.mp4.expression;

import ca.ubc.ece.cpen221.mp4.operator.BinaryOperator;

public class BinaryOperatorExpression implements Expression {

	private final BinaryOperator operator; 
	private final Expression expression1;
	private final Expression expression2;
	
	public BinaryOperatorExpression(BinaryOperator operator, Expression expression1, Expression expression2) {
		this.operator = operator; 
		this.expression1 = expression1; 
		this.expression2 = expression2; 
	}
	@Override
	public double eval() {
		return operator.apply(this.expression1.eval(), this.expression2.eval());
	}
	
	@Override
	public String toString() {
		return expression1.toString() + operator.toString() + expression2.toString();
	}

}
