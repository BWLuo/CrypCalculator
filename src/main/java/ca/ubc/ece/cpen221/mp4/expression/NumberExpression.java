package ca.ubc.ece.cpen221.mp4.expression;

public class NumberExpression implements Expression {
	
	private final double value;
	
	public NumberExpression(double number) {
		this.value = number;
	}

	@Override
	public double eval() {
		return value;
	}
	
	@Override
	public String toString() {
		return Double.toString(value);
	}

}
