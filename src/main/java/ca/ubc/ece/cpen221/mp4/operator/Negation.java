package ca.ubc.ece.cpen221.mp4.operator;

public class Negation implements UnaryOperator {

	public double apply(double arg) {
		return (-1) * arg;
	}
	
	@Override
	public String toString() {
		return "neg";
	}

}
