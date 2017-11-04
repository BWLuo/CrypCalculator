package ca.ubc.ece.cpen221.mp4.expression;

/**
 * DerivativeExpression - The derivative of specific function.
 *
 */
public class DerivativeExpression implements Expression {
	
	private Expression function;
	private VariableExpression independentVar;
	
	private static final double DELTA_X = 1E-9;
		
	/**
	 * Create an expression representing the derivative of the specified
	 * function with respect to the specified variable.
	 * 
	 * @param fn the function whose derivative this expression represents
	 * @param independentVar the variable with respect to which we're
	 * 		  differentiating
	 */
	public DerivativeExpression(Expression fn, 
					VariableExpression independentVar) {
		// TODO implement this constructor
		this.function = fn;
		this.independentVar = independentVar;
	}

	@Override
	public double eval() {
		// TODO implement this method
		
		double y1;
		double y2; 
		
		y1 = this.function.eval();
		this.independentVar.store(independentVar.eval()+DELTA_X);
		y2 = this.function.eval();
		
		return (y2 - y1)/DELTA_X; // change this
	}
	

}
