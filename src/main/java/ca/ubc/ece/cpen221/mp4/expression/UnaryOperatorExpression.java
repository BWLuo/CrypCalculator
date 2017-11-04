package ca.ubc.ece.cpen221.mp4.expression;

import ca.ubc.ece.cpen221.mp4.operator.UnaryOperator;

public class UnaryOperatorExpression implements Expression {

	public final UnaryOperator operator; 
	public final Expression expression;
	
	public UnaryOperatorExpression( UnaryOperator operator, Expression expression) {
		this.operator = operator;
		this.expression = expression;
	}
	
	@Override
	public double eval() {
		return operator.apply(expression.eval());
	}
	
	@Override 
	public String toString() {
		return operator.toString() + expression.toString();
	}

}
