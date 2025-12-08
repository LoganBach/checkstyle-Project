package main.java;

import com.puppycrawl.tools.checkstyle.api.*;


public class SemiColonCheck extends AbstractCheck{

	private int semiCount = 0;
	
	//setter for tests
	public void setCount(int val) {
		semiCount = val;
	}
	
	//getter for tests
	public int getCount() {
		return semiCount;
	}
	
	@Override
	public int[] getDefaultTokens() {
		return getAcceptableTokens();
	}
	
	@Override
	public void visitToken(DetailAST ast) {
		semiCount++;
	}

	@Override
	public int[] getAcceptableTokens() {
		// TODO Auto-generated method stub
		return new int[] {TokenTypes.SEMI};
	}

	@Override
	public int[] getRequiredTokens() {
		// TODO Auto-generated method stub
		return getAcceptableTokens();
	}
	
	@Override
	public void beginTree(DetailAST ast) {
		semiCount = 0;
	}
	
	@Override
	public void finishTree(DetailAST ast) {
		log(0, "Total semicolons: " + semiCount + "-signature LB");
	}
}
