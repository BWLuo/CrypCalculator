package ca.ubc.ece.cpen221.mp4.operator;

public class Multiplication implements BinaryOperator {

	public double apply(double arg1, double arg2) {
		return arg1 * arg2;
	}
	
	@Override
	public String toString() {
		return "*";
	}

}
