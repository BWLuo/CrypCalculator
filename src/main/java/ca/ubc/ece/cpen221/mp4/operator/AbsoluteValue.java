package ca.ubc.ece.cpen221.mp4.operator;

public class AbsoluteValue implements UnaryOperator {

	public double apply(double arg) {
		return Math.abs(arg);
	}
	
	@Override
	public String toString() {
		return "abs";
	}

}
