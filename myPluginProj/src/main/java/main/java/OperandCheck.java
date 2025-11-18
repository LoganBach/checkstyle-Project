package main.java;

import com.puppycrawl.tools.checkstyle.api.*;


public class OperandCheck extends AbstractCheck{

	private int operandCount = 0;
	
	@Override
	public int[] getDefaultTokens() {
		return getAcceptableTokens();
	}
	
	@Override
	public void visitToken(DetailAST ast) {
		operandCount++;
	}

	@Override
	public int[] getAcceptableTokens() {
		// TODO Auto-generated method stub
		return new int[] {
			    TokenTypes.IDENT,

			    // numeric constants
			    TokenTypes.NUM_INT,
			    TokenTypes.NUM_LONG,
			    TokenTypes.NUM_FLOAT,
			    TokenTypes.NUM_DOUBLE,

			    // literals
			    TokenTypes.STRING_LITERAL,
			    TokenTypes.CHAR_LITERAL,
			    TokenTypes.LITERAL_TRUE,
			    TokenTypes.LITERAL_FALSE,
			    TokenTypes.LITERAL_NULL
		};
	}

	@Override
	public int[] getRequiredTokens() {
		// TODO Auto-generated method stub
		return getAcceptableTokens();
	}
	
	@Override
	public void beginTree(DetailAST ast) {
		operandCount = 0;
	}
	
	@Override
	public void finishTree(DetailAST ast) {
		log(0, "Total Operands: " + operandCount + "-signature LB");
	}
	
	
}

