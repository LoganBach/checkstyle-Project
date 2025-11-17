package main.java;

import com.puppycrawl.tools.checkstyle.api.*;


public class ExpressionCheck extends AbstractCheck{

	private int expressionCount = 0;
	
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
		expressionCount++;
	}

	@Override
	public int[] getAcceptableTokens() {
		// TODO Auto-generated method stub
		return new int[] {
				TokenTypes.EXPR
		};
	}

	@Override
	public int[] getRequiredTokens() {
		// TODO Auto-generated method stub
		return getAcceptableTokens();
	}
	
	@Override
	public void beginTree(DetailAST ast) {
		expressionCount = 0;
	}
	
	@Override
	public void finishTree(DetailAST ast) {
		log(0, "Total Expressions: " + expressionCount + "-signature LB");
	}
	
	
}

