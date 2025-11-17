package main.java;

import com.puppycrawl.tools.checkstyle.api.*;


public class LineCommentCheck extends AbstractCheck{

	private int commentCount = 0;
	
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
		commentCount++;
	}

	@Override
	public int[] getAcceptableTokens() {
		// TODO Auto-generated method stub
		return new int[] {
				TokenTypes.SINGLE_LINE_COMMENT,
		};
	}

	@Override
	public int[] getRequiredTokens() {
		// TODO Auto-generated method stub
		return getAcceptableTokens();
	}
	
	@Override
	public void beginTree(DetailAST ast) {
		commentCount = 0;
	}
	
	@Override
	public void finishTree(DetailAST ast) {
		log(0, "Total Line Comments: " + commentCount + "-signature LB");
	}
	
	
}

