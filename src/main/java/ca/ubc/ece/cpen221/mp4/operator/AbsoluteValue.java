package ca.ubc.ece.cpen221.mp4.operator;

public class AbsoluteValue implements UnaryOperator {

	public double apply(double arg) {
		if(arg<0) {
			return (-1)*arg;
		}
		else{
			return arg;
		}
	}
	
	@Override
	public String toString() {
		return "abs";
	}

}
