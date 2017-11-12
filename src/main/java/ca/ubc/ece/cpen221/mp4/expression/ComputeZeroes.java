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
		double currentApprox = approxZero;
		double value = 0;
		double slope = 0;
		
		do {
			
			x.store(currentApprox);
			slope = derivative.eval();			
			value = fn.eval();
			currentApprox = currentApprox - (value / slope);
			
		}while(Math.abs(value) >= tolerance);
		
		return currentApprox;

	}
}
