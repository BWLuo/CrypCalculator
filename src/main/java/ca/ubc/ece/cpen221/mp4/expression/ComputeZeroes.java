package ca.ubc.ece.cpen221.mp4.expression;

public class ComputeZeroes {
	/**
	 * Returns a zero of the specified function using Newton's method with
	 * approxZero as the initial estimate.
	 * 
	 * @param fn
	 *            the function whose zero is to be found
	 * @param x
	 *            the independent variable of the function
	 * @param approxZero
	 *            initial approximation for the zero of the function
	 * @param tolerance
	 *            how close to zero the returned zero has to be
	 * @return
	 */

	public static double computeZero(Expression fn, VariableExpression x, double approxZero, double tolerance) {
		//function for the derivative
		DerivativeExpression derivative = new DerivativeExpression(fn, x);
	
		
		//iterate to find better Estimates
		double currentApprox = approxZero;
		double successiveEstimate;
		double slope;
		x.store(approxZero);
		double value = fn.eval();
		while(Math.abs(value)<= tolerance) {
			x.store(currentApprox);
			slope = derivative.eval();
			value = fn.eval();
			successiveEstimate = currentApprox - (slope*value);
			currentApprox = successiveEstimate;
			
		}
		return currentApprox;

	}
}
