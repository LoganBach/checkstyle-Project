package main.java;

import com.puppycrawl.tools.checkstyle.api.*;


public class CommentCheck extends AbstractCheck{

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
				TokenTypes.BLOCK_COMMENT_BEGIN,
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
		log(0, "Total Comments: " + commentCount + "-signature LB");
	}
}
