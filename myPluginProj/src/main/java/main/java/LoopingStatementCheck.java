package main.java;

import com.puppycrawl.tools.checkstyle.api.*;


public class LoopingStatementCheck extends AbstractCheck{

	private int loopCount = 0;
	
	@Override
	public boolean isCommentNodesRequired() {
		return true;
	}
	
	@Override
	public int[] getDefaultTokens() {
		return getAcceptableTokens();
	}
	
	@Override
	public void visitToken(DetailAST ast) {
		loopCount++;
	}

	@Override
	public int[] getAcceptableTokens() {
		// TODO Auto-generated method stub
		return new int[] {
				TokenTypes.LITERAL_FOR,
				TokenTypes.LITERAL_WHILE,
				TokenTypes.LITERAL_DO
		};
	}

	@Override
	public int[] getRequiredTokens() {
		// TODO Auto-generated method stub
		return getAcceptableTokens();
	}
	
	@Override
	public void beginTree(DetailAST ast) {
		loopCount = 0;
	}
	
	@Override
	public void finishTree(DetailAST ast) {
		log(0, "Total Looping Statements: " + loopCount + "-signature LB");
	}
	
	
}

